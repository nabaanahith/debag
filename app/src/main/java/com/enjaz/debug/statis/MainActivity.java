package com.enjaz.debug.statis;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.enjaz.debug.logging.database.LoggingDB;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TestClass testClass =new TestClass(this);
        LoggingDB.getInstance(this);

    }
}
