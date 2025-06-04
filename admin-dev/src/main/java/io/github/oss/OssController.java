package io.github.oss;

import io.github.oss.api.OssService;
import io.github.oss.module.OssAssumeDTO;
import io.github.result.SimpleResult;
import io.github.utils.ExceptionUtils;
import io.github.utils.JsonUtils;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/oss")
@Slf4j
public class OssController {


    @Resource
    private OssService ossService;


    /**
     * 获取临时token
     */
    @GetMapping("/getPostSignatureForOssUpload")
    public SimpleResult<OssAssumeDTO> getPostSignatureForOssUpload() {
        try {
            log.info("getPostSignatureForOssUpload-start");
            OssAssumeDTO ossAssumeDTO = ossService.generateExpiration();
            log.info("getPostSignatureForOssUpload-end {}", JsonUtils.toJSONString(ossAssumeDTO));
            return SimpleResult.buildSuccess(ossAssumeDTO);
        } catch (Exception e) {
            log.error("getPostSignatureForOssUpload-error {}", ExceptionUtils.toString(e));
            return SimpleResult.buildError("服务异常");
        }
    }

}
