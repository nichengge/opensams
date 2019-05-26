package com.opensams.model.dto;

import lombok.Data;

import java.util.Date;

/**
 * @author Kevin Leung
 */
@Data
public class StudentAssociationDto {

    private Integer id;

    private String studentCode;

    private Integer associationId;

    private Date createdAt;

    private Date modifiedAt;

}
