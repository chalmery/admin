package io.github.param;

import io.github.enums.IdentityTypeEnum;
import lombok.Data;

import java.io.Serializable;


@Data
public class UserAuthParam implements Serializable {

    /**
     * 认证唯一标识，登录手机号、邮箱、用户名
     */
    private String identifier;

    /**
     * 认证凭证，密码、验证码
     */
    private String credential;

    /**
     * 认证方式
     *
     * @see IdentityTypeEnum
     */
    private String identityType;
}
