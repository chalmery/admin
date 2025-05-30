package io.github.infrastructure.user.dataobject;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("biz_enum")
public class SysUser implements Serializable {


    @TableId(type = IdType.AUTO)
    private Long id;

    private String uuid;

    private String nickName;

    private String avatarUrl;

    private Integer status;

    private Date gmtCreate;

    private Date gmtModify;

}
