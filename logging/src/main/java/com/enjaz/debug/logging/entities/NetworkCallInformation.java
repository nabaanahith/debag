package com.enjaz.debug.logging.entities;

public class NetworkCallInformation {
    private String OSVersion;
    private int sdkVersion;
    private String userToken;
    private String mobileModel;
    private String mobileNumber;
    private String applicationVersion;
    private String deviceLanguage;
    private String requestUrl;
    private String requestParameters;
    private String responseMessage;
    private long requestDate;
    private String requestName;

    public NetworkCallInformation(String OSVersion, int sdkVersion, String userToken, String mobileModel, String mobileNumber, String applicationVersion, String deviceLanguage) {
        this.OSVersion = OSVersion;
        this.sdkVersion = sdkVersion;
        this.userToken = userToken;
        this.mobileModel = mobileModel;
        this.mobileNumber = mobileNumber;
        this.applicationVersion = applicationVersion;
        this.deviceLanguage = deviceLanguage;

    }

    public NetworkCallInformation(String OSVersion, int sdkVersion, String userToken, String mobileModel, String mobileNumber, String applicationVersion, String deviceLanguage, String requestUrl, String requestParameters, String responseMessage, long requestDate, String requestName) {
        this.OSVersion = OSVersion;
        this.sdkVersion = sdkVersion;
        this.userToken = userToken;
        this.mobileModel = mobileModel;
        this.mobileNumber = mobileNumber;
        this.applicationVersion = applicationVersion;
        this.deviceLanguage = deviceLanguage;
        this.requestUrl = requestUrl;
        this.requestParameters = requestParameters;
        this.responseMessage = responseMessage;
        this.requestDate = requestDate;
        this.requestName = requestName;
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

    public String getRequestUrl() {
        return requestUrl;
    }

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }

    public String getRequestParameters() {
        return requestParameters;
    }

    public void setRequestParameters(String requestParameters) {
        this.requestParameters = requestParameters;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public long getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(long requestDate) {
        this.requestDate = requestDate;
    }


    public String getRequestName() {
        return requestName;
    }

    public void setRequestName(String requestName) {
        this.requestName = requestName;
    }
}
