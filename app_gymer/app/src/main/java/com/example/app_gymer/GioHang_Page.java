package com.example.app_gymer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GioHang_Page extends AppCompatActivity {
    ListView listView;
    GioHang_Adapter adapter;
    TextView soluonggiohang;
    public static TextView tongtien;
    Button dathang;

    String urlInsert = "http://192.168.1.8:8080/test/insert_HoaDon.php";

    String urlInsertChiTietHD = "http://192.168.1.8:8080/test/insert_ChiTietHD.php";

    String urlLayIDHD = "http://192.168.1.8:8080/test/layIDHD.php";


    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.giohang);
        anhxa();
        setTongtien();
        setSoluonggiohang();
        adapter = new GioHang_Adapter(this,R.layout.line_cart,GioHangToanCuc.hang);
        listView.setAdapter(adapter);
        layidHoaDon(urlLayIDHD);


        dathang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ThemHoaDon(urlInsert);
                for(int i=0;i<GioHangToanCuc.hang.size();i++)
                {
                    ThemChiTietHoaDon(urlInsertChiTietHD,i);
                }
                Intent intent = new Intent(GioHang_Page.this,DatHangThanhCong.class);
                startActivity(intent);
            }
        });
    }
    private void anhxa() {
        listView = findViewById(R.id.LV_Cart);
        drawerLayout = findViewById(R.id.drawer_layout3);
        tongtien = findViewById(R.id.tongtien);
        dathang = findViewById(R.id.dathang);
    }

    private void setTongtien()
    {
        //set tong tien
        int tong=0;
        for(int i = 0 ;i<GioHangToanCuc.hang.size();i++)
        {
            tong+=(Integer.valueOf(GioHangToanCuc.hang.get(i).getGia()) * GioHangToanCuc.hang.get(i).getSoluong());
        }
        String tien = String.valueOf(tong);
        tongtien.setText(tien + "Đ");
    }

    private void setSoluonggiohang()
    {
        soluonggiohang = findViewById(R.id.soluonggiohang);
        soluonggiohang.setText("Giỏ hàng"+" ("+GioHangToanCuc.hang.size()+") ");
    }

    private  void ThemHoaDon(String url)
    {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(GioHang_Page.this, "Xảy ra lỗi", Toast.LENGTH_SHORT).show();
            }
        }){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String , String > map = new HashMap<>();
                map.put("sdtkh",GioHangToanCuc.Sdtkh.toString().trim());

                Calendar c = Calendar.getInstance();
                int y = c.get(Calendar.YEAR);
                int m = c.get(Calendar.MONTH);
                int d = c.get(Calendar.DATE);

                map.put("ngaylap",String.valueOf(y+"/"+m+"/"+d));
                map.put("tongtien",tongtien.getText().toString().trim());
                return map;
            }
        };
        requestQueue.add(stringRequest) ;
    }




    private  void layidHoaDon(String url)
    {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        GioHangToanCuc.id = String.valueOf(Integer.valueOf(response)+1);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(GioHang_Page.this, "Xảy ra lỗi", Toast.LENGTH_SHORT).show();
            }
        });
        requestQueue.add(stringRequest) ;
    }



    private  void ThemChiTietHoaDon(String url,int thutu)
    {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(GioHang_Page.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        }){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String , String > map = new HashMap<>();
                map.put("mahd",GioHangToanCuc.id.toString().trim());
                map.put("masp",GioHangToanCuc.hang.get(thutu).getMasp().toString().trim());
                map.put("sl",String.valueOf( GioHangToanCuc.hang.get(thutu).getSoluong()).toString().trim());
                map.put("giadagiam",GioHangToanCuc.hang.get(thutu).getGia().toString().trim());
                int tong = Integer.valueOf(GioHangToanCuc.hang.get(thutu).getGia()) * GioHangToanCuc.hang.get(thutu).getSoluong();
                map.put("tongtien",String.valueOf(tong).toString().trim());


//                map.put("mahd","1");
//                map.put("masp","sp003");
//                map.put("sl","3");
//                map.put("giadagiam","100000");
//                map.put("tongtien","300000");
                return map;
            }
        };
        requestQueue.add(stringRequest) ;
    }








    public void ClickMenu(View view) {
        Exercise_Page.openDrawer(drawerLayout);
    }
    @Override
    protected void onPause() {
        super.onPause();

        Exercise_Page.closeDrawer(drawerLayout);
    }

    public void ClickLogout(View view)
    {
        Exercise_Page.logout(this);
    }
    public void ClickBuy(View view)
    {
        Exercise_Page.redirectActivity(this,Product_Page.class);
    }
    public void ClickHome(View view)
    {
        Exercise_Page.redirectActivity(this,Exercise_Page.class);
    }
    public void ClickCart(View view)
    {
        recreate();
    }
    public void ClickDashboard(View view)
    {
        Exercise_Page.redirectActivity(this,Nhac_Luyen_Tap.class);
    }

}
