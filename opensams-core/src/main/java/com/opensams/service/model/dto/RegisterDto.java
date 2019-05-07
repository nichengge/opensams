package com.opensams.service.model.dto;

import lombok.Data;

/**
 * @author Kevin Leung
 */
@Data
public class RegisterDto {

    private String studentName;

    private String studentId;

    private String studentEmail;

    private String studentCollege;

    private Integer studentAssociation;

    private String studentPassword;

    private String studentRegisterKey;

}
