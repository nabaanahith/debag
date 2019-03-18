package com.enjaz.debug.statis;

import android.content.Context;

import com.enjaz.debug.logging.entities.NetworkCallInformation;
import com.enjaz.debug.logging.entities.UserActivity;
import com.enjaz.debug.logging.helper.Common;
import com.enjaz.debug.logging.model.LoggingImplement;

class TestClass {
    private LoggingImplement mainModel;

    TestClass(Context context) {
        mainModel = new LoggingImplement(context);
        storeNetworkCallInformationTestData();
        storeUserActivityTestData();

    }

    private void storeNetworkCallInformationTestData() {
        final NetworkCallInformation info1 = new NetworkCallInformation("12.3", 12, ".3", "www.abc.com", "request parameter", "response message", "myToken", "s8 galgsy", "077111671026", "12/2/2010", "getmyrequset", "english");
        mainModel.storeFailedNetworkCalls(info1);
        final NetworkCallInformation info2 = new NetworkCallInformation("12.3", 12, "2.", "www.abc.com", "request parameter", "response message", "myToken", "s8 galgsy", "077111671026", "12/2/2010", "getmyrequset", "english");
        mainModel.storeFailedNetworkCalls(info2);
        final NetworkCallInformation info3 = new NetworkCallInformation("12.3", 12, "20.3", "www.abc.com", "request parameter", "response message", "myToken", "s8 galgsy", "077111671026", "12/2/2010", "getmyrequset", "english");
        mainModel.storeFailedNetworkCalls(info3);

    }

    private void storeUserActivityTestData() {
        UserActivity userActivity = new UserActivity("qicard", "qicard", "classqicard", Common.getHours());
        mainModel.storeUserActivity(userActivity);
        UserActivity userActivity2 = new UserActivity("qigide", "qigide", "classqicard", Common.getHours());
        mainModel.storeUserActivity(userActivity2);
        UserActivity userActivity3 = new UserActivity("payroll", "payroll", "classqicard", Common.getHours());
        mainModel.storeUserActivity(userActivity3);
        UserActivity userActivity4 = new UserActivity("tacsset", "tacsset", "classqicard", Common.getHours());
        mainModel.storeUserActivity(userActivity4);

    }
}
