package com.example.app_gymer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class DatHangThanhCong extends AppCompatActivity{
    Button muatiep;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dathangthanhcong);
        muatiep = findViewById(R.id.muatiep1);
        muatiep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GioHangToanCuc.hang.clear();
                Intent intent = new Intent(DatHangThanhCong.this,Product_Page.class);
                startActivity(intent);
            }
        });
    }
}
