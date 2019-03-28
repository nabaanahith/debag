package com.enjaz.debug.logging.database;

import android.content.Context;

import com.enjaz.debug.logging.entities.UserActivityTable;


public class GetUserActivityById extends android.os.AsyncTask<Void, Void, UserActivityTable> {
    //get activity by id
    private com.enjaz.debug.logging.database.RepositoryDB repositoryDB;
    private int id;

    public GetUserActivityById(Context context, int id) {

        repositoryDB = new RepositoryDB(context);

        this.id = id;
    }



    @Override
    protected UserActivityTable doInBackground(Void... voids) {


        return repositoryDB.getUserActivityById(id);
    }


}