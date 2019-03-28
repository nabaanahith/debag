package com.enjaz.debug.logging.view;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.enjaz.debug.logging.R;
import com.enjaz.debug.logging.entities.UserActivity;
import com.enjaz.debug.logging.entities.UserActivityTable;
import com.enjaz.debug.logging.presenter.UserActivityPresenterImplement;
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

import java.util.ArrayList;
import java.util.List;

public class UserViewActivity extends AppCompatActivity implements UserViewInterface {
    private LineChart lineChart;
    private String[] xValues;
    private List<UserActivityTable> userActivityList;
    private UserActivityPresenterImplement userActivityPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_view);
        //config view
        lineChart = findViewById(R.id.graph);

        //instance from presenter
        userActivityPresenter = new UserActivityPresenterImplement(getBaseContext(), this);
        //get all user activity from presenter
        userActivityPresenter.getAllUserActivity();


        // set label for X value
        setXValues();
        //set points to graph
        setPointOfGraph();
        //get data from preferences
        // add on click to display the details of each point in new activity
        lineChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
            @Override
            public void onValueSelected(Entry e, Highlight h) {

                String label = lineChart.getData().getDataSetByIndex(h.getDataSetIndex()).getLabel();
                //get damnation of chart
                int x = (int) h.getX();
                int y = (int) h.getY();
                //get object that clicked by id
                UserActivityTable userActivity = userActivityPresenter.getUerActivityById((x + 1));
                //get all objects that same label
                List<UserActivityTable> selectPointUserActivity = userActivityPresenter.getUserActivityListBySelectedPoint(label, y);
                //show details  in details activity

                Intent intent = new Intent(UserViewActivity.this, UserActivityDetails.class);
                String listSerializedToJson = new Gson().toJson(selectPointUserActivity);
                intent.putExtra("list", listSerializedToJson);
                startActivity(intent);

            }

            @Override
            public void onNothingSelected() {

            }

        });
        //set color`s theme

        lineChart.getAxisLeft().setTextColor(Color.parseColor("#cdad00")); // left y-axis
        lineChart.getXAxis().setTextColor(Color.parseColor("#cdad00"));//bottom
        lineChart.getAxisRight().setTextColor(Color.parseColor("#cdad00")); // Right y-axis
        lineChart.getAxisRight().setTextSize(15);
        lineChart.getAxisLeft().setTextSize(15);
        lineChart.getXAxis().setTextSize(15);



    }


    public void setXValues() {
        //format x label
        xValues = new String[userActivityList.size()];
        for (int i = 0; i < userActivityList.size(); i++) {
            String dayFromDB = userActivityList.get(i).getDay();
            xValues[i] = dayFromDB;
        }
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
        int qiGuideCount = 0;
        int payrollCount = 0;
        int aqsatiCount = 0;
        int tasdeedCount = 0;
        //set data set
        List<Entry> qiGuideList = new ArrayList<>();
        List<Entry> payrollList = new ArrayList<>();
        List<Entry> aqsatiList = new ArrayList<>();
        List<Entry> tasdeedList = new ArrayList<>();

        for (int j = 0; j < userActivityList.size(); j++) {
            switch (userActivityList.get(j).getPlatformType()) {
                case QI_GUIDE:
                    qiGuideCount++;
                    qiGuideList.add(new Entry(j, qiGuideCount));
                    break;
                case PAYROLL:
                    payrollCount++;
                    payrollList.add(new Entry(j, payrollCount));
                    break;
                case AQSATI:
                    aqsatiCount++;
                    aqsatiList.add(new Entry(j, aqsatiCount));
                    break;
                case TASDEED:
                    tasdeedCount++;
                    tasdeedList.add(new Entry(j, tasdeedCount));
                    break;
            }
        }
        LineDataSet lineDataSet1 = new LineDataSet(qiGuideList, "QI_GUIDE");
        LineDataSet lineDataSet2 = new LineDataSet(payrollList, "PAYROLL");
        LineDataSet lineDataSet3 = new LineDataSet(aqsatiList, "AQSATI");
        LineDataSet lineDataSet4 = new LineDataSet(tasdeedList, "TASDEED");
        //set line colors
        lineDataSet1.setColor(Color.WHITE);
        lineDataSet2.setColor(Color.parseColor("#FFAE817C"));
        lineDataSet3.setColor(Color.parseColor("#FF22548E"));
        lineDataSet4.setColor(Color.parseColor("#55CE63"));
        //set color of Circle
        lineDataSet1.setCircleColor(Color.parseColor("#cdad00"));
        lineDataSet1.setCircleColorHole(Color.WHITE);
        lineDataSet2.setCircleColor(Color.parseColor("#cdad00"));
        lineDataSet2.setCircleColorHole(Color.WHITE);
        lineDataSet3.setCircleColor(Color.parseColor("#cdad00"));
        lineDataSet3.setCircleColorHole(Color.WHITE);
        lineDataSet4.setCircleColor(Color.parseColor("#cdad00"));
        lineDataSet4.setCircleColorHole(Color.WHITE);
        //set size of Circle
        lineDataSet1.setLineWidth(2f);
        lineDataSet1.setCircleSize(3f);
        lineDataSet2.setLineWidth(2f);
        lineDataSet2.setCircleSize(3f);
        lineDataSet3.setLineWidth(2f);
        lineDataSet3.setCircleSize(3f);
        lineDataSet4.setLineWidth(2f);
        lineDataSet4.setCircleSize(3f);
        //set text color
        lineDataSet1.setValueTextColor(Color.WHITE);
        lineDataSet2.setValueTextColor(Color.WHITE);
        lineDataSet3.setValueTextColor(Color.WHITE);
        lineDataSet4.setValueTextColor(Color.WHITE);
        //put all data and set graph
        ArrayList<ILineDataSet> dataSets = new ArrayList<>();
        dataSets.add(lineDataSet1);
        dataSets.add(lineDataSet2);
        dataSets.add(lineDataSet3);
        dataSets.add(lineDataSet4);
        LineData data = new LineData(dataSets);
        lineChart.setData(data);
        lineChart.invalidate();


    }

    /*
    receive user activity from presenter
     */
    @Override
    public void onReceiveAllUserActivity(List<UserActivityTable> userActivities) {
        userActivityList = userActivities;
    }
}