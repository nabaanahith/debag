package com.enjaz.debug.logging.database;

import android.content.Context;
import android.os.AsyncTask;

import com.enjaz.debug.logging.entities.MemoryMonitoring;
import com.enjaz.debug.logging.entities.NetworkCallInformation;
import com.enjaz.debug.logging.entities.UserActivity;

public class InsertAsyncTask extends AsyncTask<Object, Void, Void> {
     private  RepositoryDB RepositoryDB;

    public InsertAsyncTask(Context context) {
        RepositoryDB = new RepositoryDB(context);

    }

    @Override
    protected Void doInBackground(Object... objects) {
        //check which type of object
        if (objects[0] instanceof NetworkCallInformation) {
            RepositoryDB.insertNetworkCallInformation((NetworkCallInformation) objects[0]);
        } else if (objects[0] instanceof UserActivity)
            RepositoryDB.insertUserActivity((UserActivity) objects[0]);
        else if (objects[0] instanceof MemoryMonitoring)
            RepositoryDB.insertMemoryLogging((MemoryMonitoring) objects[0]);
        return null;
    }
}