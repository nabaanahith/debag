package com.enjaz.debug.logging.database;

import android.content.Context;

import com.enjaz.debug.logging.entities.ResourceUsage;

import java.util.Date;
import java.util.List;

public class GetResourceUsageByDate extends android.os.AsyncTask<Long, Void, ResourceUsage> {
    //get all resource usage info by date
    private RepositoryDB repositoryDB;

    public GetResourceUsageByDate(Context context) {
        repositoryDB = new RepositoryDB(context);

    }
    /*
    get Memory Info By Date
     */

    @Override
    protected ResourceUsage doInBackground(Long... dates) {
        return repositoryDB.getMemoryInfoByDate(dates[0]);


    }

}
