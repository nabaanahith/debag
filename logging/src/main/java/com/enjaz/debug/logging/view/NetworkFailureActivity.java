package com.enjaz.debug.logging.view;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.enjaz.debug.logging.R;
import com.enjaz.debug.logging.entities.NetworkCallITable;
import com.enjaz.debug.logging.model.PreferencesImplement;
import com.enjaz.debug.logging.presenter.NetworkPresenterImplement;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.AxisValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.google.gson.Gson;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class NetworkFailureActivity extends AppCompatActivity implements NetworkViewInterface {
    @SuppressLint("SimpleDateFormat")
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("E");
    private NetworkPresenterImplement networkPresenterImplement;
    private List<NetworkCallITable> list = new ArrayList<>();
    private LineChart lineChart;
    private String[] xValues;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_network_call_api);

        //set tool bar title
        Objects.requireNonNull(getSupportActionBar()).setTitle("Network Failure");
        //instance of presenter
        networkPresenterImplement = new NetworkPresenterImplement(this, this);
        //get data from preferences
        PreferencesImplement preferencesImplement = new PreferencesImplement(getApplicationContext());
        preferencesImplement.getPreferences();
        //get all getAllNetworkInformation
        networkPresenterImplement.getAllNetworkInformation();
        //x Values of chart "label"
        xValues = new String[list.size()];
        lineChart = findViewById(R.id.graph);
        //setPointOfGraph
        setPointOfGraph();
        //set values of x
        setXValues();
        //set color`s theme
        lineChart.getAxisLeft().setTextColor(Color.parseColor("#cdad00")); // left y-axis
        lineChart.getXAxis().setTextColor(Color.parseColor("#cdad00"));    // bottom
        lineChart.getAxisRight().setTextColor(Color.parseColor("#cdad00"));// Right y-axis
        lineChart.getAxisRight().setTextSize(15);
        lineChart.getAxisLeft().setTextSize(15);
        lineChart.getXAxis().setTextSize(15);

        //on click point in graph
        lineChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
            @Override
            public void onValueSelected(Entry e, Highlight h) {
                //get damnation of chart
                int x = (int) h.getX();
                //get object that clicked by id
                NetworkCallITable userActivity = networkPresenterImplement.getNetworkInformationById((x + 1));
                //get all objects that same date
                List<NetworkCallITable> selectPointUserActivity = networkPresenterImplement.getNetworkListBySelectedPoint(userActivity.getDay());
                //show details  in details activity
                Intent intent = new Intent(getApplicationContext(), NetworkActivityDetails.class);
                String listSerializedToJson = new Gson().toJson(selectPointUserActivity);
                intent.putExtra("list", listSerializedToJson);
                startActivity(intent);

            }

            @Override
            public void onNothingSelected() {

            }

        });
    }

    public void setXValues() {
        for (int i = 0; i < list.size(); i++) {
            //get NetworkCallITable by id
            NetworkCallITable networkCallInformation = networkPresenterImplement.getNetworkInformationById((i + 1));
            //get all NetworkCallITable in same date
            List<NetworkCallITable> selectPointUserActivity = networkPresenterImplement.getNetworkListBySelectedPoint(networkCallInformation.getDay());
            //set x label in same date response
            for (int j = 0; j < selectPointUserActivity.size(); j++) {
                xValues[i] = simpleDateFormat.format(selectPointUserActivity.get(j).getRequestDate());
            }
        }
        /*
        custom label to x axis value
         */
        XAxis xAxis = lineChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(true);
        xAxis.setGranularity(1f);
        xAxis.setGranularityEnabled(true);
        xAxis.setValueFormatter(new AxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return xValues[(int) value % xValues.length];
            }

            @Override
            public int getDecimalDigits() {
                return 0;
            }
        });

    }

    public void setPointOfGraph() {
        List<Entry> networkInformationList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            //get NetworkCallITable by id
            NetworkCallITable networkInformationById = networkPresenterImplement.getNetworkInformationById((i + 1));
            //get list of NetworkCallITable that have same date
            List<NetworkCallITable> selectPointUserActivity = networkPresenterImplement.getNetworkListBySelectedPoint(networkInformationById.getDay());
            networkInformationList.add(new Entry(i, selectPointUserActivity.size()));
        }
        LineDataSet lineDataSet1 = new LineDataSet(networkInformationList, " ");
        lineDataSet1.setColor(Color.parseColor("#cdad00"));
        lineDataSet1.setCircleColor(Color.parseColor("#cdad00"));
        lineDataSet1.setCircleColorHole(Color.WHITE);
        //set size of Circle
        lineDataSet1.setLineWidth(2f);
        //lineDataSet1.
        ArrayList<ILineDataSet> dataSets = new ArrayList<>();
        dataSets.add(lineDataSet1);
        //color of numbers in line
        lineDataSet1.setValueTextColor(Color.WHITE);
        LineData data = new LineData(dataSets);
        //set data in chart
        lineChart.setData(data);
        lineChart.invalidate();


    }

    @Override
    public void onReceiveAllNetworkInfo(List<NetworkCallITable> networkCallITables) {
        list = networkCallITables;
    }
}
