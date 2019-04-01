package com.enjaz.debug.logging.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import com.enjaz.debug.logging.R;

import com.enjaz.debug.logging.entities.UserActivityTable;
import com.enjaz.debug.logging.helper.Common;
import com.ramotion.foldingcell.FoldingCell;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    private Context context;

    private List<UserActivityTable> posts;

    UserAdapter(Context context, List<UserActivityTable> posts) {

        this.context = context;
        this.posts = posts;


    }

    //get layout that display info.
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View v = LayoutInflater.from(context).inflate(R.layout.user_details, viewGroup, false);

        return new ViewHolder(v);
    }

    /**
     * set views
     */

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {

        final UserActivityTable userActivity = posts.get(i);
        //set value to holder view items
        viewHolder.activityName.setText(userActivity.getActivityName());
        viewHolder.className.setText(userActivity.getClassFullName());
        viewHolder.date.setText(Common.formatDate(userActivity.getDate()));
        viewHolder.usesid.setText("uses "+userActivity.getId());
        // attach click listener to folding cell
        viewHolder.fc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewHolder.fc.toggle(false);
            }
        });

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
        TextView activityName, className, date,usesid;
         FoldingCell fc;
        ViewHolder(@NonNull View itemView) {
            super(itemView);
            activityName = itemView.findViewById(R.id.activityname);
            className = itemView.findViewById(R.id.classname);
            date = itemView.findViewById(R.id.time);
            usesid=itemView.findViewById(R.id.usesid);
           fc = itemView.findViewById(R.id.folding_cell);



        }
    }
}