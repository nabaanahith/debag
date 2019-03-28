package com.enjaz.debug.logging.model;

import android.content.Context;
import android.content.SharedPreferences;

import com.enjaz.debug.logging.entities.NetworkCallInformation;
import com.google.gson.Gson;

import static android.content.Context.MODE_PRIVATE;

public class PreferencesImplement implements PreferencesInterface {
    private SharedPreferences mPrefs;
    public PreferencesImplement(Context context) {
        mPrefs = context.getSharedPreferences("key",MODE_PRIVATE);}
    /* method to save data of user info in preferences */
    @Override
    public void saveInPreferences(NetworkCallInformation userInfo) {
        SharedPreferences.Editor prefsEditor = mPrefs.edit();
        Gson gson = new Gson();
        String json = gson.toJson(userInfo);
        prefsEditor.putString("MyObject", json);
        prefsEditor.apply();

    }
    /* method to get data of user info in preferences */
    @Override
    public NetworkCallInformation getPreferences(){
        Gson gson = new Gson();
        String json = mPrefs.getString("MyObject", "");
        return gson.fromJson(json, NetworkCallInformation.class);

    }
}

