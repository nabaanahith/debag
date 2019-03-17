package com.enjaz.debug.logging.model;

import com.enjaz.debug.logging.entities.UserActivity;

import java.util.List;

public interface UserActivityCallBack {
    void onSuccess(List<UserActivity> userActivity);
}
