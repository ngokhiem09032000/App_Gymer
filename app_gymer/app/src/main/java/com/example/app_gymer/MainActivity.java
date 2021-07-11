package com.example.app_gymer;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    EditText TenDN;
    EditText Matkhau;
    String url = "http://192.168.1.8:8080/test/get_Login.php";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dangnhap);
        TenDN = findViewById(R.id.TenDN);
        Matkhau = findViewById(R.id.MatKhau);
        chuyenTrang2(url);
        chuyenTrang();

    }




    public void chuyenTrang() {
        Button button = findViewById(R.id.dangky);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DangKyActivity.class);
                startActivity(intent);
            }
        });
    }
    public void Login_Success(int cannang, int chieucao)
    {
        Intent intent = new Intent(MainActivity.this, Exercise_Page.class);
        intent.putExtra("cannang",cannang);
        intent.putExtra("chieucao",chieucao);
        startActivity(intent);
    }


    private void Login(String url) {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        for(int i = 0; i<response.length();i++)
                        {
                            try {
                                JSONObject jsonObject = response.getJSONObject(i);
                                if(jsonObject.getString("sdt").equals( TenDN.getText().toString())
                                        && jsonObject.getString("matkhau").equals(Matkhau.getText().toString()))
                                {
                                    Login_Success(jsonObject.getInt("cannang"),jsonObject.getInt("chieucao"));
                                    return;
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }
                        Toast.makeText(MainActivity.this, "Tên đăng nhập hoặc mật khẩu sai", Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "Loi", Toast.LENGTH_SHORT).show();
            }
        });
        requestQueue.add(jsonArrayRequest);
    }

    public void chuyenTrang2(String url) {
        Button button = findViewById(R.id.dangnhap);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Login(url);
            }
        });
    }



}