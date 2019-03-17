package com.enjaz.debug.logging.model;

import com.enjaz.debug.logging.entities.NetworkCallInformation;
import com.enjaz.debug.logging.entities.UserActivity;

public interface LoggingInterface {
    void storeFailedNetworkCalls(NetworkCallInformation networkCallInformation);
    void storeUserActivity(UserActivity userActivity);
    void enableMemoryMonitoring();
    void disableMemoryMonitoring();
}
