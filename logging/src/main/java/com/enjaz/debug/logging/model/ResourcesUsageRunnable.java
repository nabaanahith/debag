package com.enjaz.debug.logging.model;

import android.content.Context;

import com.enjaz.debug.logging.database.InsertAsyncTask;
import com.enjaz.debug.logging.entities.ResourceUsage;

import java.util.Date;

public class ResourcesUsageRunnable implements Runnable {
    //var running to start run the thread or stop it by set its value to false
    private static volatile boolean running = true;

    private Context context;

     ResourcesUsageRunnable(Context context) {
        this.context = context;
    }

    @Override
    public void run() {
        while (running) {
            //calculate memory usage using Runtime instance
            final Runtime runtime = Runtime.getRuntime();
            final int usedMemInMB = (int) ((runtime.totalMemory() - runtime.freeMemory()) / 1048576L);
            final int maxHeapSizeInMB = (int) (runtime.maxMemory() / 1048576L);
            final int availHeapSizeInMB = maxHeapSizeInMB - usedMemInMB;

            final int totalMemory = (int) (runtime.totalMemory() / 1048576L);
            final int freeMemory = (int) (runtime.freeMemory() / 1048576L);
            //create instance from ResourceUsage to set the memory usage value and store it in SQLite table
            ResourceUsage memoryMonitoring = new ResourceUsage(totalMemory, freeMemory, usedMemInMB, maxHeapSizeInMB, availHeapSizeInMB, new Date());


            //insert into SQLite ResourceUsage table
            new InsertAsyncTask(context).execute(memoryMonitoring);
            //sleep the thread for 60 second
            try {
                Thread.sleep(60000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //start working
     static void startThread() {
        running = true;
    }

    //stop working
     static void stopThread() {
        running = false;
    }

}
