package com.enjaz.debug.logging.database;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;

public class GetDashBordInfoASyncTask extends AsyncTask<String, Void, Integer> {
    private RepositoryDB repositoryDB;

    @SuppressLint("StaticFieldLeak")


    public GetDashBordInfoASyncTask(Context context) {

        repositoryDB = new RepositoryDB(context);


    }

    /**
     * get count depend on type
     */

    @Override
    protected Integer doInBackground(String... type) {
        if (type[0].equals("NetWorkInfo"))
            return repositoryDB.getNumberOfNetworkFailure();
        else if (type[0].equals("UserActivity"))
            return repositoryDB.getNumberOfUserActivity();
        else if (type[0].equals("ResourceUsage"))
            return repositoryDB.getMaxRecourseUsage();
        return null;
    }
}
