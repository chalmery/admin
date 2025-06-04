
package io.github.common.dataobject;


import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class CommonDataObject implements Serializable {


    /**
     * 创建时间
     */
    private Date gmtCreate;

    /**
     * 修改时间
     */
    private Date gmtModify;

    /**
     * 删除标识
     */
    private Integer archive;


    /**
     * 创建人id
     */
    private String createUserId;

    /**
     * 创建人name
     */
    private String createUserName;


    /**
     * 修改人id
     */
    private String updateUserId;

    /**
     * 修改人name
     */
    private String updateUserName;
}
