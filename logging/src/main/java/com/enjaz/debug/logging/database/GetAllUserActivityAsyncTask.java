package com.enjaz.debug.logging.database;

import android.content.Context;

import com.enjaz.debug.logging.entities.UserActivity;

import java.util.List;

public class GetAllUserActivityAsyncTask extends android.os.AsyncTask<Void, Void, List<UserActivity>> {
   private RepositoryDB RepositoryDB;


    private GetAllUserActivityAsyncTask(Context context, String objectType) {
        RepositoryDB = new RepositoryDB(context);


    }

    @Override
    protected List<UserActivity> doInBackground(Void... weatherResponses) {


        return RepositoryDB.getAllUserActivity();
    }
}
