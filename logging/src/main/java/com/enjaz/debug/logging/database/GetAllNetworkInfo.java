package com.enjaz.debug.logging.database;

import android.content.Context;

import com.enjaz.debug.logging.entities.NetworkCallITable;

import java.util.List;

public class GetAllNetworkInfo extends android.os.AsyncTask<Void, Void, List<NetworkCallITable>> {
    /* return all Network Failure */
    private RepositoryDB repositoryDB;


    public GetAllNetworkInfo(Context context) {
        repositoryDB = new RepositoryDB(context);

    }

    @Override
    protected List<NetworkCallITable> doInBackground(Void... voids) {


        return repositoryDB.getAllNetworkInformation();
    }






}

