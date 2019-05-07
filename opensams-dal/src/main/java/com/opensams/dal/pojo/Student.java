package com.opensams.dal.pojo;

import lombok.Data;

import java.util.Date;

/**
 * @author Kevin Leung
 */
@Data
public class Student {

    private Integer id;

    private String studentName;

    private String studentCode;

    private Date birthday;

    private String sex;

    private String mail;

    private String phone;

    private String qq;

    private String college;

    private String major;

    private String avatar;

    private String loginName;

    private String loginPwd;

    private String description;

    private Date createdAt;

    private Date modifiedAt;

}
