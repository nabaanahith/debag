package com.enjaz.debug.logging.entities;

public class UserActivityForDB {
    private PlatformType platformType;
    private long date;
    private String classFullName;
    private String activityName;

    public UserActivityForDB(PlatformType platformType, long date, String classFullName, String activityName) {
        this.platformType = platformType;
        this.date = date;
        this.classFullName = classFullName;
        this.activityName = activityName;
    }

    public PlatformType getPlatformType() {
        return platformType;
    }

    public void setPlatformType(PlatformType platformType) {
        this.platformType = platformType;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
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
}
