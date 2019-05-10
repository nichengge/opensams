package com.opensams.model.dto;

import lombok.Data;

import java.util.Date;

/**
 * @author Kevin Leung
 */
@Data
public class NoticeDto {

    private Integer id;

    private String title;

    private String content;

    private String publisherCode;

    private String publisher;

    private String publishDept;

    private Date createdAt;

    private Date modifiedAt;

}
