package com.enjaz.debug.logging.presenter;

import com.enjaz.debug.logging.entities.NetworkCallInformation;

public interface PreferencesInterface {
    /*
    get NetworkCallInformation obj from preference
     */
    NetworkCallInformation getPreferences();
    /*
       save NetworkCallInformation obj to preference
        */
    void saveInPreferences(NetworkCallInformation userInfo);


}
