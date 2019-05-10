package com.opensams.model.vo.request;

import lombok.Data;

/**
 * @author Kevin Leung
 */
@Data
public class RegisterRequest {

    private String studentName;

    private String studentId;

    private String studentEmail;

    private String studentCollege;

    private Integer studentAssociation;

    private String studentPassword;

    private String studentRegisterKey;

}
