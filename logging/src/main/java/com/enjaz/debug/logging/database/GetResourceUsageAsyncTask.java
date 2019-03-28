package com.enjaz.debug.logging.database;

import android.content.Context;

import com.enjaz.debug.logging.entities.ResourceUsage;

import java.util.List;

public class GetResourceUsageAsyncTask extends android.os.AsyncTask<String, Void, List<ResourceUsage>> {
    //get resource usage depend on  time frame
    private RepositoryDB RepositoryDB;

    public GetResourceUsageAsyncTask(Context context) {
        RepositoryDB = new RepositoryDB(context);

    }

    /**
     * get memory usage depend on which time frame selected
     */

    @Override
    protected List<ResourceUsage> doInBackground(String... timeFrame) {
        switch (timeFrame[0]) {
            case "Last Hour":
                return RepositoryDB.getLastHourMemoryInfo();
            case "Last 24 Hours":
                return RepositoryDB.getLast24HoursMemoryInfo();
            case "Last 7 Days":
                return RepositoryDB.getLast7DaysMemoryInfo();
            case "Last 30 Days":
                return RepositoryDB.getLast30DaysMemoryInfo();
            default:
                return RepositoryDB.getLastHourMemoryInfo();

        }


    }

}
