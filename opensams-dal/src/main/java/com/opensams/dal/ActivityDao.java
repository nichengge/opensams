package com.opensams.dal;

import com.opensams.dal.po.Activity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Kevin Leung
 */
@Repository
public interface ActivityDao {

    /**
     * 分页查询社团活动信心
     * @param activity {@link Activity}
     * @return 社团活动信息列表
     */
    List<Activity> queryActivitiesPage(Activity activity);

}
