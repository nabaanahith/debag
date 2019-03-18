package com.enjaz.debug.logging.database;

import android.content.Context;

import com.enjaz.debug.logging.entities.MemoryMonitoring;
import com.enjaz.debug.logging.entities.NetworkCallInformation;
import com.enjaz.debug.logging.entities.UserActivity;

public class UpdateAsyncTask extends android.os.AsyncTask<Object, Void, Void> {
    private RepositoryDB RepositoryDB;

    private UpdateAsyncTask(Context context) {
        RepositoryDB = new RepositoryDB(context);

    }

    @Override
    protected Void doInBackground(Object... objects) {
        if (objects[0] instanceof NetworkCallInformation) {

        } else if (objects[0] instanceof UserActivity)
            RepositoryDB.updateUserActivity(((UserActivity) objects[0]).getCount(), ((UserActivity) objects[0]).getDate(), ((UserActivity) objects[0]).getPlatformType());
        else if (objects[0] instanceof MemoryMonitoring) {

        }


        return null;
    }
}