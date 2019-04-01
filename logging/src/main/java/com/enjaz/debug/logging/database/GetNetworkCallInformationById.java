package com.enjaz.debug.logging.database;

import android.content.Context;

import com.enjaz.debug.logging.entities.NetworkCallITable;

public class GetNetworkCallInformationById extends android.os.AsyncTask<Void, Void, NetworkCallITable> {
    private com.enjaz.debug.logging.database.RepositoryDB repositoryDB;
    private int id;


    public GetNetworkCallInformationById(Context context, int id) {
        repositoryDB = new RepositoryDB(context);
        this.id = id;
    }

    /**
     * get Network Call Information ById
     */

    @Override
    protected NetworkCallITable doInBackground(Void... voids) {
        return repositoryDB.getNetworkCallInformationById(id);

    }

}