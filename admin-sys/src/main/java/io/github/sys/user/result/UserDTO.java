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
    private String nickName;

    /**
     * 头像url
     */
    private String avatarUrl;

    /**
     * 状态
     */
    private Integer status;
}
