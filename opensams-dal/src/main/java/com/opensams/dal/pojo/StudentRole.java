package com.opensams.dal.pojo;

import lombok.Data;

import java.util.Date;

/**
 * @author Kevin Leung
 */
@Data
public class StudentRole {

    private Integer id;

    private String studentCode;

    private String roleCode;

    private Date createdAt;

    private Date modifiedAt;

}
