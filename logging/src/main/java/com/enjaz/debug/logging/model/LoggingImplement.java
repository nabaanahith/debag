package com.enjaz.debug.logging.model;

import android.content.Context;
import android.widget.Toast;

import com.enjaz.debug.logging.database.InsertAsyncTask;
import com.enjaz.debug.logging.database.RepositoryDB;
import com.enjaz.debug.logging.entities.MemoryMonitoring;
import com.enjaz.debug.logging.entities.NetworkCallInformation;
import com.enjaz.debug.logging.entities.UserActivity;


import java.util.List;
import java.util.concurrent.ExecutionException;

public class LoggingImplement implements LoggingInterface {
    private Context context;

    public LoggingImplement(Context context) {
        this.context = context;

    }

//background process to storeFailedNetworkCalls..execute async task
    @Override
    public void storeFailedNetworkCalls(NetworkCallInformation info) {

        new InsertAsyncTask(context).execute(info);

    }
    //background process to storeUserActivity..execute async task
    @Override
    public void storeUserActivity(UserActivity activity) {
        new InsertAsyncTask(context).execute(activity);
    }
    //enableMemoryMonitoring to count the usage of memory

    @Override
    public void enableMemoryMonitoring() {

    }
    //desable MemoryMonitoring
    @Override
    public void disableMemoryMonitoring() {

    }


}
