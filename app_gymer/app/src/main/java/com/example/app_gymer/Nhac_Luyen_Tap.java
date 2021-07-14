package com.example.app_gymer;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import java.nio.channels.Channel;
import java.util.Calendar;

public class Nhac_Luyen_Tap extends AppCompatActivity {
    TimePicker timePicker;
    Button hengio,tathen,quayve;
    TextView thoigian;
    Calendar calendar;
    AlarmManager alarmManager;
    PendingIntent pendingIntent;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nhac_luyen_tap);
        Anhxa();

        Intent intent =new Intent(Nhac_Luyen_Tap.this,AlarmReceiver.class);
        hengio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calendar.set(Calendar.HOUR_OF_DAY,timePicker.getCurrentHour());
                calendar.set(calendar.MINUTE,timePicker.getCurrentMinute());
                int gio = timePicker.getCurrentHour();
                int phut = timePicker.getCurrentMinute();
                String string_gio = String.valueOf(gio);
                String string_phut;
                if(phut<10) {
                    string_phut = "0"+String.valueOf(phut);
                }else
                {
                    string_phut =String.valueOf(phut);
                }
                intent.putExtra("extra","on");
                pendingIntent = PendingIntent.getBroadcast(Nhac_Luyen_Tap.this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);
                alarmManager.set(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),pendingIntent);
                thoigian.setText("Giờ bạn hẹn là: "+string_gio+":"+string_phut);
            }
        });
        tathen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thoigian.setText("Tắt hẹn");
                alarmManager.cancel(pendingIntent);
                intent.putExtra("extra","off");
                sendBroadcast(intent);
            }

        });
        quayve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Nhac_Luyen_Tap.this,Product_Page.class);
                startActivity(intent);
            }
        });
    }

    @SuppressLint("ServiceCast")
    private void Anhxa()
    {
        timePicker = findViewById(R.id.timepicker);
        hengio = findViewById(R.id.hengio);
        tathen = findViewById(R.id.tathengio);
        thoigian = findViewById(R.id.thoigian);
        calendar = Calendar.getInstance();
        alarmManager= (AlarmManager) getSystemService(ALARM_SERVICE);
        quayve = (Button) findViewById(R.id.quaylai3);
    }
}
