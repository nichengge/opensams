package com.opensams.model.vo;

import lombok.Data;

import java.util.Date;

/**
 * @author Kevin Leung
 */
@Data
public class PermissionVo {

    private Integer id;

    private String permission;

    private String permissionCode;

    private Date createdAt;

    private Date modifiedAt;

}
