package com.cheng.system.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * class functional description
 *
 * @author Feng GuiCheng
 * @version 1.0.0
 * @since 2020-06-08
 */
@Data
public class BaseModel implements Serializable {
    Date createdTime;
    UserModel createdBy;
    Date updatedTime;
    UserModel updatedBy;
    Boolean delFlag;

}
