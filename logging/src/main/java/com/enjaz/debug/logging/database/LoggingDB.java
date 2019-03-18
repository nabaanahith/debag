package com.enjaz.debug.logging.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.enjaz.debug.logging.entities.MemoryMonitoring;
import com.enjaz.debug.logging.entities.NetworkCallInformation;
import com.enjaz.debug.logging.entities.UserActivity;


@Database(entities={NetworkCallInformation.class, UserActivity.class,MemoryMonitoring.class}, version = 1, exportSchema = false)


  //preparing  for room db synchronized
    public abstract class LoggingDB extends RoomDatabase

    {
        private static LoggingDB instance;

        public abstract LoggingDao daoInterface();

        public static synchronized LoggingDB getInstance(Context context) {
            if (instance == null) {
                instance = Room.databaseBuilder(context, LoggingDB.class, "logging_db")

                        .fallbackToDestructiveMigration().build();
            }
            return instance;
        }


}
