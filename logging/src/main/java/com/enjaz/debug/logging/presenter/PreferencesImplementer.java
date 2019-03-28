package com.enjaz.debug.logging.presenter;

import android.content.Context;

import com.enjaz.debug.logging.entities.NetworkCallInformation;
import com.enjaz.debug.logging.model.PreferencesImplement;

public class PreferencesImplementer implements PreferencesInterface {
    private PreferencesImplement preferencesModel;

    public PreferencesImplementer(Context context) {
        preferencesModel = new PreferencesImplement(context);

    }

    /*
    get NetworkCallInformation obj from preference
     */
    public NetworkCallInformation getPreferences() {
        return preferencesModel.getPreferences();

    }

    /*
        get NetworkCallInformation obj from preference
         */
    public void saveInPreferences(NetworkCallInformation userInfo) {
        NetworkCallInformation userInfo2 = new NetworkCallInformation(userInfo.getOSVersion(), userInfo.getSdkVersion(), userInfo.getUserToken(), userInfo.getMobileModel(), userInfo.getMobileNumber(), userInfo.getApplicationVersion(), userInfo.getDeviceLanguage());
        preferencesModel.saveInPreferences(userInfo2);

    }


}
