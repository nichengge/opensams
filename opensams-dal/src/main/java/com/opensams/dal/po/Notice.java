package com.opensams.dal.po;

import com.opensams.model.PageModel;
import lombok.Data;

import java.util.Date;

/**
 * @author Kevin Leung
 */
@Data
public class Notice extends PageModel {

    private Integer id;

    private String title;

    private String content;

    private String publisherCode;

    private Date createdAt;

    private Date modifiedAt;

}
