package com.enjaz.debug.logging.presenter;

import android.content.Context;

import com.enjaz.debug.logging.entities.NetworkCallITable;
import com.enjaz.debug.logging.entities.NetworkCallInformation;
import com.enjaz.debug.logging.entities.NetworkCallITable;
import com.enjaz.debug.logging.logging.LoggingImplement;
import com.enjaz.debug.logging.model.NetworkModelCallInformationImplement;
import com.enjaz.debug.logging.view.NetworkViewInterface;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

public class NetworkPresenterImplement implements NetworkPresenterInterface {
    private Context context;
    private NetworkModelCallInformationImplement networkModelCallInformationImplement;
    private NetworkViewInterface networkViewInterface;


    public NetworkPresenterImplement(Context context, NetworkViewInterface networkViewInterface) {
        this.context = context;
        this.networkViewInterface = networkViewInterface;


        networkModelCallInformationImplement = new NetworkModelCallInformationImplement(context);

    }

    public NetworkPresenterImplement(Context context) {
        this.context = context;


        networkModelCallInformationImplement = new NetworkModelCallInformationImplement(context);

    }

    //get all info of net. crashes
    public void getAllNetworkInformation() {
        networkViewInterface.onReceiveAllNetworkInfo(networkModelCallInformationImplement.getAllNetworkInformation());

    }

    //get info by day
    public List<NetworkCallITable> getAllNetworkInformation(String day) {


        return networkModelCallInformationImplement.getAllNetworkInformationByDay(day);
    }
    //get info by id

    public NetworkCallITable getNetworkInformationById(int id) {


        return networkModelCallInformationImplement.getNetworkRowsById(id);
    }
    //get info of selected point

    public List<NetworkCallITable> getNetworkListBySelectedPoint(String day) {
        return networkModelCallInformationImplement.getListOfNetworkRowsSelectedPoint(day);

    }

    public void storeFailedNetworkCalls(NetworkCallInformation info) {

        networkModelCallInformationImplement.storeFailedNetworkCalls(info);
    }


}
