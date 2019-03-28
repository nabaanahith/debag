package com.enjaz.debug.logging.view;

public interface DashboardActivityInterface {
    /*
       on Success Exporting
        Report
       */
    void onSuccessExportingReport(final String path);

    /*onFailureExportingReport
     * */
    void onFailureExportingReport(String message);

    /*setNumberOftNetworkFailure
     * */
    void setNumberOftNetworkFailure(int count);

    /*setMaximumTotalMemory
     * */
    void setMaximumTotalMemory(int count);

    /*setActivityUsage
     * */
    void setActivityUsage(int count);
}
