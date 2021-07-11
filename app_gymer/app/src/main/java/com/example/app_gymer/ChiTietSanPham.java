package com.example.app_gymer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class ChiTietSanPham extends AppCompatActivity {
    Button btnquayve;
    ImageView anh;
    TextView tvtensp,tvgia,tvmota;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chitietsanpham);
        anhxa();
        LoadChiTiet();
        btnquayve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChiTietSanPham.this,Product_Page.class);
                startActivity(intent);
            }
        });
    }

    private void LoadChiTiet() {
        SanPham sanpham = (SanPham) getIntent().getSerializableExtra("sanpham");
        tvtensp.setText(sanpham.getTenbt());
        tvgia.setText(sanpham.getGia());
        tvmota.setText(sanpham.getMota());
        Picasso.with(this).load(sanpham.getHinh()).placeholder(R.drawable.ic_launcher_background).error(R.drawable.ic_launcher_background)
                .into(anh);
    }

    private void anhxa() {
        btnquayve = findViewById(R.id.quaylai2);
        anh = findViewById(R.id.anhsp);
        tvtensp = findViewById(R.id.tensp);
        tvgia = findViewById(R.id.gia);
        tvmota = findViewById(R.id.motasp);
    }
}
