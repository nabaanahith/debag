package com.enjaz.debug.logging.view;

import com.enjaz.debug.logging.entities.UserActivity;
import com.enjaz.debug.logging.entities.UserActivityTable;

import java.util.List;

public interface UserViewInterface {
    /*
    onReceiveAllUserActivity
     */
void onReceiveAllUserActivity(List<UserActivityTable>userActivities);


}
