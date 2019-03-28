package com.enjaz.debug.logging.database;

import android.content.Context;


import com.enjaz.debug.logging.entities.UserActivityTable;

import java.util.List;

public class GetUserActivitiesBySelectedPoint extends android.os.AsyncTask<Void, Void, List<UserActivityTable>> {
    private RepositoryDB repositoryDB;
    private String platform;
    private int count;

    public GetUserActivitiesBySelectedPoint(Context context, String platform, int count) {

        repositoryDB = new RepositoryDB(context);
        this.platform = platform;
        this.count = count;
    }
   /*
   get user activity depend on platform type and count
 */

    @Override
    protected List<UserActivityTable> doInBackground(Void... voids) {


        return repositoryDB.getListUserActivatesOfSpecificPoint(platform, count);
    }

}
