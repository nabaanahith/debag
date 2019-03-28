package com.enjaz.debug.logging.database;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;
import android.content.Intent;

import com.enjaz.debug.logging.entities.NetworkCallITable;
import com.enjaz.debug.logging.entities.PlatformConverter;
import com.enjaz.debug.logging.entities.ResourceUsage;
import com.enjaz.debug.logging.entities.UserActivityTable;

import java.util.Calendar;

import static android.content.Context.ALARM_SERVICE;


@Database(entities = {NetworkCallITable.class, UserActivityTable.class, ResourceUsage.class}, version = 2, exportSchema = false)
@TypeConverters(PlatformConverter.class)


//preparing  for room db synchronized
public abstract class LoggingDB extends RoomDatabase

{
    private static LoggingDB instance;


    public abstract LoggingDao daoInterface();

    //create instance of db
    public static synchronized LoggingDB getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context, LoggingDB.class, "logging_db")

                    .fallbackToDestructiveMigration().build();
                /*when first usage of app initial alarm manger
                 to start count time to delete db after each 30 day*/
            startService(context);


        }
        return instance;
    }

    private static void startService(Context context) {
        //intent of BroadcastReceiver
        Intent intent = new Intent(context, DeleteBroadcastReceiver.class);
        //set reguest code and flag to PendingIntent
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 10, intent, PendingIntent.FLAG_CANCEL_CURRENT);
        //initial alarm manger
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(ALARM_SERVICE);

        //get current date
        Calendar calendar = Calendar.getInstance();
        //set repeating alarm manger to trigger each 30 day
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis() + AlarmManager.INTERVAL_DAY * 30, AlarmManager.INTERVAL_DAY * 30, pendingIntent);
    }


}
