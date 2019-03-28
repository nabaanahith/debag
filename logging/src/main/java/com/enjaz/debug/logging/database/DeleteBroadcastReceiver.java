package com.enjaz.debug.logging.database;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class DeleteBroadcastReceiver extends BroadcastReceiver {

/* delete all table from db when its trigger by the alarm manger */
    @Override
    public void onReceive(Context context, Intent intent) {

        new DeleteAsyncTask(context).execute();


    }
}
