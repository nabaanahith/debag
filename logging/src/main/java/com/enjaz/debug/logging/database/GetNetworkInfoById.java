package com.enjaz.debug.logging.database;

import android.content.Context;

import com.enjaz.debug.logging.entities.NetworkCallInformation;

public class GetNetworkInfoById extends android.os.AsyncTask<Void, Void, NetworkCallInformation> {
    private RepositoryDB RepositoryDB;
   private String id;

    private GetNetworkInfoById(Context context, String id) {
        RepositoryDB = new RepositoryDB(context);
        this.id = id;
    }

    @Override
    protected NetworkCallInformation doInBackground(Void... weatherResponses) {


        return RepositoryDB.getNetworkCallInformationById(id);
    }
}
