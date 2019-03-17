package com.enjaz.debug.logging.model;

import com.enjaz.debug.logging.entities.NetworkCallInformation;

public interface NetworkInfoCallBack {
    void onSuccess(NetworkCallInformation networkCallInformation);
}
