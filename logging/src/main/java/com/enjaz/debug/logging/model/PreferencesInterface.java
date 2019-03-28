package com.enjaz.debug.logging.model;

import com.enjaz.debug.logging.entities.NetworkCallInformation;

public interface PreferencesInterface {
     /**
      * saveInPreferences
      */
     void saveInPreferences(NetworkCallInformation userInfo);
     /**
      * getPreferences
      */
     NetworkCallInformation getPreferences();

}
