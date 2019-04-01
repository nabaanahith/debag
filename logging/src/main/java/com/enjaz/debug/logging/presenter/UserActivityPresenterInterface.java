package com.enjaz.debug.logging.presenter;


import com.enjaz.debug.logging.entities.UserActivityTable;

import java.util.List;

public interface UserActivityPresenterInterface {
    /**
     * get UerActivity By Id
     */

    UserActivityTable getUerActivityById(int id);

    /**
     * get user Activity List By Selected Point
     */

    List<UserActivityTable> getUserActivityListBySelectedPoint(String label, int y);

    /**
     * get All User Activity
     */
   void getAllUserActivity();


}
