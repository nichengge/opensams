package com.opensams.model.vo;

import lombok.Data;

/**
 * @author Kevin Leung
 */
@Data
public class NoticeVo {

    private Integer id;

    private String title;

    private String content;

    private String publishTime;

    private String publisher;

    private String publishDept;

}
