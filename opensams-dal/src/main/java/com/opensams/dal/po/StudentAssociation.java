package com.opensams.dal.po;

import lombok.Data;

import java.util.Date;

/**
 * @author Kevin Leung
 */
@Data
public class StudentAssociation {

    private Integer id;

    private String studentCode;

    private Integer associationId;

    private Date createdAt;

    private Date modifiedAt;

}
