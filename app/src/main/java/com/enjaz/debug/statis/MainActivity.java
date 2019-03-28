package com.enjaz.debug.statis;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.enjaz.debug.logging.entities.PlatformType;
import com.enjaz.debug.logging.entities.UserActivity;
import com.enjaz.debug.logging.logging.LoggingImplement;
import com.enjaz.debug.logging.logging.LoggingInterface;
import com.enjaz.debug.logging.view.DashboardActivity;

import java.util.Date;

@SuppressLint("StaticFieldLeak")
public class MainActivity extends AppCompatActivity {

    private CardView test_AQSATI, test_TASDEED, test_QI_GUIDE, test_PAYROLL, test_Network;
    private Button enable_memory_monitoring, disable_memory_monitoring, dash_board;
    private LoggingImplement loggingImplement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //create instance of logging
        loggingImplement = new LoggingImplement(MainActivity.this);
        //config View
        configView();
        //set on click listener to test  user activity
        setOnclickListener(test_AQSATI, PlatformType.AQSATI);
        setOnclickListener(test_TASDEED, PlatformType.TASDEED);
        setOnclickListener(test_QI_GUIDE, PlatformType.QI_GUIDE);
        setOnclickListener(test_PAYROLL, PlatformType.PAYROLL);
        //set on click listener to test network
        test_Network.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AsyncTask<Void, Void, Void>() {

                    @Override
                    protected Void doInBackground(Void... voids) {
                        new NetworkTestClass(getBaseContext());
                        return null;

                    }
                }.execute();
                Toast.makeText(MainActivity.this, "Test Network", Toast.LENGTH_LONG).show();


            }
        });
        //enable memory minoring
        enable_memory_monitoring.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loggingImplement.enableMemoryMonitoring();
                Toast.makeText(MainActivity.this, "Enable", Toast.LENGTH_LONG).show();


            }
        });

        //disable memory minoring
        disable_memory_monitoring.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loggingImplement.disableMemoryMonitoring();
                Toast.makeText(MainActivity.this, "Disable", Toast.LENGTH_LONG).show();


            }
        });
        //go to dash bord
        dash_board.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, DashboardActivity.class));
            }
        });


    }

    private void configView() {
        test_AQSATI = findViewById(R.id.test_AQSATI);
        test_TASDEED = findViewById(R.id.test_TASDEED);
        test_QI_GUIDE = findViewById(R.id.test_QI_GUIDE);
        test_PAYROLL = findViewById(R.id.test_PAYROLL);
        test_Network = findViewById(R.id.test_Network);
        enable_memory_monitoring = findViewById(R.id.enable_memory_monitoring);
        disable_memory_monitoring = findViewById(R.id.disable_memory_monitoring);
        dash_board = findViewById(R.id.dash_board);


    }

    void setOnclickListener(CardView view, final PlatformType platformType) {
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final UserActivity userActivityForDB = new UserActivity(platformType, new Date().getTime(),
                        platformType.toString() + " class", platformType.toString() + " Activity");
                new AsyncTask<Void, Void, Void>() {


                    @SuppressLint("WrongThread")
                    @Override
                    protected Void doInBackground(Void... voids) {
                        loggingImplement.storeUserActivity(userActivityForDB);

                        return null;
                    }

                }.execute();
                Toast.makeText(MainActivity.this, "Test " + platformType, Toast.LENGTH_LONG).show();

            }
        });
    }
}
