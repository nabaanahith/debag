package com.enjaz.debug.logging.presenter;

import android.content.Context;

import com.enjaz.debug.logging.entities.UserActivityTable;
import com.enjaz.debug.logging.entities.UserActivity;
import com.enjaz.debug.logging.helper.Common;
import com.enjaz.debug.logging.model.UserActivityImplement;
import com.enjaz.debug.logging.model.UserActivityInterface;
import com.enjaz.debug.logging.view.UserViewActivity;
import com.enjaz.debug.logging.view.UserViewInterface;

import java.text.SimpleDateFormat;
import java.util.List;

public class UserActivityPresenterImplement implements UserActivityPresenterInterface {
    private Context context;
    UserViewInterface userActivityInterface;
    private UserActivityImplement userActivityModelImplement;

    public UserActivityPresenterImplement(Context context) {
        this.context = context;
        userActivityModelImplement = new UserActivityImplement(context);
    }

    public UserActivityPresenterImplement(Context context, UserViewInterface userActivityInterface) {
        this.context = context;
        userActivityModelImplement = new UserActivityImplement(context);
        this.userActivityInterface = userActivityInterface;
    }
    /* get All User Activity */

    public void getAllUserActivity() {
        userActivityInterface.onReceiveAllUserActivity(userActivityModelImplement.getAllUserActivities());


    }

    /* select one record by id to get all same date */

    public UserActivityTable getUerActivityById(int id) {
        return userActivityModelImplement.GetUserActivityByLabel(id);
    }

    /* get all users activates in same date */
    public List<UserActivityTable> getUserActivityListBySelectedPoint(String platform, int count) {
        return userActivityModelImplement.GetUserActivityByLabel(platform, count);
    }

    /**
     * store user activity tov db
     */

    public void storeUserActivity(UserActivity activity) {

        final UserActivityTable userActivity = new UserActivityTable(Common.getDayMonthYear(activity.getDate()), activity.getPlatformType(),
                Common.getDay(activity.getDate()), activity.getDate(), activity.getClassFullName(), activity.getActivityName());
        userActivityModelImplement.storeUserActivity(userActivity);

    }
}
