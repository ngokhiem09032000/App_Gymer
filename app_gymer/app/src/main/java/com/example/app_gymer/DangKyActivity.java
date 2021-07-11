package com.example.app_gymer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class DangKyActivity extends AppCompatActivity {
    private EditText ten,sdt,email,matkhau,matkhau2,chieucao,cannang;
    private Button themTK;
    String urlInsert = "http://192.168.1.8:8080/test/insert_KH.php";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dangky);
        Anhxa();
        themTK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    String ten1 = ten.getText().toString().trim();
                    String sdt1 = sdt.getText().toString().trim();
                    String email1 = email.getText().toString().trim();
                    String  matkhau1 = matkhau.getText().toString().trim();
                    String matkhau21 = matkhau2.getText().toString().trim();
                    String chieucao1 = chieucao.getText().toString().trim();
                    String cannang1 = cannang.getText().toString().trim();
                    if(ten1.isEmpty()||sdt1.isEmpty()||email1.isEmpty()||matkhau1.isEmpty()||matkhau21.isEmpty()||chieucao1.isEmpty()||cannang1.isEmpty())
                    {
                        Toast.makeText(DangKyActivity.this, "Vui lòng Nhập Đủ Thông Tin", Toast.LENGTH_SHORT).show();
                    }
                    else if(!matkhau1.equals(matkhau21))
                    {
                        Toast.makeText(DangKyActivity.this, "Vui lòng Nhập Mật Khẩu Lần 2 Chính Xác", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        ThemKhachHang(urlInsert);
                    }
            }
        });
    }

    private  void ThemKhachHang(String url)
    {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(DangKyActivity.this, response, Toast.LENGTH_SHORT).show();
                            if(response.trim().equals("success"))
                            {
                                Toast.makeText(DangKyActivity.this, "Đăng Ký Thành Công", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(DangKyActivity.this,MainActivity.class));
                            }else
                            {
                                Toast.makeText(DangKyActivity.this, "Lỗi Đăng Ký", Toast.LENGTH_SHORT).show();
                            }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(DangKyActivity.this, "Xảy ra lỗi", Toast.LENGTH_SHORT).show();
            }
        }){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String , String > map = new HashMap<>();
                map.put("hoten",ten.getText().toString().trim());
                map.put("sdt",sdt.getText().toString().trim());
                map.put("email",email.getText().toString().trim());
                map.put("cannang",cannang.getText().toString().trim());
                map.put("chieucao",chieucao.getText().toString().trim());
                map.put("matkhau",matkhau.getText().toString().trim());
                return map;
            }
        };
        requestQueue.add(stringRequest) ;
    }

    private void Anhxa() {
        ten = findViewById(R.id.tenkh);
        email = findViewById(R.id.email);
        sdt = findViewById(R.id.sdt);
        matkhau = findViewById(R.id.matkhau);
        matkhau2 = findViewById(R.id.matkhau2);
        themTK = findViewById(R.id.themtaikhoan);
        chieucao = findViewById(R.id.chieucao);
        cannang = findViewById(R.id.cannang);
    }

}
