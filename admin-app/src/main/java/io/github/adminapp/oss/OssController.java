package io.github.adminapp.oss;

import io.github.admindomain.oss.api.OssService;
import io.github.admindomain.oss.module.OssAssumeDTO;
import io.github.common.result.SimpleResult;
import io.github.infrastructure.utils.JsonUtils;
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
        log.info("getPostSignatureForOssUpload-start");
        OssAssumeDTO ossAssumeDTO = ossService.generateExpiration();
        log.info("getPostSignatureForOssUpload-end {}", JsonUtils.toJSONString(ossAssumeDTO));
        return SimpleResult.buildSuccess(ossAssumeDTO);
    }

}
