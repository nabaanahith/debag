package com.enjaz.debug.logging.database;

import android.annotation.SuppressLint;
import android.content.Context;


import com.enjaz.debug.logging.entities.UserActivityTable;

import java.util.List;

public class GetAllUserActivityAsyncTask extends android.os.AsyncTask<Void, Void, List<UserActivityTable>> {
    private RepositoryDB repositoryDB;
    @SuppressLint("StaticFieldLeak")

    public GetAllUserActivityAsyncTask(Context context) {

        repositoryDB = new RepositoryDB(context);


    }

    @Override
    protected List<UserActivityTable> doInBackground(Void... voids) {


        return repositoryDB.getAllUserActivity();
    }

}
