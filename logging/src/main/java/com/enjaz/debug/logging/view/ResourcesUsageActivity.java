package com.enjaz.debug.logging.view;

import android.app.AlertDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.enjaz.debug.logging.R;
import com.enjaz.debug.logging.entities.ResourceUsage;
import com.enjaz.debug.logging.helper.Common;
import com.enjaz.debug.logging.presenter.ResourceUsagePresenterImplement;
import com.jjoe64.graphview.DefaultLabelFormatter;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.GridLabelRenderer;
import com.jjoe64.graphview.Viewport;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.DataPointInterface;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.jjoe64.graphview.series.OnDataPointTapListener;
import com.jjoe64.graphview.series.Series;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class ResourcesUsageActivity extends AppCompatActivity implements ResourceUsageInterface {
    private GraphView memoryRecourseGraph;
    private ResourceUsagePresenterImplement presenterImplement;
    private int color;
    private View popupInputDialogView = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resources_usage);
        //set tool bar title
        Objects.requireNonNull(getSupportActionBar()).setTitle("Resource Usage");
        //set color value
        color = Color.rgb(205, 173, 0);
        //config GraphView
        configureGraphView();
        //set spinner value and get data
        setSpinner();
        //initial presenter
        presenterImplement = new ResourceUsagePresenterImplement(this, this);


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.memory_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        if ((item.getItemId()) == R.id.enable) {
            presenterImplement.enableMemoryMonitoring();
            Toast.makeText(ResourcesUsageActivity.this,"Enabled",Toast.LENGTH_LONG).show();

            return true;
        } else if ((item.getItemId()) == R.id.disable) {
         presenterImplement.disableMemoryMonitoring();
            Toast.makeText(ResourcesUsageActivity.this,"Disable",Toast.LENGTH_LONG).show();



            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    private void configureGraphView() {
        memoryRecourseGraph = findViewById(R.id.graph);

        //customize ViewPort of the Graph
        Viewport viewport = memoryRecourseGraph.getViewport();
        //set Y& ْ X Points Manual
        viewport.setScrollable(false);
        viewport.setScalable(false);

        //styling GraphView
        memoryRecourseGraph.setTitle("Resource Usage");
        memoryRecourseGraph.setTitleColor(Color.WHITE);
        memoryRecourseGraph.getGridLabelRenderer().setGridStyle(GridLabelRenderer.GridStyle.HORIZONTAL);
        memoryRecourseGraph.getGridLabelRenderer().setHorizontalAxisTitle("Time");
        memoryRecourseGraph.getGridLabelRenderer().setHorizontalAxisTitleColor(Color.WHITE);
        memoryRecourseGraph.getGridLabelRenderer().setVerticalAxisTitle("Total Memory");
        memoryRecourseGraph.getGridLabelRenderer().setVerticalAxisTitleColor(Color.WHITE);
        memoryRecourseGraph.getGridLabelRenderer().setGridColor(color);
        memoryRecourseGraph.getGridLabelRenderer().setVerticalLabelsColor(Color.WHITE);
        memoryRecourseGraph.getGridLabelRenderer().setHorizontalLabelsAngle(30);
        memoryRecourseGraph.getGridLabelRenderer().setPadding(32);


    }

    private void setXLabel(final String timeFrame) {

        memoryRecourseGraph.getGridLabelRenderer().setLabelFormatter(new DefaultLabelFormatter() {
            @Override
            public String formatLabel(double value, boolean isValueX) {

                if (isValueX)
                    switch (timeFrame) {
                        case "Last Hour":
                            return Common.getHoursAndMinuets((long) value * 1000);
                        case "Last 24 Hours":
                            return Common.getHoursAndMinuets((long) value * 1000);
                        case "Last 7 Days":
                            return Common.getDayAndTime((long) value * 1000);
                        case "Last 30 Days":
                            return Common.getTimeAndDayAndMonth((long) value * 1000);
                        default:
                            return Common.getHoursAndMinuets((long) value * 1000);

                    }

                return super.formatLabel(value, isValueX);
            }
        });
        //set label color
        memoryRecourseGraph.getGridLabelRenderer().setHorizontalLabelsColor(Color.WHITE);

    }

    private void setSpinner() {
        // Spinner element
        Spinner selectableTimeFrame = findViewById(R.id.time_frame);

        // Spinner click listener


        // Spinner Drop down elements
        List<String> timeFrame = new ArrayList<>();
        timeFrame.add("Last Hour");
        timeFrame.add("Last 24 Hours");
        timeFrame.add("Last 7 Days");
        timeFrame.add("Last 30 Days");

        // Creating adapter for spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.spinner_custom_view, timeFrame);
        // Drop down layout style - list view with radio button
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        selectableTimeFrame.setAdapter(adapter);

        //set default value to last Hour
        selectableTimeFrame.setSelection(0);
        // attachingOnItemSelectedListener to spinner
        selectableTimeFrame.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                // On selecting a spinner item
                String item = adapterView.getItemAtPosition(position).toString();
                //remove old points to draw new points
                memoryRecourseGraph.removeAllSeries();
                //get memory info depend on selected item
                getResourceUsageInfo(item);

                //set X-axis time label
                setXLabel(item);


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                //get default data
                getResourceUsageInfo("Last Hour");
                //set X-axis time label
                setXLabel("Last Hour");

            }
        });


    }

    private void getResourceUsageInfo(String timeFrame) {
        //instance of presenter
        //get all data
        presenterImplement.onSuccess(timeFrame);
    }


    @Override
    public void onSuccess(List<ResourceUsage> resourceUsage) {

        setGraphView(resourceUsage);


    }

    @Override
    public void geResourceUsageById(ResourceUsage resourceUsage) {
        // Create a AlertDialog Builder.
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(ResourcesUsageActivity.this);


        // Init popup dialog view and it's ui controls.
        initPopupViewControls(resourceUsage);

        // Set the inflated layout view object to the AlertDialog builder.
        alertDialogBuilder.setView(popupInputDialogView);

        // Create AlertDialog and show.
        final AlertDialog alertDialog = alertDialogBuilder.create();

        alertDialog.show();



       /* Intent intent = new Intent(this, ResourceUsageDetails.class);
        intent.putExtra("TotalMemory", resourceUsage.getTotalMemory());
        intent.putExtra("FreeMemory", resourceUsage.getFreeMemory());
        intent.putExtra("Date", Common.formatDate(resourceUsage.getDate()));
        intent.putExtra("TotalMemory", resourceUsage.getTotalMemory());
        intent.putExtra("AvailableHeapSize", resourceUsage.getAvailableHeapSize());
        intent.putExtra("MaxHeapSize", resourceUsage.getMaxHeapSize());
        intent.putExtra("UsedMemory", resourceUsage.getUsedMemory());*/

        // startActivity(intent);


    }

    private void initPopupViewControls(ResourceUsage resourceUsage) {
        // Get layout inflater object.
        LayoutInflater layoutInflater = LayoutInflater.from(ResourcesUsageActivity.this);

        // Inflate the popup dialog from a layout xml file.
        popupInputDialogView = layoutInflater.inflate(R.layout.activity_resource_usage_details, null);


        // config dialog view
        TextView dateText = popupInputDialogView.findViewById(R.id.all_resource_info);
        TextView memory_info = popupInputDialogView.findViewById(R.id.date);


        dateText.setText(Common.formatDate((resourceUsage.getDate().getTime() * 1000)));
        memory_info.setText("TotalMemory:" + resourceUsage.getTotalMemory() + "\n FreeMemory: " + resourceUsage.getFreeMemory() + "\nUsedMemory: "
                + resourceUsage.getUsedMemory() + "\nAvailableHeapSize: " + resourceUsage.getMaxHeapSize() + "\nMaxHeapSize: " + resourceUsage.getMaxHeapSize());

    }

    private void setGraphView(List<ResourceUsage> memoryMonitoring) {
        //create instance of LineGraphSeries to set (x,y)
        LineGraphSeries<DataPoint> pointsXY = new LineGraphSeries<DataPoint>();
        for (int i = 0; i < memoryMonitoring.size(); i++) {

            pointsXY.appendData(new DataPoint(memoryMonitoring.get(i).getDate(), memoryMonitoring.get(i).getTotalMemory()), true, memoryMonitoring.size());

        }
        //set point(x,y) animation
        pointsXY.setAnimated(true);
        pointsXY.setColor(color);
        //set point(x,y)to graph
        memoryRecourseGraph.refreshDrawableState();
        memoryRecourseGraph.addSeries(pointsXY);

        //refresh the view to add new point

        pointsXY.setOnDataPointTapListener(new OnDataPointTapListener() {
            @Override
            public void onTap(Series series, DataPointInterface dataPoint) {
                presenterImplement.GetMemoryUsageByDate((long) dataPoint.getX());


            }
        });

    }

}