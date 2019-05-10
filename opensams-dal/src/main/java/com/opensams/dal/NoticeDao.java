package com.opensams.dal;

import com.opensams.dal.po.Notice;
import com.opensams.model.PageModel;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Kevin Leung
 */
@Repository
public interface NoticeDao {

    /**
     * 分页获取公告信息，并根据过期时间排序
     * @param pageModel 分页模型
     * @return 公告列表
     */
    List<Notice> queryNoticesPageAndOrderByExpireDate(PageModel pageModel);

    /**
     * 获取公告的数量
     * @return 公告数量
     */
    Integer countNotices();

}
