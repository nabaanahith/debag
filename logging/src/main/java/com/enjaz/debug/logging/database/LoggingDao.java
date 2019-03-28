package com.enjaz.debug.logging.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;


import com.enjaz.debug.logging.entities.NetworkCallITable;
import com.enjaz.debug.logging.entities.ResourceUsage;
import com.enjaz.debug.logging.entities.UserActivityTable;

import java.util.List;

@Dao
public interface LoggingDao {

    //insert networkCallInformation
    @Insert
    void insertNetworkCallInformation(NetworkCallITable networkCallInformation);

    // get all NetworkCall  failure
    @Query("select * from NetworkCallITable  ORDER BY requestDate ASC")
    List<NetworkCallITable> getAllNetworkInformation();

    //get NetworkCallITable by day
    @Query("select * from NetworkCallITable where day= :day")
    List<NetworkCallITable> getNetworkCallInformationByDay(String day);

    //get NetworkCall  by id
    @Query("select * from NetworkCallITable where failureId= :id")
    NetworkCallITable getNetworkCallInformationById(int id);

    //count number of row in NetworkCallITable table
    @Query("select count(*) from NetworkCallITable")
    Integer getNumberOfNetworkFailure();

    //insert userActivity
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertUserActivity(UserActivityTable userActivity);

   //get UserActivity by platform type and limit count
    @Query("select * from UserActivityTable where platformType= :platform  limit :count")
    List<UserActivityTable> getListUserActivatesOfSpecificPoint(String platform, int count);
    //get all UserActivity from UserActivity table
    @Query("select * from UserActivityTable")
    List<UserActivityTable> getAllUserActivity();

    //get UserActivity by platform type and limit count
    @Query("select * from UserActivityTable where platformType= :platform")
    List<UserActivityTable> getListUserActivatesOfSpecificPoint(String platform);

    //get UserActivity by id
    @Query("select * from UserActivityTable where id= :id")
    UserActivityTable getUserActivityById(int id);

    //get number of activity
    @Query("select count(*) from UserActivityTable")
    Integer getNumberOfUserActivity();


    //insert Memory usage info
    @Insert
    void insertMemoryLogging(ResourceUsage resourceUsage);

    //get all Memory usage
    @Query("SELECT * FROM ResourceUsage  WHERE ResourceUsage.date= :hours ")
    ResourceUsage getMemoryInfoByDate(Long hours);

    //get last Hour Memory usage
    @Query("SELECT * FROM ResourceUsage  WHERE ResourceUsage.date  >= strftime('%s', 'now', '-1 hour')")
    List<ResourceUsage> getLastHourMemoryInfo();

    //get last 24 hours  Memory usage
    @Query("SELECT * FROM ResourceUsage  WHERE ResourceUsage.date >= strftime('%s', 'now', '-24 hours')")
    List<ResourceUsage> getLast24HoursMemoryInfo();

    //get last 7 Days Memory usage
    @Query("SELECT * FROM ResourceUsage  WHERE ResourceUsage.date >= strftime('%s', 'now', '-7 days')")
    List<ResourceUsage> getLast7DaysMemoryInfo();

    //get Last 30 days  Memory usage
    @Query("SELECT * FROM ResourceUsage  WHERE ResourceUsage.date  >= strftime('%s', 'now', '-30 days')")
    List<ResourceUsage> getLast30DaysMemoryInfo();


    //get MemoryInfo by Id
    @Query("select * from ResourceUsage where memoryId= :id")
    ResourceUsage getMemoryInfoById(int id);


    @Query("select max(totalMemory) from ResourceUsage")
    Integer getMaxRecourseUsage();


}
