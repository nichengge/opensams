package com.opensams.dal;

import com.opensams.dal.po.Activity;

import java.util.List;

/**
 * @author Kevin Leung
 */
public interface ActivityDao {

    List<Activity> queryActivitiesPage(Activity activity);

}
