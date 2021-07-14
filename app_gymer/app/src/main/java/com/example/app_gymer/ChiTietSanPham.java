package com.example.app_gymer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ChiTietSanPham extends AppCompatActivity {
    Button btnquayve,themgiohang;
    ImageView anh;
    TextView tvtensp,tvgia,tvmota;
    Spinner soluong ;
    String hinh;
    SanPham sanpham;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chitietsanpham);
        anhxa();
        sanpham = (SanPham) getIntent().getSerializableExtra("sanpham");
        LoadChiTiet();
        LoadSpn();
        btnquayve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChiTietSanPham.this,Product_Page.class);
                startActivity(intent);
            }
        });
        ThemGH();
    }

    private void LoadSpn() {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        list.add("7");
        list.add("8");
        list.add("9");
        list.add("10");

        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item,list);
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);

        soluong.setAdapter(adapter);
    }

    private void LoadChiTiet() {
        hinh = sanpham.getHinh();
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
        soluong = findViewById(R.id.spnSoluong);
        themgiohang = findViewById(R.id.themgiohang);
    }

    private void ThemGH()
    {
        themgiohang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int tontai=0;
                Intent intent = new Intent(ChiTietSanPham.this,GioHang_Page.class);
                GioHang gioHang = new GioHang();
                gioHang.setMasp(sanpham.getMasp());
                gioHang.setTensp(tvtensp.getText().toString());
                gioHang.setGia(tvgia.getText().toString());
                String a =soluong.getSelectedItem().toString();
                int b = Integer.valueOf(a);
                gioHang.setSoluong(b);
                gioHang.setHinh(hinh);
                for(int i = 0;i<GioHangToanCuc.hang.size();i++)
                {
                    if(gioHang.getTensp().equals(GioHangToanCuc.hang.get(i).getTensp()))
                    {

                        GioHangToanCuc.hang.get(i).setSoluong(GioHangToanCuc.hang.get(i).getSoluong()+gioHang.getSoluong());
                        if(GioHangToanCuc.hang.get(i).getSoluong()>10)
                        {
                            GioHangToanCuc.hang.get(i).setSoluong(10);
                        }
                        tontai = 1;
                        break;
                    }

                }
                if(tontai==0)
                {
                    GioHangToanCuc.hang.add(gioHang);
                    startActivity(intent);
                }else
                {
                    startActivity(intent);
                }


            }
        });
    }
}
