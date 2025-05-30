package io.github.admindomain.oss.api;

import io.github.admindomain.oss.module.OssAssumeDTO;

public interface OssService {


    /**
     * 获取临时临时访问凭证
     */
    OssAssumeDTO generateExpiration();
}
