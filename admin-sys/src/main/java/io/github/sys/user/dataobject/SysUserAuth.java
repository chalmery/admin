package io.github.sys.user.dataobject;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.github.common.dataobject.CommonDataObject;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@TableName("sys_user_auth")
public class SysUserAuth extends CommonDataObject {

    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 认证唯一标识，登录手机号、邮箱、用户名
     */
    private String identifier;

    /**
     * 认证凭证，密码、验证码
     */
    private String credential;

    /**
     * 类型
     *
     * @see io.github.enums.IdentityTypeEnum
     */
    private String identityType;

    /**
     * 是否验明，0未验证，1已验证
     */
    private String verified;


    private String uuid;

}
