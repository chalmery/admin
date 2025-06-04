package io.github.oss.module;

import lombok.Data;

import java.io.Serializable;


@Data
public class OssAssumeDTO implements Serializable {

    private String version;

    private String policy;

    private String xOssCredential;

    private String xOssDate;

    private String signature;

    private String securityToken;

    private String dir;

    private String host;
}
