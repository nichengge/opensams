package com.opensams.model.vo;

import lombok.Data;

/**
 * @author Kevin Leung
 */
@Data
public class ActivityVo {

    private Integer id;

    private String name;

    private String spot;

    private String association;

    private String startTime;

    private String endTime;

    private Integer number;

    private String principal;

    private String teacher;

    private String description;

    private String createdAt;

    private String modifiedAt;

}
