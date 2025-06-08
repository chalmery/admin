package io.github.sys.user.result;


import lombok.Data;

import java.io.Serializable;

@Data
public class UserDTO implements Serializable {

    /**
     * 客户信息唯一标识
     */
    private String uuid;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 头像url
     */
    private String avatarUrl;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 账号名称
     */
    private String userName;


    /**
     * 手机号
     */
    private String phoneNum;

    /**
     * 邮箱
     */
    private String email;

}
