package com.enjaz.debug.logging.view;

import android.Manifest;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.Snackbar;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.budiyev.android.circularprogressbar.CircularProgressBar;
import com.enjaz.debug.logging.BuildConfig;
import com.enjaz.debug.logging.R;
import com.enjaz.debug.logging.presenter.DashBordPresenterImplement;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;

import java.io.File;
import java.util.List;
import java.util.Objects;


public class DashboardActivity extends AppCompatActivity implements DashboardActivityInterface {

    private String selectedOption;
    private TextView networkDescription, memoryDescription, userActivityDescription;
    private CircularProgressBar networkChart, memoryChart, userActivityChart;
    private DashBordPresenterImplement dashBordPresenterImplement;
    private TextView networkCountText, memoryCountText, userActivityCountText;
    private View networkFailureLayout, memoryMonitoringLayout, userActivityLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        //set tool bar title
        Objects.requireNonNull(getSupportActionBar()).setTitle("E.Dashboard");
        //config view
        configViews();


        //instance of presenter
        dashBordPresenterImplement = new DashBordPresenterImplement(this, this);
        //get number of Network Failure
        dashBordPresenterImplement.NumberOftNetworkFailure("NetWorkInfo");
        //get number of user activity
        dashBordPresenterImplement.ActivityUsage("UserActivity");
        //get max memory usage
        dashBordPresenterImplement.MaximumTotalMemory("ResourceUsage");
        // add on click listener to go to specific activity
        onLayoutClickListener(networkFailureLayout, "NetWorkInfo");
        onLayoutClickListener(userActivityLayout, "UserActivity");
        onLayoutClickListener(memoryMonitoringLayout, "ResourceUsage");


    }

    private void onLayoutClickListener(View view, final String s) {
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (s.equals("NetWorkInfo"))
                    startActivity(new Intent(DashboardActivity.this, NetworkFailureActivity.class));
                else if (s.equals("UserActivity"))
                    startActivity(new Intent(DashboardActivity.this, UserViewActivity.class));
                else if (s.equals("ResourceUsage"))
                    startActivity(new Intent(DashboardActivity.this, ResourcesUsageActivity.class));
            }
        });

    }

    private void configViews() {
        networkFailureLayout = findViewById(R.id.network_failure);
        memoryMonitoringLayout = findViewById(R.id.resource_usage);
        userActivityLayout = findViewById(R.id.user_activity);

        memoryCountText = memoryMonitoringLayout.findViewById(R.id.count);
        memoryDescription = memoryMonitoringLayout.findViewById(R.id.description);
        memoryChart = memoryMonitoringLayout.findViewById(R.id.progress_bar);

        networkCountText = networkFailureLayout.findViewById(R.id.count);
        networkDescription = networkFailureLayout.findViewById(R.id.description);
        networkChart = networkFailureLayout.findViewById(R.id.progress_bar);

        userActivityCountText = userActivityLayout.findViewById(R.id.count);
        userActivityDescription = userActivityLayout.findViewById(R.id.description);
        userActivityChart = userActivityLayout.findViewById(R.id.progress_bar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if ((item.getItemId()) == R.id.report) {
            //check if run time permission is required
            checkPermissions();


            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    private void checkPermissions() {
        //check if the android version <6.0 (Marshmallow)
        if ((Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP_MR1)) {
            //require run time permission
            askForStoragePermissions();
        } else {
            // >6.0 run time permission not necessary
            startExportReport();
        }

    }

    private void askForStoragePermissions() {
        //run time permission for WRITE_EXTERNAL_STORAGE (using Dexter library)
        Dexter.withActivity(this).withPermissions(Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_EXTERNAL_STORAGE
        ).withListener(new MultiplePermissionsListener() {
            @Override
            public void onPermissionsChecked(MultiplePermissionsReport report) {
                if (report.areAllPermissionsGranted()) {
                    //export report
                    startExportReport();

                } else if (report.isAnyPermissionPermanentlyDenied())

                    displayPermissionSnackbar();

            }

            //permission denied
            @Override
            public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {
                token.continuePermissionRequest();


            }


        }).check();


    }

    private void startExportReport() {

        /*
        call presenter to start export report
        export method
        */
        dashBordPresenterImplement.exportingMessage();

    }

    private void displayPermissionSnackbar() {
        Snackbar snackbar = Snackbar
                .make(findViewById(android.R.id.content), "Storage permission denied, please accept it to continue", Snackbar.LENGTH_LONG)
                .setAction("allow", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        askForStoragePermissions();

                    }
                });

        snackbar.show();
    }

    /*
     *if report successfully
     * */
    @Override
    public void onSuccessExportingReport(final String path) {
        Snackbar snackbar = Snackbar
                .make(findViewById(android.R.id.content), "your report ", Snackbar.LENGTH_LONG)
                .setAction("Open", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        openReport(path);

                    }
                });

        snackbar.show();

    }
    /*
     * open Report after extract
     * */

    private void openReport(String path) {
        Intent objIntent = new Intent(Intent.ACTION_VIEW);
        objIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        objIntent.setDataAndType(Uri.parse(path), "application/vnd.ms-excel");

        try {
            startActivity(objIntent);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(DashboardActivity.this, "No Application Available to View Excel", Toast.LENGTH_SHORT).show();
        }


    }
    /*
     * show failure
     * */

    @Override
    public void onFailureExportingReport(String message) {
        /*
         * show failure
         * */
        Snackbar snackbar = Snackbar
                .make(findViewById(android.R.id.content), "Failure Exporting Report ", Snackbar.LENGTH_LONG);


        snackbar.show();
    }

    /*
     * set Number Of Network Failure
     * */
    @Override
    public void setNumberOftNetworkFailure(int count) {
        networkChart.setProgress(count);
        networkCountText.setText(count + "\nFailed Call");
        networkDescription.setText("Network Failure");

    }

    /*
     * set Maximum Total Memory
     * */
    @Override
    public void setMaximumTotalMemory(int count) {
        memoryChart.setProgress(count);
        memoryCountText.setText(count + "MB\nMax Resource\n Usage");
        memoryDescription.setText("Resource Usage");

    }

    /*
     * set Activity Usage
     * */
    @Override
    public void setActivityUsage(int count) {
        userActivityChart.setProgress(count);
        userActivityCountText.setText(count + "\nClicks");
        userActivityDescription.setText("App Usage");


    }


}