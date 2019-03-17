package com.enjaz.debug.logging.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;


import com.enjaz.debug.logging.entities.MemoryMonitoring;
import com.enjaz.debug.logging.entities.NetworkCallInformation;
import com.enjaz.debug.logging.entities.UserActivity;

import java.util.List;

@Dao
public interface LoggingDao {

    // get all NetworkCallInformation failure from Sqlite Database

    @Query("select * from NetworkCallInformation")
    NetworkCallInformation getAllNetworkCallInformation();


    //get all UserActivity from UserActivity table

    @Query("select * from UserActivity")
    List<UserActivity> getAllUserActivity();


    //get all Memory logging from table

    @Query("select * from MemoryMonitoring")
    List<MemoryMonitoring> getAllMemoryInfo();

    //get NetworkCallInformation by Id

    @Query("select * from NetworkCallInformation where failureId= :id")
    NetworkCallInformation getNetworkCallInformationById(String id);

    //get UserActivity by Id
    @Query("select * from UserActivity where platformType= :id")
    UserActivity getUserActivityById(String id);

    //get MemoryInfo by Id
    @Query("select * from MemoryMonitoring where memoryId= :id")
    MemoryMonitoring getMemoryInfoById(int id);

    //insert networkCallInformation
    @Insert
    void insertNetworkCallInformation(NetworkCallInformation networkCallInformation);

    //insert userActivity
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertUserActivity(UserActivity userActivity);

    //insert Memory logging
    @Insert
    void insertMemoryLogging(MemoryMonitoring memoryMonitoring);

    //update userActivity
    @Query("UPDATE UserActivity SET count=:description ,date=:date WHERE platformType =:id")
    void Update(int description, String date, String id);

}
