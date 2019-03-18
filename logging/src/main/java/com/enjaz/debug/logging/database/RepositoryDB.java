package com.enjaz.debug.logging.database;

import android.content.Context;


import com.enjaz.debug.logging.entities.MemoryMonitoring;
import com.enjaz.debug.logging.entities.NetworkCallInformation;
import com.enjaz.debug.logging.entities.UserActivity;

import java.util.List;

public class RepositoryDB {

    LoggingDao daoInterface;

    public RepositoryDB(Context context) {
        LoggingDB loggingDB = LoggingDB.getInstance(context);
        daoInterface = loggingDB.daoInterface();
    }
    // get all NetworkCallInformation failure

    public NetworkCallInformation getAllNetworkCallInformation() {
        return daoInterface.getAllNetworkCallInformation();

    }
    //get all UserActivity

    public List<UserActivity> getAllUserActivity() {
        return daoInterface.getAllUserActivity();

    }
    //get all MemoryInfo

    public List<MemoryMonitoring> getAllMemoryInfo() {
        return daoInterface.getAllMemoryInfo();

    }
    //get NetworkCallInformation by Id

    public NetworkCallInformation getNetworkCallInformationById(String id) {
        return daoInterface.getNetworkCallInformationById(id);

    }

    //get UserActivity By Id
    public UserActivity getUserActivityById(String id) {
        return daoInterface.getUserActivityById(id);

    }
    //get Memory Info By Id

    public MemoryMonitoring getMemoryInfoById(int id) {
        return daoInterface.getMemoryInfoById(id);

    }
    //insert networkCallInformation

    void insertNetworkCallInformation(NetworkCallInformation networkCallInformation) {
        daoInterface.insertNetworkCallInformation(networkCallInformation);


    }

    //insert userActivity

    void insertUserActivity(UserActivity userActivity) {
        daoInterface.insertUserActivity(userActivity);


    }
    //insert Memory logging

    void insertMemoryLogging(MemoryMonitoring memoryMonitoring) {
        daoInterface.insertMemoryLogging(memoryMonitoring);


    }
    //update userActivity

    void updateUserActivity(int count, String date, String id) {
        daoInterface.Update(count, date, id);


    }


}

