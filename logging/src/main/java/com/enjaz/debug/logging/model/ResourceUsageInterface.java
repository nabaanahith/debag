package com.enjaz.debug.logging.model;

import com.enjaz.debug.logging.entities.ResourceUsage;

import java.util.List;


public interface ResourceUsageInterface {
    /**
     * enableMemoryMonitoring
     */
    void enableMemoryMonitoring();
    /**
     * disableMemoryMonitoring
     */
    void disableMemoryMonitoring();
    /**
     * getAllResourceUsage
     */
    List<ResourceUsage> getAllResourceUsage(String timeFrame);
    /**
     * getResourceUsageBayDate
     */
    ResourceUsage getResourceUsageBayDate(long date);


}
