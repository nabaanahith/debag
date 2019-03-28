package com.enjaz.debug.logging.database;

import android.content.Context;

import com.enjaz.debug.logging.entities.NetworkCallITable;

import java.util.List;

public class GetNetworkCallInformationByDay extends android.os.AsyncTask<Void, Void, List<NetworkCallITable>> {
    private com.enjaz.debug.logging.database.RepositoryDB RepositoryDB;
    private String day;


    public GetNetworkCallInformationByDay(Context context, String day) {
        RepositoryDB = new RepositoryDB(context);
        this.day = day;
    }

    @Override
    protected List<NetworkCallITable> doInBackground(Void... voids) {
        return RepositoryDB.getNetworkCallInformationByDay(day);

    }


}