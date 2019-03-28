package com.enjaz.debug.logging.entities;

/* class will save only user info get from request failure */
public class UserInfo {
    private String OSVersion;
    private int sdkVersion;
    private String userToken;
    private String mobileModel;
    private String mobileNumber;
    private String applicationVersion;
    private String deviceLanguage;

    public UserInfo(String OSVersion, int sdkVersion, String userToken, String mobileModel, String mobileNumber, String applicationVersion, String deviceLanguage) {
        this.OSVersion = OSVersion;
        this.sdkVersion = sdkVersion;
        this.userToken = userToken;
        this.mobileModel = mobileModel;
        this.mobileNumber = mobileNumber;
        this.applicationVersion = applicationVersion;
        this.deviceLanguage = deviceLanguage;
    }

    public String getOSVersion() {
        return OSVersion;
    }

    public void setOSVersion(String OSVersion) {
        this.OSVersion = OSVersion;
    }

    public int getSdkVersion() {
        return sdkVersion;
    }

    public void setSdkVersion(int sdkVersion) {
        this.sdkVersion = sdkVersion;
    }

    public String getUserToken() {
        return userToken;
    }

    public void setUserToken(String userToken) {
        this.userToken = userToken;
    }

    public String getMobileModel() {
        return mobileModel;
    }

    public void setMobileModel(String mobileModel) {
        this.mobileModel = mobileModel;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getApplicationVersion() {
        return applicationVersion;
    }

    public void setApplicationVersion(String applicationVersion) {
        this.applicationVersion = applicationVersion;
    }

    public String getDeviceLanguage() {
        return deviceLanguage;
    }

    public void setDeviceLanguage(String deviceLanguage) {
        this.deviceLanguage = deviceLanguage;
    }
}
