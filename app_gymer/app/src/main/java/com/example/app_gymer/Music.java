package com.example.app_gymer;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import java.security.Provider;

public class Music extends Service {
    MediaPlayer mediaPlayer;
    PendingIntent pendingIntent2;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e("Tôi trong Music","Xin chào");
        String Key = intent.getExtras().getString("extra");
        Log.e("Tôi trong Music",Key);
        if(Key.equals("on"))
        {
            mediaPlayer = MediaPlayer.create(this, R.raw.nhacchuong);
            mediaPlayer.start();
            Key = "off";
            Intent intent2 = new Intent(Music.this,Nhac_Luyen_Tap.class);
            intent2.putExtra("yes",true);
            intent2.addFlags(intent2.FLAG_ACTIVITY_SINGLE_TOP|Intent.FLAG_ACTIVITY_NEW_TASK);

            pendingIntent2 = PendingIntent.getActivity(Music.this,0,intent2,PendingIntent.FLAG_ONE_SHOT);


            if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O)
            {
                NotificationChannel channel = new NotificationChannel("My notification","My notification", NotificationManager.IMPORTANCE_DEFAULT);
                NotificationManager manager =getSystemService(NotificationManager.class);
                manager.createNotificationChannel(channel);
            }

            NotificationCompat.Builder builder = new NotificationCompat.Builder(Music.this, "My notification")
                    .setSmallIcon(R.drawable.logo1)
                    .setContentTitle("Nhắc nhở luyện tập")
                    .setContentText("Đến giờ tập rồi. Hãy tập luyện ngay thôi để có 1 sức khoẻ tốt nào.")
                    .setAutoCancel(true);
            builder.addAction(R.drawable.ic_launcher_foreground,"OPEN",pendingIntent2);
            NotificationManagerCompat managerCompat = NotificationManagerCompat.from(Music.this);
            managerCompat.notify(1,builder.build());
        }else if(Key.equals("off"))
        {
            mediaPlayer.stop();
            mediaPlayer.reset();
        }


        return START_NOT_STICKY;
    }
}
