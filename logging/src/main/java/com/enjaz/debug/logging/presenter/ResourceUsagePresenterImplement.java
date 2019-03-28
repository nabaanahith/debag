package com.enjaz.debug.logging.presenter;

import android.content.Context;
import android.util.Log;

import com.enjaz.debug.logging.database.GetResourceUsageAsyncTask;
import com.enjaz.debug.logging.database.GetResourceUsageByDate;
import com.enjaz.debug.logging.entities.ResourceUsage;
import com.enjaz.debug.logging.model.ResourceUsageImplement;
import com.enjaz.debug.logging.view.ResourceUsageInterface;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class ResourceUsagePresenterImplement implements ResourceUsagePresenterInterface {
    private Context context;
    private ResourceUsageInterface resourceUsageInterface;
    private ResourceUsageImplement resourceUsageImplement;

    public ResourceUsagePresenterImplement(Context context, ResourceUsageInterface resourceUsageInterface) {
        this.context = context;
        this.resourceUsageInterface = resourceUsageInterface;
        resourceUsageImplement = new ResourceUsageImplement(context);

    }

    public ResourceUsagePresenterImplement(Context context) {
        this.context = context;
        resourceUsageImplement = new ResourceUsageImplement(context);

    }

    /*
     *get all
     * resource usage from db
     * */
    public void onSuccess(String timeFrame) {

        resourceUsageInterface.onSuccess(resourceUsageImplement.getAllResourceUsage(timeFrame));


    }

    /*
     *get all
     * resource usage by date from db
     * */
    @Override
    public void GetMemoryUsageByDate(Long date) {

        resourceUsageInterface.geResourceUsageById(resourceUsageImplement.getResourceUsageBayDate(date));


    }
    /*
     *enable Memory Monitoring
     * */

    @Override
    public void enableMemoryMonitoring() {
        resourceUsageImplement.enableMemoryMonitoring();

    }
    /*
     *disable  Memory Monitoring
     * */

    @Override
    public void disableMemoryMonitoring() {
        resourceUsageImplement.disableMemoryMonitoring();

    }
}
