package com.enjaz.debug.logging.database;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;

public class DeleteAsyncTask extends AsyncTask<Void,Void,Void> {
    @SuppressLint("StaticFieldLeak")
    private Context context;

    /* delete all table in db */

    public DeleteAsyncTask(Context context) {
        this.context = context;
    }
    @Override
    protected Void doInBackground(Void... voids) {
        LoggingDB.getInstance(context).clearAllTables();
        return null;
    }
}
