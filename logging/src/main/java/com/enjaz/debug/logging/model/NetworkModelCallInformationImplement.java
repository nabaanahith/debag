package com.enjaz.debug.logging.model;

import android.content.Context;


import com.enjaz.debug.logging.database.GetAllNetworkInfo;

import com.enjaz.debug.logging.database.GetNetworkCallInformationByDay;
import com.enjaz.debug.logging.database.GetNetworkCallInformationById;

import com.enjaz.debug.logging.database.InsertAsyncTask;
import com.enjaz.debug.logging.entities.NetworkCallITable;
import com.enjaz.debug.logging.entities.NetworkCallInformation;
import com.enjaz.debug.logging.helper.Common;


import java.util.List;
import java.util.concurrent.ExecutionException;

public class NetworkModelCallInformationImplement implements NetworkCallInformationInterface {
    private Context context;
    private PreferencesImplement preferencesModel;


    public NetworkModelCallInformationImplement(Context context) {
        this.context = context;
        preferencesModel = new PreferencesImplement(context);
    }

    /**
     * getAllNetworkInformation
     */

    @Override
    public List<NetworkCallITable> getAllNetworkInformation() {
        /**
         *
         * execute Async task
         *
         */
        try {

            return new GetAllNetworkInfo(context).execute().get();
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * get All
     * Network Information By Day
     */
    @Override
    public List<NetworkCallITable> getAllNetworkInformationByDay(String day) {
        try {
            return new GetNetworkCallInformationByDay(context, day).execute().get();
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    /*
     * get Network Rows By Id
     */
    public NetworkCallITable getNetworkRowsById(int id) {
        NetworkCallITable networkCallInformation = null;
        try {
            networkCallInformation = new GetNetworkCallInformationById(context, id).execute().get();
            return networkCallInformation;
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();

        }


        return null;


    }

    /**
     * get List Of
     * Network
     * RowsSelectedPoint
     */
    public List<NetworkCallITable> getListOfNetworkRowsSelectedPoint(String day) {
        List<NetworkCallITable> networkCallInformations = null;
        try {
            networkCallInformations = new GetNetworkCallInformationByDay(context, day).execute().get();
            return networkCallInformations;
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();

        }
        return null;
    }

    /**
     * storeFailedNetworkCalls
     */
    public void storeFailedNetworkCalls(NetworkCallInformation userInfo) {
        saveInPreferences(userInfo);
        NetworkCallITable networkCallInformationForDB = new NetworkCallITable(userInfo.getRequestUrl(), userInfo.getRequestParameters(), userInfo.getResponseMessage(), userInfo.getRequestDate(), userInfo.getRequestName(), Common.formatDate(userInfo.getRequestDate()));
        new InsertAsyncTask(context).execute(networkCallInformationForDB);

    }

    /**
     * saveInPreferences
     */
    private void saveInPreferences(NetworkCallInformation networkCallInformation) {
        NetworkCallInformation userInfo = new NetworkCallInformation(networkCallInformation.getOSVersion(), networkCallInformation.getSdkVersion(), networkCallInformation.getUserToken(), networkCallInformation.getMobileModel(), networkCallInformation.getMobileNumber(), networkCallInformation.getApplicationVersion(), networkCallInformation.getDeviceLanguage());
        preferencesModel.saveInPreferences(userInfo);

    }
}
