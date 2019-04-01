package com.enjaz.debug.logging.logging;

import android.content.Context;

import com.enjaz.debug.logging.entities.NetworkCallInformation;
import com.enjaz.debug.logging.entities.UserActivity;
import com.enjaz.debug.logging.presenter.NetworkPresenterImplement;
import com.enjaz.debug.logging.presenter.ResourceUsagePresenterImplement;
import com.enjaz.debug.logging.presenter.UserActivityPresenterImplement;

public class LoggingImplement implements LoggingInterface {
    private NetworkPresenterImplement networkPresenterImplement;
    private UserActivityPresenterImplement userActivityPresenterImplement;
    private ResourceUsagePresenterImplement memoryUsagePresenterImplement;

    public LoggingImplement(Context context) {
        // instance to presenter
        userActivityPresenterImplement = new UserActivityPresenterImplement(context);
        networkPresenterImplement = new NetworkPresenterImplement(context);
        memoryUsagePresenterImplement = new ResourceUsagePresenterImplement(context);
    }

    /* store Failed Network */
    @Override
    public void storeFailedNetworkCalls(NetworkCallInformation info) {

        networkPresenterImplement.storeFailedNetworkCalls(info);
    }

    /* store UserActivity */
    @Override
    public void storeUserActivity(UserActivity activity) {

        userActivityPresenterImplement.storeUserActivity(activity);
    }

    /* enable memory monitoring*/
    @Override
    public void enableMemoryMonitoring() {

        memoryUsagePresenterImplement.enableMemoryMonitoring();

    }

    /* enable memory monitoring*/
    @Override
    public void disableMemoryMonitoring() {
        memoryUsagePresenterImplement.disableMemoryMonitoring();
    }

}
