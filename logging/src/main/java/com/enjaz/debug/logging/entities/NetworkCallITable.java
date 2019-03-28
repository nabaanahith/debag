package com.enjaz.debug.logging.entities;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "NetworkCallITable")
public class NetworkCallITable implements Serializable {


    @PrimaryKey(autoGenerate = true)
    private int failureId;
    private String requestUrl;
    private String requestParameters;
    private String responseMessage;
    private long requestDate;
    private String day;
    private String requestName;

    public NetworkCallITable(String requestUrl, String requestParameters, String responseMessage, long requestDate, String requestName, String day) {
        this.requestUrl = requestUrl;
        this.requestParameters = requestParameters;
        this.responseMessage = responseMessage;
        this.requestDate = requestDate;
        this.requestName = requestName;
        this.day = day;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public int getFailureId() {
        return failureId;
    }

    public void setFailureId(int failureId) {
        this.failureId = failureId;
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