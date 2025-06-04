package io.github.oss.api;

import io.github.oss.module.OssAssumeDTO;

public interface OssService {


    /**
     * 获取临时临时访问凭证
     */
    OssAssumeDTO generateExpiration();
}
