package com.opensams.dal.po;

import lombok.Data;

import java.util.Date;

/**
 * @author Kevin Leung
 */
@Data
public class Permission {

    private Integer id;

    private String permission;

    private String permissionCode;

    private Date createdAt;

    private Date modifiedAt;

}
