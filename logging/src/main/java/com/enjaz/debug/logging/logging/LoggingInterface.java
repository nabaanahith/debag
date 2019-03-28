package com.enjaz.debug.logging.logging;

import com.enjaz.debug.logging.entities.NetworkCallInformation;
import com.enjaz.debug.logging.entities.UserActivity;

public interface LoggingInterface {
    /*
  store Failed  Network Calls

  * */
    void storeFailedNetworkCalls(NetworkCallInformation networkCallInformation);

    /*
     store User Activity
     * */
    void storeUserActivity(UserActivity userActivity);

    /*
         enable Memory Monitoring
         * */
    void enableMemoryMonitoring();

    /*
           disable Memory Monitoring
           * */
    void disableMemoryMonitoring();
}
