package com.enjaz.debug.logging.database;

import android.content.Context;
import android.os.AsyncTask;

import com.enjaz.debug.logging.entities.NetworkCallITable;
import com.enjaz.debug.logging.entities.ResourceUsage;
import com.enjaz.debug.logging.entities.UserActivityTable;

public class InsertAsyncTask extends AsyncTask<Object, Void, Void> {
     private  RepositoryDB RepositoryDB;

    public InsertAsyncTask(Context context) {
        RepositoryDB = new RepositoryDB(context);

    }

    @Override
    protected Void doInBackground(Object... objects) {
        //check which type of object
        if (objects[0] instanceof NetworkCallITable) {
            RepositoryDB.insertNetworkCallInformation((NetworkCallITable) objects[0]);
        } else if (objects[0] instanceof UserActivityTable)
            RepositoryDB.insertUserActivity((UserActivityTable) objects[0]);
        else if (objects[0] instanceof ResourceUsage)
            RepositoryDB.insertMemoryLogging((ResourceUsage) objects[0]);
        return null;
    }
}