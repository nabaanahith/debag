package com.enjaz.debug.logging.entities;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "UserActivity")

public class UserActivity {
    @PrimaryKey
    @NonNull
    private String platformType;
    private String date;

    //   private PlatformType platformType;
    private String classFullName; //class full path
    private String activityName; //user friendly name
    private int count = 0;

    public UserActivity(@NonNull String platformType, String date, String classFullName, String activityName) {
        this.platformType = platformType;
        this.date = date;
        this.classFullName = classFullName;
        this.activityName = activityName;

    }
    //  private Date date;



    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }


    public String getPlatformType() {
        return platformType;
    }

    public void setPlatformType(String platformType) {
        this.platformType = platformType;
    }

    public String getClassFullName() {
        return classFullName;
    }

    public void setClassFullName(String classFullName) {
        this.classFullName = classFullName;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
