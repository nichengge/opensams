package com.opensams.dal.pojo;

import lombok.Data;

import java.util.Date;

/**
 * @author Kevin Leung
 */
@Data
public class RolePermission {

    private Integer id;

    private String roleCode;

    private String permissionCode;

    private Date createdAt;

    private Date modifiedAt;

}
