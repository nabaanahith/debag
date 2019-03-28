package com.enjaz.debug.logging.model;

import android.content.Context;
import android.widget.Toast;

import com.enjaz.debug.logging.database.GetAllUserActivityAsyncTask;
import com.enjaz.debug.logging.database.GetUserActivitiesBySelectedPoint;
import com.enjaz.debug.logging.database.GetUserActivityById;
import com.enjaz.debug.logging.database.InsertAsyncTask;
import com.enjaz.debug.logging.entities.UserActivityTable;


import java.util.List;
import java.util.concurrent.ExecutionException;

public class UserActivityImplement implements UserActivityInterface {
    private Context context;

    public UserActivityImplement(Context context) {
        this.context = context;

    }
    /* get all user Activities  from DB */

    public List<UserActivityTable> getAllUserActivities() {
        List<UserActivityTable> userActivities = null;
        try {
            /* execute the Async task to get the count from DB */
            userActivities = new GetAllUserActivityAsyncTask(context).execute().get();
            return userActivities;
        }


        /* for handling exception */ catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
            Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();

        }


        return null;
    }


    //get All User Activities
    public List<UserActivityTable> GetUserActivityByLabel(String platform, int count) {
        List<UserActivityTable> userActivities = null;

        try {
            /* execute the Async task to get the count from DB */
            userActivities = new GetUserActivitiesBySelectedPoint(context, platform,count).execute().get();

            return userActivities;
        }
        /* for handling exception */ catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
            Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();

        }

        return null;
    }

    /* get User Activity */

    public UserActivityTable GetUserActivityByLabel(int id) {
        UserActivityTable userActivity = null;

        try {
            /* execute the Async task to get the count from DB */


            userActivity = new GetUserActivityById(context, id).execute().get();

            return userActivity;
        }
        /* for handling exception */ catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
            Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();

        }

        return null;
    }

    /* store in db */
    public void storeUserActivity(UserActivityTable activity) {
        new InsertAsyncTask(context).execute(activity);
    }


}
