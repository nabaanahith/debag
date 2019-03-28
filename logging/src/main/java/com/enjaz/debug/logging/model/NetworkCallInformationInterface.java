package com.enjaz.debug.logging.model;

import com.enjaz.debug.logging.entities.NetworkCallITable;

import java.util.List;

public interface NetworkCallInformationInterface {
    /**
     * get All Network Information
     */
    List<NetworkCallITable> getAllNetworkInformation();

    /**
     * get All Network Information By  Day
     */
    List<NetworkCallITable> getAllNetworkInformationByDay(String id);

    /**
     * get NetworkRows By Id
     */

    NetworkCallITable getNetworkRowsById(int id);

    /**
     * get List
     * Of Network Rows Selected Point
     */
    List<NetworkCallITable> getListOfNetworkRowsSelectedPoint(String day);

}
