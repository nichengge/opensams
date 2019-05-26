package com.opensams.model.dto;

import lombok.Data;

import java.util.Date;

/**
 * @author Kevin Leung
 */
@Data
public class PermissionDto {

    private Integer id;

    private String permission;

    private String permissionCode;

    private Date createdAt;

    private Date modifiedAt;

}
