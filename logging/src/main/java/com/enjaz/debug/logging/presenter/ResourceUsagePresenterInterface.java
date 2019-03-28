package com.enjaz.debug.logging.presenter;

public interface ResourceUsagePresenterInterface {
    /**
     * fetch resource usage  from db success
     */
    void onSuccess(String timeFrame);

    /**
     * fetch resource usage  from db by id success
     */
    void GetMemoryUsageByDate(Long date);

    /**
     * enable memory Monitoring
     */
    void enableMemoryMonitoring();

    /**
     * disable memory Monitoring
     */
    void disableMemoryMonitoring();

}
