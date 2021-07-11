package com.example.app_gymer;

import android.app.AlarmManager;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;

public class AlarmReceiver extends BroadcastReceiver {
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onReceive(Context context, Intent intent) {
         Log.e("toi trong receiver","hello");
         String chuoi = intent.getExtras().getString("extra");
         Intent myIntent= new Intent(context,Music.class);
         myIntent.putExtra("extra",chuoi);
         context.startService(myIntent);
    }
}
