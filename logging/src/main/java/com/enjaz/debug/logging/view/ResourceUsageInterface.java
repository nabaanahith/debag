package com.enjaz.debug.logging.view;

import com.enjaz.debug.logging.entities.ResourceUsage;

import java.util.List;

public interface ResourceUsageInterface {
    void onSuccess(List<ResourceUsage> resourceUsage);

    void geResourceUsageById(ResourceUsage resourceUsage);
}
