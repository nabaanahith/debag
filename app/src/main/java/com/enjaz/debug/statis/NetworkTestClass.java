package com.enjaz.debug.statis;

import android.content.Context;

import com.enjaz.debug.logging.entities.NetworkCallInformation;
import com.enjaz.debug.logging.logging.LoggingImplement;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

class NetworkTestClass {
    private LoggingImplement loggingImplement;

    NetworkTestClass(Context context) {

        loggingImplement = new LoggingImplement(context);


        storeNetworkCallInformationTestData();


    }

    private void storeNetworkCallInformationTestData() {
        //Test1 .. all info will received from Enjaz_app thn will save the constatnt info of user
        // in preferences and the required info that change according to network error in db
        NetworkCallInformation userInfoTest1 = new NetworkCallInformation("osv:25", 12, "user token", "mobile model:L8", "077116738831", "app v", "ar", "requester 1", "request Parameter 1", "response message 1", get(2).getTime(), "request name 1");
        loggingImplement.storeFailedNetworkCalls(userInfoTest1);


        NetworkCallInformation userInfoTest2 = new NetworkCallInformation("osv:22", 12, "user token", "mobile model:99", "07765671838", "app v", "ar", "requester 2", "request Parameter 2", "response message 2", get(5).getTime(), "request name 2");
        loggingImplement.storeFailedNetworkCalls(userInfoTest2);

        NetworkCallInformation userInfoTest3 = new NetworkCallInformation("osv:26", 12, "user token", "mobile model:90", "07715560971", "app v", "ar", "requester 3", "request Parameter 3", "response message 3", get(5).getTime(), "request name 3");
        loggingImplement.storeFailedNetworkCalls(userInfoTest3);


        NetworkCallInformation userInfoTest4 = new NetworkCallInformation("osv:27", 12, "user token", "mobile model:87", "0571198671", "app v", "ar", "requester 4", "request Parameter 4", "response message 4", get(0).getTime(), "request name 4");

        loggingImplement.storeFailedNetworkCalls(userInfoTest4);


    }

    //fake date for testing
    private Date get(int i) {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, i);  // number of days to add
        return c.getTime();
    }
}
