package com.opensams.dal.pojo;

import lombok.Data;

import java.util.Date;

/**
 * @author Kevin Leung
 */
@Data
public class Role {

    private Integer id;

    private String role;

    private String roleCode;

    private Date createdAt;

    private Date modifiedAt;

}
