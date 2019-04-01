package com.enjaz.debug.logging.presenter;

import android.content.Context;

import com.enjaz.debug.logging.model.DashBordImplement;
import com.enjaz.debug.logging.model.ExportReportResponse;
import com.enjaz.debug.logging.view.DashboardActivityInterface;

public class DashBordPresenterImplement implements DashBordPresenterInterface {
    private DashBordImplement exportReportImplement;
    private DashboardActivityInterface dashboardActivityInterface;


    public DashBordPresenterImplement(Context context, DashboardActivityInterface dashboardActivityInterface) {
        //instance of export report model to get response message
        exportReportImplement = new DashBordImplement(context);
        //dashboardActivityInterface to send  response message to the view
        this.dashboardActivityInterface = dashboardActivityInterface;

    }


    @Override
    public void exportingMessage() {
        //send response message (callBAck to dashboard Activity)
        exportReportImplement.exportReportToExcel(new ExportReportResponse() {
            //success message
            @Override
            public void onSuccessExportingReport(String path) {
                dashboardActivityInterface.onSuccessExportingReport(path);
            }

            //failure message
            @Override
            public void onFailureExportingReport(String message) {
                dashboardActivityInterface.onFailureExportingReport(message);

            }
        });
    }

    /*
    get number of network failure call
     */
    @Override
    public void NumberOftNetworkFailure(String type) {
        dashboardActivityInterface.setNumberOftNetworkFailure(exportReportImplement.getNumberOftNetworkFailure(type));


    }

    /*
    get MaximumTotalMemory      */
    @Override
    public void MaximumTotalMemory(String type) {
       dashboardActivityInterface.setMaximumTotalMemory(exportReportImplement.getMaximumTotalMemory(type));

    }

    /*
       get number of activity usage      */
    @Override
    public void ActivityUsage(String type) {
        dashboardActivityInterface.setActivityUsage(exportReportImplement.getActivityUsage(type));

    }


}
