package com.example.app_gymer;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static com.example.app_gymer.Exercise_Page.closeDrawer;
import static com.example.app_gymer.Exercise_Page.redirectActivity;

public class Product_Page extends AppCompatActivity {
    String url ="http://192.168.1.8:8080/test/getdata_sanpham.php";

    ListView listView;
    ArrayList<SanPham> sanPhams,sanPhams1,sanPhams2,sanPhams3;
    SamPham_Adapter adapter;
    ViewFlipper quangcao;
    TextView soluonggiohang;
    Spinner spiloaisp;

    DrawerLayout drawerLayout;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product);
        listView = findViewById(R.id.LV_Product);
        quangcao = findViewById(R.id.flipper);

        spiloaisp = findViewById(R.id.loaisp);
        Loadloaisp();
        LoaiSPChange();

        sanPhams = new ArrayList<>();
        sanPhams1 = new ArrayList<>();
        sanPhams2 = new ArrayList<>();
        sanPhams3 = new ArrayList<>();
        adapter = new SamPham_Adapter(Product_Page.this,R.layout.item_bt,sanPhams);
        listView.setAdapter(adapter);
        GetData(url);


        drawerLayout = findViewById(R.id.drawer_layout2);

        setSoluonggiohang();
        ActionQuangCao();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(),ChiTietSanPham.class);
                if(spiloaisp.getSelectedItemPosition()==0)
                {
                    intent.putExtra("sanpham", sanPhams.get(position));
                }else if(spiloaisp.getSelectedItemPosition()==1)
                {
                    intent.putExtra("sanpham", sanPhams1.get(position));
                }else if(spiloaisp.getSelectedItemPosition()==2)
                {
                    intent.putExtra("sanpham", sanPhams2.get(position));
                }else
                {
                    intent.putExtra("sanpham", sanPhams3.get(position));
                }

                startActivity(intent);
            }
        });

    }

    private void setSoluonggiohang()
    {
        soluonggiohang = findViewById(R.id.soluonggiohang);
        soluonggiohang.setText("Giỏ hàng"+" ("+GioHangToanCuc.hang.size()+") ");
    }

    private void LoaiSPChange()
    {
        spiloaisp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==0)
                {
                    adapter = new SamPham_Adapter(Product_Page.this,R.layout.item_bt,sanPhams);
                    listView.setAdapter(adapter);
                }else if(position==1)
                {
                    adapter = new SamPham_Adapter(Product_Page.this,R.layout.item_bt,sanPhams1);
                    listView.setAdapter(adapter);
                }else if(position==2)
                {
                    adapter = new SamPham_Adapter(Product_Page.this,R.layout.item_bt,sanPhams2);
                    listView.setAdapter(adapter);
                }else
                {
                    adapter = new SamPham_Adapter(Product_Page.this,R.layout.item_bt,sanPhams3);
                    listView.setAdapter(adapter);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }



    private void ActionQuangCao() {
//        ArrayList<String> mangQuangCao = new ArrayList<>();
//        list_quangcao.add("http://192.168.1.8:8080/img/QuangCao1.jpg");
//        list_quangcao.add("http://192.168.1.8:8080/img/QuangCao2.png");
//        list_quangcao.add("http://192.168.1.8:8080/img/QuangCao3.jpg");
        for(int i=0; i<GioHangToanCuc.quangCao_list.size();i++)
        {
            ImageView imageView = new ImageView(getApplicationContext());
            Picasso.with(getApplicationContext()).load(GioHangToanCuc.quangCao_list.get(i)).into(imageView);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            quangcao.addView(imageView);
        }
        quangcao.setFlipInterval(3000);
        quangcao.setAutoStart(true);
        Animation animation_in = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_in_right);
        Animation animation_out = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_out_right);
        quangcao.setInAnimation(animation_in);
        quangcao.setOutAnimation(animation_out);
    }




    private void GetData(String url) {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        for(int i = 0; i<response.length();i++)
                        {
                            try {
                                JSONObject jsonObject = response.getJSONObject(i);
                                sanPhams.add(new SanPham(
                                        jsonObject.getString("id"),
                                        jsonObject.getString("tensp"),
                                        jsonObject.getString("hinh"),
                                        jsonObject.getString("gia"),
                                        jsonObject.getString("mota"),
                                        jsonObject.getString("maloai")
                                        ));
                                if(jsonObject.getString("maloai").equals("loai001"))
                                {
                                    sanPhams1.add(new SanPham(
                                            jsonObject.getString("id"),
                                            jsonObject.getString("tensp"),
                                            jsonObject.getString("hinh"),
                                            jsonObject.getString("gia"),
                                            jsonObject.getString("mota"),
                                            jsonObject.getString("maloai")
                                    ));
                                }else if(jsonObject.getString("maloai").equals("loai002"))
                                {
                                    sanPhams2.add(new SanPham(
                                            jsonObject.getString("id"),
                                            jsonObject.getString("tensp"),
                                            jsonObject.getString("hinh"),
                                            jsonObject.getString("gia"),
                                            jsonObject.getString("mota"),
                                            jsonObject.getString("maloai")
                                    ));
                                }else
                                {
                                    sanPhams3.add(new SanPham(
                                            jsonObject.getString("id"),
                                            jsonObject.getString("tensp"),
                                            jsonObject.getString("hinh"),
                                            jsonObject.getString("gia"),
                                            jsonObject.getString("mota"),
                                            jsonObject.getString("maloai")
                                    ));
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }
                        adapter.notifyDataSetChanged();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Product_Page.this, "Loi", Toast.LENGTH_SHORT).show();
            }
        });
        requestQueue.add(jsonArrayRequest);
    }



    private void Loadloaisp() {
        List<String> list = new ArrayList<>();
        list.add("Tất cả sản phẩm");
        list.add("Việt Nam");
        list.add("USA");
        list.add("Trung Quốc");

        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item,list);
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);

        spiloaisp.setAdapter(adapter);
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
        recreate();
    }
    public void ClickHome(View view)
    {
        Exercise_Page.redirectActivity(this,Exercise_Page.class);
    }
    public void ClickCart(View view)
    {
        Exercise_Page.redirectActivity(this,GioHang_Page.class);
    }
    public void ClickDashboard(View view)
    {
        Exercise_Page.redirectActivity(this,Nhac_Luyen_Tap.class);
    }
}
