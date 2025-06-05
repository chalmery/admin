package io.github.sys.user.dataobject;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.github.common.dataobject.CommonDataObject;
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
     */
    private Integer status;

}
