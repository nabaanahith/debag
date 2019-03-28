package com.enjaz.debug.logging.model;

import android.content.Context;

import com.enjaz.debug.logging.database.GetResourceUsageAsyncTask;
import com.enjaz.debug.logging.database.GetResourceUsageByDate;
import com.enjaz.debug.logging.database.LoggingDB;
import com.enjaz.debug.logging.entities.ResourceUsage;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class ResourceUsageImplement implements ResourceUsageInterface {
    private Context context;

    public ResourceUsageImplement(Context context) {
        this.context = context;

    }
    /*
     * enable Memory
     *  Monitoring
     * */

    @Override
    public void enableMemoryMonitoring() {
        Thread thread = new Thread(new ResourcesUsageRunnable(context));
        thread.start();
        ResourcesUsageRunnable.startThread();


    }

    //disable ResourceUsage
    @Override
    public void disableMemoryMonitoring() {
        ResourcesUsageRunnable.stopThread();

    }
    /*
     *get All Resource Usage
     * */

    @Override
    public List<ResourceUsage> getAllResourceUsage(String timeFrame) {


        try {
            return new GetResourceUsageAsyncTask(context).execute(timeFrame).get();


        } catch (ExecutionException | InterruptedException ignored) {

        }
        return null;
    }

    /*
     *get Resource Usage
     * Bay
     *  Date
     * */
    @Override
    public ResourceUsage getResourceUsageBayDate(long date) {


        try {
            return new GetResourceUsageByDate(context).execute(date).get();


        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
