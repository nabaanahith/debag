package com.enjaz.debug.logging.entities;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "NetworkCallInformation")
public class NetworkCallInformation implements Serializable {


    @PrimaryKey(autoGenerate = true)
    private int failureId;
    private String OSVersion;
    private int sdkVersion;
    private String applicationVersion;
    private String requestUrl;
    private String requestParameters;
    private String responseMessage;
    private String userToken;
    private String mobileModel;
    private String mobileNumber;
    private String requestDate;
    private String requestName;
    private String deviceLanguage;


    public NetworkCallInformation(String OSVersion, int sdkVersion, String applicationVersion, String requestUrl, String requestParameters, String responseMessage, String userToken, String mobileModel, String mobileNumber, String requestDate, String requestName, String deviceLanguage) {

        this.OSVersion = OSVersion;
        this.sdkVersion = sdkVersion;
        this.applicationVersion = applicationVersion;
        this.requestUrl = requestUrl;
        this.requestParameters = requestParameters;
        this.responseMessage = responseMessage;
        this.userToken = userToken;
        this.mobileModel = mobileModel;
        this.mobileNumber = mobileNumber;
        this.requestDate = requestDate;
        this.requestName = requestName;
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

    public String getApplicationVersion() {
        return applicationVersion;
    }

    public void setApplicationVersion(String applicationVersion) {
        this.applicationVersion = applicationVersion;
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

    public String getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(String requestDate) {
        this.requestDate = requestDate;
    }

    public String getRequestName() {
        return requestName;
    }

    public void setRequestName(String requestName) {
        this.requestName = requestName;
    }

    public String getDeviceLanguage() {
        return deviceLanguage;
    }

    public void setDeviceLanguage(String deviceLanguage) {
        this.deviceLanguage = deviceLanguage;
    }
    public int getFailureId() {
        return failureId;
    }

    public void setFailureId(int failureId) {
        this.failureId = failureId;
    }
}
