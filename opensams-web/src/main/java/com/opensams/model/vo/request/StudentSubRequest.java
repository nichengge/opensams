package com.opensams.model.vo.request;

import lombok.Data;

/**
 * @author Kevin Leung
 */
@Data
public class StudentSubRequest {

    private String studentName;

    private String studentCode;

    private String birthday;

    private String sex;

    private String mail;

    private String localMail;

    private String phone;

    private String qq;

    private String college;

    private String major;

    private String loginPwd;

    private String description;

    private Integer associationId;

    private String roleCode;

}
