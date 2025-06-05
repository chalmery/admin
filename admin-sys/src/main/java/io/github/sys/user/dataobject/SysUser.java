package io.github.sys.user.dataobject;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.github.common.dataobject.CommonDataObject;
import io.github.sys.user.enums.UserStatusEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@TableName("sys_user")
public class SysUser extends CommonDataObject {

    @TableId(type = IdType.AUTO)
    private Long id;

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
     * @see UserStatusEnum
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
