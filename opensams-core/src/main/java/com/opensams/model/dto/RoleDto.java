package com.opensams.model.dto;

import lombok.Data;

import java.util.Date;

/**
 * @author Kevin Leung
 */
@Data
public class RoleDto {

    private Integer id;

    private String role;

    private String roleCode;

    private Date createdAt;

    private Date modifiedAt;

}
