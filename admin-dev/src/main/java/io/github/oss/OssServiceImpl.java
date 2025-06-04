package io.github.oss;


import com.aliyun.oss.common.utils.BinaryUtil;
import com.aliyun.sts20150401.models.AssumeRoleRequest;
import com.aliyun.sts20150401.models.AssumeRoleResponse;
import com.aliyun.sts20150401.models.AssumeRoleResponseBody;
import com.aliyun.teautil.models.RuntimeOptions;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.common.utils.DateUtils;
import io.github.common.utils.ExceptionUtils;
import io.github.oss.api.OssService;
import io.github.oss.module.OssAssumeDTO;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;
import org.springframework.stereotype.Service;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class OssServiceImpl implements OssService {

    @Resource
    private com.aliyun.sts20150401.Client ossClient;

    //OSS基础信息 替换为实际的 bucket 名称、 region-id、host。
    String bucket = "web-admin-bucket";
    String region = "cn-beijing";
    //限定上传到OSS的文件前缀。
    String upload_dir = "admin";

    //指定过期时间，单位为秒。
    Long expire_time = 3600L;


    /**
     * 获取临时临时访问凭证
     */
    @Override
    public OssAssumeDTO generateExpiration() {
        try {
            //获取临时凭证
            AssumeRoleRequest assumeRoleRequest = new AssumeRoleRequest()
                    // 必填，请确保代码运行环境设置了环境变量 OSS_STS_ROLE_ARN
                    .setRoleArn(System.getenv("OSS_STS_ROLE_NAME"))
                    .setRoleSessionName("oss-upload-session");// 自定义会话名称
            RuntimeOptions runtime = new RuntimeOptions();

            AssumeRoleResponse response = ossClient.assumeRoleWithOptions(assumeRoleRequest, runtime);
            // credentials里包含了后续要用到的AccessKeyId、AccessKeySecret和SecurityToken。
            AssumeRoleResponseBody.AssumeRoleResponseBodyCredentials sts_data = response.body.credentials;

            String accesskeyid = sts_data.accessKeyId;
            String accesskeysecret = sts_data.accessKeySecret;
            String securitytoken = sts_data.securityToken;

            //获取x-oss-credential里的date，当前日期，格式为yyyyMMdd
            LocalDate today = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
            String date = today.format(formatter);

            //获取x-oss-date
            ZonedDateTime now = ZonedDateTime.now().withZoneSameInstant(java.time.ZoneOffset.UTC);
            DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyyMMdd'T'HHmmss'Z'");
            String x_oss_date = now.format(formatter2);

            // 步骤1：创建policy。
            String x_oss_credential = accesskeyid + "/" + date + "/" + region + "/oss/aliyun_v4_request";

            ObjectMapper mapper = new ObjectMapper();

            Map<String, Object> policy = new HashMap<>();
            policy.put("expiration", DateUtils.getFutureTimeInUtc(expire_time));

            List<Object> conditions = new ArrayList<>();

            Map<String, String> bucketCondition = new HashMap<>();
            bucketCondition.put("bucket", bucket);
            conditions.add(bucketCondition);

            Map<String, String> securityTokenCondition = new HashMap<>();
            securityTokenCondition.put("x-oss-security-token", securitytoken);
            conditions.add(securityTokenCondition);

            Map<String, String> signatureVersionCondition = new HashMap<>();
            signatureVersionCondition.put("x-oss-signature-version", "OSS4-HMAC-SHA256");
            conditions.add(signatureVersionCondition);

            Map<String, String> credentialCondition = new HashMap<>();
            credentialCondition.put("x-oss-credential", x_oss_credential); // 替换为实际的 access key id
            conditions.add(credentialCondition);

            Map<String, String> dateCondition = new HashMap<>();
            dateCondition.put("x-oss-date", x_oss_date);
            conditions.add(dateCondition);

            conditions.add(Arrays.asList("content-length-range", 1, 10240000));
            conditions.add(Arrays.asList("eq", "$success_action_status", "200"));
            conditions.add(Arrays.asList("starts-with", "$key", upload_dir));

            policy.put("conditions", conditions);

            String jsonPolicy = mapper.writeValueAsString(policy);

            // 步骤2：构造待签名字符串（StringToSign）。
            String stringToSign = new String(Base64.encodeBase64(jsonPolicy.getBytes()));
            // System.out.println("stringToSign: " + stringToSign);

            // 步骤3：计算SigningKey。
            byte[] dateKey = hmacsha256(("aliyun_v4" + accesskeysecret).getBytes(), date);
            byte[] dateRegionKey = hmacsha256(dateKey, region);
            byte[] dateRegionServiceKey = hmacsha256(dateRegionKey, "oss");
            byte[] signingKey = hmacsha256(dateRegionServiceKey, "aliyun_v4_request");
            // System.out.println("signingKey: " + BinaryUtil.toBase64String(signingKey));

            // 步骤4：计算Signature。
            byte[] result = hmacsha256(signingKey, stringToSign);
            String signature = BinaryUtil.toHex(result);
            // System.out.println("signature:" + signature);


            OssAssumeDTO ossAssumeDTO = new OssAssumeDTO();
            // 将数据添加到 map 中
            ossAssumeDTO.setVersion("OSS4-HMAC-SHA256");
            ossAssumeDTO.setPolicy(stringToSign);
            ossAssumeDTO.setXOssCredential(x_oss_credential);
            ossAssumeDTO.setXOssDate(x_oss_date);
            ossAssumeDTO.setSignature(signature);
            ossAssumeDTO.setSecurityToken(securitytoken);
            ossAssumeDTO.setDir(upload_dir);
            ossAssumeDTO.setHost("http://web-admin-bucket.oss-cn-beijing.aliyuncs.com");

            return ossAssumeDTO;

        } catch (Exception e) {
            log.error("generateExpiration-error {}", ExceptionUtils.toString(e));
        }
        return null;
    }

    public static byte[] hmacsha256(byte[] key, String data) {
        try {
            // 初始化HMAC密钥规格，指定算法为HMAC-SHA256并使用提供的密钥。
            SecretKeySpec secretKeySpec = new SecretKeySpec(key, "HmacSHA256");
            // 获取Mac实例，并通过getInstance方法指定使用HMAC-SHA256算法。
            Mac mac = Mac.getInstance("HmacSHA256");
            // 使用密钥初始化Mac对象。
            mac.init(secretKeySpec);
            // 执行HMAC计算，通过doFinal方法接收需要计算的数据并返回计算结果的数组。
            byte[] hmacBytes = mac.doFinal(data.getBytes());
            return hmacBytes;
        } catch (Exception e) {
            throw new RuntimeException("Failed to calculate HMAC-SHA256", e);
        }
    }
}
