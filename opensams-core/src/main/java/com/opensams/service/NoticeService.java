package com.opensams.service;

import com.opensams.model.dto.NoticeDto;

import java.util.List;

/**
 * @author Kevin Leung
 */
public interface NoticeService {

    /**
     * 分页查询公告信息
     * @param start start
     * @param offset offset
     * @return 公告列表
     */
    List<NoticeDto> queryNoticesPage(int start, int offset);

    /**
     * 获取公告数量
     * @return 公告数量
     */
    Integer getTotalNotices();

}
