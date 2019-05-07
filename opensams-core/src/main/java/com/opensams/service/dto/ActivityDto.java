package com.opensams.service.dto;

import com.opensams.model.PageModel;
import lombok.Data;

import java.util.Date;

/**
 * @author Kevin Leung
 */
@Data
public class ActivityDto extends PageModel {

    private Integer id;

    private String name;

    private String spot;

    private String association;

    private Date startTime;

    private Date endTime;

    private Integer number;

    private String principal;

    private String teacher;

    private String description;

    private Date createdAt;

    private Date modifiedAt;

}
