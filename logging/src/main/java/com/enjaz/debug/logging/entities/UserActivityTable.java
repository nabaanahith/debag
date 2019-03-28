package com.enjaz.debug.logging.entities;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;
import android.support.annotation.NonNull;
@Entity
public class UserActivityTable {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    int id;
    private String dayMonthYear;
    @TypeConverters(PlatformConverter.class)
    private PlatformType platformType;
    private long date;
    private String classFullName;
    private String activityName;
    private String  day;


    public UserActivityTable(String dayMonthYear, PlatformType platformType, String day, long date, String classFullName, String activityName) {
        this.dayMonthYear = dayMonthYear;
        this.platformType = platformType;
        this.date = date;
        this.classFullName = classFullName;
        this.activityName = activityName;
        this.day = day;

    }

//  private Date date;

    public String getDayMonthYear() {
        return dayMonthYear;
    }

    public void setDayMonthYear(String dayMonthYear) {
        this.dayMonthYear = dayMonthYear;
    }

    public int getId()
    {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }


    public PlatformType getPlatformType() {
        return platformType;
    }
    public void setPlatformType(PlatformType platformType) {
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

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }
}
