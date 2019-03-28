
package com.enjaz.debug.logging.view;


import com.enjaz.debug.logging.entities.NetworkCallITable;

import java.util.List;

public interface NetworkViewInterface {
    /*
    on Receive All Network Info
     */
    void onReceiveAllNetworkInfo(List<NetworkCallITable> networkCallITables);

}