package com.opensams.model.dto;

import lombok.Data;

import java.util.Date;

/**
 * @author Kevin Leung
 */
@Data
public class AssociationDto {

    private Integer id;

    private String name;

    private String founder;

    private String founderCode;

    private String type;

    private String avatar;

    private String spot;

    private String description;

    private Date createdAt;

    private Date modifiedAt;

}
