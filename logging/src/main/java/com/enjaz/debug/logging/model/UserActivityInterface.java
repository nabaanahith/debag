package com.enjaz.debug.logging.model;

import com.enjaz.debug.logging.entities.UserActivityTable;


import java.util.List;

public interface UserActivityInterface {

    /**
     * getAllUserActivities
     */
    List<UserActivityTable> getAllUserActivities();

    /**
     * GetUserActivityByLabel
     */
    List<UserActivityTable> GetUserActivityByLabel(String platform, int count);

    /**
     * GetUserActivityByLabel
     */
    UserActivityTable GetUserActivityByLabel(int id);


}
