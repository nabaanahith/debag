package com.enjaz.debug.logging.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.enjaz.debug.logging.R;
import com.enjaz.debug.logging.entities.NetworkCallITable;
import com.enjaz.debug.logging.helper.Common;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class NetworkAdapter extends RecyclerView.Adapter<NetworkAdapter.ViewHolder> {
    private Context context;
    private List<NetworkCallITable> posts;

    NetworkAdapter(Context context, List<NetworkCallITable> posts) {
        this.context = context;
        this.posts = posts;
    }

    //get layout that display info.
    @NonNull
    @Override
    public NetworkAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View v = LayoutInflater.from(context).inflate(R.layout.network_item_layout, viewGroup, false);

        return new ViewHolder(v);
    }

    /**
     * set views
     */

    @Override
    public void onBindViewHolder(@NonNull final NetworkAdapter.ViewHolder viewHolder, final int i) {

        final NetworkCallITable networkCallInformationForDB = posts.get(i);
        //set value to holder view items
        viewHolder.date.setText(Common.formatDate(new Date(networkCallInformationForDB.getRequestDate()).getTime()));
        viewHolder.requestParameter.setText(networkCallInformationForDB.getRequestParameters());
        viewHolder.causeOfError.setText(networkCallInformationForDB.getRequestName());
        viewHolder.requestUrl.setText(networkCallInformationForDB.getResponseMessage());

    }

    /**
     * number of item
     */


    @Override
    public int getItemCount() {
        return posts.size();
    }


    /**
     * ViewHolder to set view to RecyclerView
     */
    class ViewHolder extends RecyclerView.ViewHolder {
        TextView requestParameter, causeOfError, requestUrl, date;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            requestParameter = itemView.findViewById(R.id.requestparamet);
            requestUrl = itemView.findViewById(R.id.causeoferror);
            causeOfError = itemView.findViewById(R.id.requrl);
            date = itemView.findViewById(R.id.date);


        }
    }
}

