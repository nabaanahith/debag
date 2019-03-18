package com.enjaz.debug.logging.database;

import android.content.Context;

import com.enjaz.debug.logging.entities.MemoryMonitoring;

import java.util.List;

public class GetAllMemoryInfoAsyncTask
        extends android.os.AsyncTask<Void, Void, List<MemoryMonitoring>> {
    private RepositoryDB RepositoryDB;

    private GetAllMemoryInfoAsyncTask(Context context) {
        RepositoryDB = new RepositoryDB(context);

    }

    @Override
    protected List<MemoryMonitoring> doInBackground(Void... voids) {


        return RepositoryDB.getAllMemoryInfo();
    }
}
