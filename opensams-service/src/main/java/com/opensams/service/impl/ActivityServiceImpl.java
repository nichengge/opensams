package com.opensams.service.impl;

import com.google.common.collect.Maps;
import com.opensams.dal.ActivityDao;
import com.opensams.dal.po.Activity;
import com.opensams.service.ActivityService;
import com.opensams.service.dto.ActivityDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author Kevin Leung
 */
@Service("activityService")
public class ActivityServiceImpl implements ActivityService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ActivityServiceImpl.class);

    @Resource
    private ActivityDao activityDao;

    @Override
    public Map<String, List<ActivityDto>> showActivitiesInDashboard() {
        Activity activity = new Activity();
        activity.setStart(0);
        activity.setOffset(10);
        List<Activity> activities1 = activityDao.queryActivitiesPage(activity);
        activity.setStart(10);
        activity.setOffset(10);
        List<Activity> activities2 = activityDao.queryActivitiesPage(activity);

        List<ActivityDto> activityDtos1 = activities1.stream()
                .filter(Objects::nonNull)
                .map(this::convertToActivityDto)
                .collect(Collectors.toList());

        List<ActivityDto> activityDtos2 = activities2.stream()
                .filter(Objects::nonNull)
                .map(this::convertToActivityDto)
                .collect(Collectors.toList());

        Map<String, List<ActivityDto>> dashboardActivitiesMap = Maps.newHashMap();
        dashboardActivitiesMap.put("activities1", activityDtos1);
        dashboardActivitiesMap.put("activities2", activityDtos2);

        return dashboardActivitiesMap;
    }

    private ActivityDto convertToActivityDto(Activity activity) {
        ActivityDto activityDto = new ActivityDto();

        activityDto.setId(activity.getId());
        activityDto.setName(activity.getName());
        activityDto.setSpot(activity.getSpot());
        activityDto.setAssociation(activity.getAssociation());
        activityDto.setStartTime(activity.getStartTime());
        activityDto.setEndTime(activity.getEndTime());
        activityDto.setNumber(activity.getNumber());
        activityDto.setPrincipal(activity.getPrincipal());
        activityDto.setTeacher(activity.getTeacher());
        activityDto.setDescription(activity.getDescription());
        activityDto.setCreatedAt(activity.getCreatedAt());
        activityDto.setModifiedAt(activity.getModifiedAt());

        return activityDto;
    }
}
