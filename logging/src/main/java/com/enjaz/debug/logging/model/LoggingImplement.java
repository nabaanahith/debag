package com.enjaz.debug.logging.model;

import android.content.Context;
import android.widget.Toast;

import com.enjaz.debug.logging.database.InsertAsyncTask;
import com.enjaz.debug.logging.database.RepositoryDB;
import com.enjaz.debug.logging.entities.MemoryMonitoring;
import com.enjaz.debug.logging.entities.NetworkCallInformation;
import com.enjaz.debug.logging.entities.UserActivity;


import java.util.List;
import java.util.concurrent.ExecutionException;

public class LoggingImplement implements LoggingInterface {
    private Context context;

    public LoggingImplement(Context context) {
        this.context = context;

    }


    @Override
    public void storeFailedNetworkCalls(NetworkCallInformation info) {

        new InsertAsyncTask(context).execute(info);

    }

    @Override
    public void storeUserActivity(UserActivity activity) {
        new InsertAsyncTask(context).execute(activity);
    }

    @Override
    public void enableMemoryMonitoring() {

    }

    @Override
    public void disableMemoryMonitoring() {

    }





    private static class GetNetworkCallInformationByIdAsyncTask extends android.os.AsyncTask<Void, Void, NetworkCallInformation> {
        RepositoryDB RepositoryDB;

        private GetNetworkCallInformationByIdAsyncTask(Context context) {
            RepositoryDB = new RepositoryDB(context);

        }

        @Override
        protected NetworkCallInformation doInBackground(Void... voids) {

            //check which type of object

            return RepositoryDB.getAllNetworkCallInformation();
        }
    }

    private static class GetAllMemoryInfoAsyncTask extends android.os.AsyncTask<Void, Void, List<MemoryMonitoring>> {
        RepositoryDB RepositoryDB;

        private GetAllMemoryInfoAsyncTask(Context context) {
            RepositoryDB = new RepositoryDB(context);

        }

        @Override
        protected List<MemoryMonitoring> doInBackground(Void... voids) {


            return RepositoryDB.getAllMemoryInfo();
        }
    }

    private static class GetAllUserActivityAsyncTask extends android.os.AsyncTask<Void, Void, List<UserActivity>> {
        RepositoryDB RepositoryDB;

        private GetAllUserActivityAsyncTask(Context context) {
            RepositoryDB = new RepositoryDB(context);

        }

        @Override
        protected List<UserActivity> doInBackground(Void... weatherResponses) {


            return RepositoryDB.getAllUserActivity();
        }
    }

    private static class GetNetworkInfoById extends android.os.AsyncTask<Void, Void, NetworkCallInformation> {
        RepositoryDB RepositoryDB;
        String id;

        private GetNetworkInfoById(Context context, String id) {
            RepositoryDB = new RepositoryDB(context);
            this.id = id;
        }

        @Override
        protected NetworkCallInformation doInBackground(Void... weatherResponses) {


            return RepositoryDB.getNetworkCallInformationById(id);
        }
    }

    private static class GetUserActivityById extends android.os.AsyncTask<Void, Void, UserActivity> {
        RepositoryDB RepositoryDB;
        String id;

        private GetUserActivityById(Context context, String id) {

            RepositoryDB = new RepositoryDB(context);
            this.id = id;
        }

        @Override
        protected UserActivity doInBackground(Void... weatherResponses) {


            return RepositoryDB.getUserActivityById(id);
        }
    }

    private static class UpdateUserActivityAsyncTask extends android.os.AsyncTask<UserActivity, Void, Void> {
        RepositoryDB RepositoryDB;

        private UpdateUserActivityAsyncTask(Context context) {
            RepositoryDB = new RepositoryDB(context);

        }

        @Override
        protected Void doInBackground(UserActivity... userActivities) {
            RepositoryDB.updateUserActivity(userActivities[0].getCount(), userActivities[0].getDate(), userActivities[0].getPlatformType());
            return null;
        }
    }
}
