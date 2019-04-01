package com.enjaz.debug.logging.database;

import android.content.Context;


import com.enjaz.debug.logging.entities.NetworkCallITable;
import com.enjaz.debug.logging.entities.ResourceUsage;
import com.enjaz.debug.logging.entities.UserActivityTable;

import java.util.List;

public class RepositoryDB {

    private LoggingDao daoInterface;

    public RepositoryDB(Context context) {
        LoggingDB loggingDB = LoggingDB.getInstance(context);
        daoInterface = loggingDB.daoInterface();
    }

    //insert networkCallInformation
    void insertNetworkCallInformation(NetworkCallITable networkCallInformation) {
        daoInterface.insertNetworkCallInformation(networkCallInformation);


    }

    NetworkCallITable getNetworkCallInformationById(int id) {
        return daoInterface.getNetworkCallInformationById(id);

    }

    // get all NetworkCallITable failure
    public List<NetworkCallITable> getAllNetworkInformation() {
        return daoInterface.getAllNetworkInformation();

    }

    //get number of all network failure
    Integer getNumberOfNetworkFailure() {
        return daoInterface.getNumberOfNetworkFailure();
    }


    //insert userActivity
    void insertUserActivity(UserActivityTable userActivity) {
        daoInterface.insertUserActivity(userActivity);


    }

    //get all UserActivity
    List<UserActivityTable> getAllUserActivity() {
        return daoInterface.getAllUserActivity();

    }

    //get UserActivityTable By Id
    UserActivityTable getUserActivityById(int id) {
        return daoInterface.getUserActivityById(id);

    }

    //get info of clicked point
    List<UserActivityTable> getListUserActivatesOfSpecificPoint(String platform) {
        return daoInterface.getListUserActivatesOfSpecificPoint(platform);

    }//get info of clicked point
    List<UserActivityTable> getListUserActivatesOfSpecificPoint(String platform, int count) {
        return daoInterface.getListUserActivatesOfSpecificPoint(platform, count);

    }
    //get number of all user activity

    Integer getNumberOfUserActivity() {
        return daoInterface.getNumberOfUserActivity();
    }

    //insert memory info
    void insertMemoryLogging(ResourceUsage memoryMonitoring) {
        daoInterface.insertMemoryLogging(memoryMonitoring);
    }

    //get all MemoryInfo
    List<ResourceUsage> getLastHourMemoryInfo() {
        return daoInterface.getLastHourMemoryInfo();

    }

    //get all MemoryInfo by date
    ResourceUsage getMemoryInfoByDate(Long date) {
        return daoInterface.getMemoryInfoByDate(date);

    }


    //get  Last24 Hours MemoryInfo
    List<ResourceUsage> getLast24HoursMemoryInfo() {
        return daoInterface.getLast24HoursMemoryInfo();

    }
    //get Last 7 Days MemoryInfo

    List<ResourceUsage> getLast7DaysMemoryInfo() {
        return daoInterface.getLast7DaysMemoryInfo();

    }
    //get Last 30 Days MemoryInfo

    List<ResourceUsage> getLast30DaysMemoryInfo() {
        return daoInterface.getLast30DaysMemoryInfo();

    }

    //get number of all memory info
    Integer getMaxRecourseUsage() {
        if(daoInterface.getMaxRecourseUsage()==null){
            return  0;
        }
        else {
        return daoInterface.getMaxRecourseUsage() ;
    }}


     List<NetworkCallITable> getNetworkCallInformationByDay(String day) {
        return daoInterface.getNetworkCallInformationByDay(day);
    }
}

