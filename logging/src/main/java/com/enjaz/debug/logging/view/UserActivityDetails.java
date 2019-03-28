package com.enjaz.debug.logging.view;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.enjaz.debug.logging.R;
import com.enjaz.debug.logging.entities.NetworkCallInformation;
import com.enjaz.debug.logging.entities.UserActivityTable;
import com.enjaz.debug.logging.entities.UserActivityTable;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class UserActivityDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);

        RecyclerView recyclerView = findViewById(R.id.recycler);
        List<UserActivityTable> userActivities;
        /* get type of list to show details of list */

        Type type = new TypeToken<List<UserActivityTable>>() {
        }.getType();


        /*
        show fixed UserInformation
        convert string  that received from intent into array list
        */

        String listSerializedToJson = getIntent().getExtras().getString("list");
        userActivities = (new Gson().fromJson(listSerializedToJson, type));
        UserAdapter userAdapter = new UserAdapter(this, userActivities);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        //show list that converted
        recyclerView.setAdapter(userAdapter);
    }

}
