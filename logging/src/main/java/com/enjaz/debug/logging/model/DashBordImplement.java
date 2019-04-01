package com.enjaz.debug.logging.model;

import android.content.Context;
import android.util.Log;

import com.ajts.androidmads.library.SQLiteToExcel;
import com.enjaz.debug.logging.database.GetDashBordInfoASyncTask;

import java.util.Date;
import java.util.concurrent.ExecutionException;


public class DashBordImplement implements DashBordInterface {
    private Context context;


    public DashBordImplement(Context context) {
        this.context = context;

    }


    public void exportReportToExcel(final ExportReportResponse exportReportResponse) {
        //get new excel file name
        String excelName = new Date().getTime() + ".xls";
        //instance of SQLiteToExcel
        SQLiteToExcel sqliteToExcel = new SQLiteToExcel(context, "logging_db");
        //export all tables in one Excel sheet
        sqliteToExcel.exportAllTables(excelName, new SQLiteToExcel.ExportListener() {
                    //when start exporting
                    @Override
                    public void onStart() {


                    }

                    //complete exporting excel report successfully
                    @Override
                    public void onCompleted(String filePath) {
                        //send response message (path to excel file )
                        exportReportResponse.onSuccessExportingReport(filePath);


                    }

                    //if any exception occur while exporting report
                    @Override
                    public void onError(Exception e) {
                        //send response message
                        exportReportResponse.onFailureExportingReport(e.getMessage());


                    }

                }

        );

    }

    @Override
    public int getNumberOftNetworkFailure(String type) {
        //get counter depend on type
        try {
            return new GetDashBordInfoASyncTask(context).execute(type).get();
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int getMaximumTotalMemory(String type) {
        //get counter depend on type
        try {
            int a=new GetDashBordInfoASyncTask(context).execute(type).get();
            Log.d("kkkkk", "getMaximumTotalMemory: "+a);
            return a;

        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int getActivityUsage(String type) {
        //get counter depend on type
        try {
            return new GetDashBordInfoASyncTask(context).execute(type).get();
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
        return 0;
    }


}
