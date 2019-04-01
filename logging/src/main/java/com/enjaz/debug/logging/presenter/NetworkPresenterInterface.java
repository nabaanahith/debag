package com.enjaz.debug.logging.presenter;

import com.enjaz.debug.logging.entities.NetworkCallITable;
import com.enjaz.debug.logging.entities.NetworkCallITable;

import java.util.List;

public interface NetworkPresenterInterface {
    /*
    get all network info
     */
    void getAllNetworkInformation();

    /*
     get Network Information ById        */
    NetworkCallITable getNetworkInformationById(int id);
    /*
     get Network Information By day       */

    List<NetworkCallITable> getNetworkListBySelectedPoint(String day);

}
