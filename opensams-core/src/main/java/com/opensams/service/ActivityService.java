package com.opensams.service;

import com.opensams.model.dto.ActivityDto;

import java.util.List;
import java.util.Map;

/**
 * @author Kevin Leung
 */
public interface ActivityService {

    /**
     * 在看板上显示社团活动
     * @return 社团活动列表
     */
    Map<String, List<ActivityDto>> showActivitiesInDashboard();

}
