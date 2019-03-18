package com.enjaz.debug.logging.database;

import android.content.Context;

import com.enjaz.debug.logging.entities.UserActivity;

public class GetUserActivityById extends android.os.AsyncTask<Void, Void, UserActivity> {
   private RepositoryDB RepositoryDB;
   private String id;

    private GetUserActivityById(Context context, String id) {

        RepositoryDB = new RepositoryDB(context);
        this.id = id;
    }

    @Override
    protected UserActivity doInBackground(Void... weatherResponses) {


        return RepositoryDB.getUserActivityById(id);
    }

}
