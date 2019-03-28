package com.enjaz.debug.logging.model;

public interface DashBordInterface {
    /**
     * export report from db
     */

    void exportReportToExcel(ExportReportResponse exportReportResponse);

    /**
     * getNumberOftNetworkFailure
     */
    int getNumberOftNetworkFailure(String type);

    /**
     * getMaximumTotalMemory
     */
    int getMaximumTotalMemory(String type);

    /**
     * getActivityUsage
     */
    int getActivityUsage(String type);
}
