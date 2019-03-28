package com.enjaz.debug.logging.view;

import android.os.Build;
import android.os.Bundle;
import android.support.design.animation.AnimationUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.enjaz.debug.logging.R;
import com.enjaz.debug.logging.entities.NetworkCallITable;
import com.enjaz.debug.logging.entities.NetworkCallInformation;

import com.enjaz.debug.logging.entities.UserInfo;

import com.enjaz.debug.logging.logging.LoggingImplement;
import com.enjaz.debug.logging.model.PreferencesImplement;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import androidx.annotation.RequiresApi;

public class NetworkActivityDetails extends AppCompatActivity {
    private List<NetworkCallITable> networkCallInformation;
    private PreferencesImplement loggingPresenterImplement;
    private TextView mobileNumber, osVersion, sdkVersion, mobileModel, mobilelang, userToken;
    private ImageView imageView;
    private boolean visible;
    private ViewGroup linear;
    private RecyclerView recyclerView;

    private LinearLayout linearLayout;
    private TextView requestParameter, requestUrl, causeOfError;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_network_details);
        //set views
        configView();
        //initialization
        loggingPresenterImplement = new PreferencesImplement(this);
        networkCallInformation = new ArrayList<>();
        //get type of list to show details of list
        Type type = new TypeToken<List<NetworkCallITable>>() {
        }.getType();

        //get data from intent and convert it
        showUserInformation();
        String listSerializedToJson = getIntent().getExtras().getString("list");
        networkCallInformation = (new Gson().fromJson(listSerializedToJson, type));
        NetworkAdapter networkAdapter = new NetworkAdapter(this, networkCallInformation);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(networkAdapter);

        //animation
        imageView.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                TransitionManager.beginDelayedTransition(linear);
                visible = !visible;
                linearLayout.setVisibility(visible ? View.VISIBLE : View.GONE);
                linear.animate().alpha(10.0f);
            }
        });
    }

    private void configView() {
        requestUrl = findViewById(R.id.requrl);
        requestParameter = findViewById(R.id.requestparamet);
        causeOfError = findViewById(R.id.causeoferror);
        recyclerView = findViewById(R.id.recycler);
        osVersion = findViewById(R.id.os_ver);
        mobileNumber = findViewById(R.id.mobile_number);
        mobileModel = findViewById(R.id.mobile_model);
        mobilelang = findViewById(R.id.device_lang);
        userToken = findViewById(R.id.user_Token);
        imageView = findViewById(R.id.clickme);
        linearLayout = findViewById(R.id.linear);
        sdkVersion = findViewById(R.id.sdk_vetsion);
        linear = findViewById(R.id.linear);
    }

    /* set information that received from preference */
    private void showUserInformation() {
        PreferencesImplement preferencesPresenter = new PreferencesImplement(getApplicationContext());
        NetworkCallInformation userInfo = preferencesPresenter.getPreferences();
        mobileNumber.setText("Mobile Number : " + userInfo.getMobileNumber());
        osVersion.setText("Os Version : " + userInfo.getOSVersion());
        sdkVersion.setText("Sdk Version : " + String.valueOf(userInfo.getSdkVersion()));
        mobilelang.setText("Device Language : " + userInfo.getDeviceLanguage());
        mobileModel.setText("Mobile Model : " + userInfo.getMobileModel());
        userToken.setText("User Token : " + userInfo.getUserToken());
    }


}
