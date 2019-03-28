package com.enjaz.debug.logging.model;

/*
 * call back
 * */
public interface ExportReportResponse {
    /*
     * on Success Exporting Report
     * */
    void onSuccessExportingReport(String path);

    /*
     * on Failure Exporting Report
     * */
    void onFailureExportingReport(String message);
}
