package com.example.app_gymer;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Exercise_Page extends AppCompatActivity {
    String url ="http://192.168.1.8:8080/test/getdata.php";

    ListView listView;
    ArrayList<BaiTap> loaiBts;
    LoaiBT_Adapter adapter;
    TextView soluonggiohang;

    DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exercise);
        if(getIntent().getSerializableExtra("cannang")!=null) {
            int cannang = (int) getIntent().getSerializableExtra("cannang");
            int chieucao = (int) getIntent().getSerializableExtra("chieucao");
            TinhBMI(cannang, chieucao);
        }

        setSoluonggiohang();


        listView = findViewById(R.id.LV_Exercise);
        loaiBts = new ArrayList<>();
        adapter = new LoaiBT_Adapter(this,R.layout.item_bt,loaiBts);
        listView.setAdapter(adapter);
        GetData(url);
        drawerLayout = findViewById(R.id.drawer_layout);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(Exercise_Page.this,Huong_Dan_tap.class);
                intent.putExtra("tenloaibt", position);
                startActivity(intent);
            }
        });
    }

    private void setSoluonggiohang()
    {
        soluonggiohang = findViewById(R.id.soluonggiohang);
        soluonggiohang.setText("Gi??? h??ng"+" ("+GioHangToanCuc.hang.size()+") ");
    }

    private void GetData(String url)
    {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        for(int i = 0; i<response.length();i++)
                        {
                            try {
                                JSONObject jsonObject = response.getJSONObject(i);
                                loaiBts.add(new BaiTap(
                                        jsonObject.getString("tenloaibt"),
                                        jsonObject.getString("hinh")));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }
                        adapter.notifyDataSetChanged();


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Exercise_Page.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        });
        requestQueue.add(jsonArrayRequest);
    }

    public void ClickMenu(View view) {
        openDrawer(drawerLayout);
    }

    public static void openDrawer(DrawerLayout drawerLayout) {
        drawerLayout.openDrawer(GravityCompat.START);
    }

    public void ClickDashboard(View view)
    {
        redirectActivity(this,Nhac_Luyen_Tap.class);
    }

    public static void closeDrawer(DrawerLayout drawerLayout) {
        if(drawerLayout.isDrawerOpen(GravityCompat.START))
        {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }

    public void ClickHome(View view)
    {
        recreate();
    }


    public void ClickBuy(View view)
    {
        redirectActivity(this,Product_Page.class);
    }

    public static void redirectActivity(Activity activity,Class aClass) {
        Intent intent = new Intent(activity,aClass);

        intent.setFlags(intent.FLAG_ACTIVITY_NEW_TASK);

        activity.startActivity(intent);

    }
    public void ClickCart(View view)
    {
        redirectActivity(this,GioHang_Page.class);
    }
    public void ClickLogout(View view)
    {
        logout(this);
    }

    public static void logout(Activity activity) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);

        builder.setTitle("Logout");
        builder.setMessage("Are you sure want to logout?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                activity.finishAffinity();
                System.exit(0);
            }
        });
        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.show();
    }

    @Override
    protected void onPause() {
        super.onPause();

        closeDrawer(drawerLayout);
    }

    private void TinhBMI(int cannang, int chieucao)
    {
        float BMI = (float) cannang/(((float) chieucao/100)*2);
        if(BMI<18.5)
        {
            Toast.makeText(this, "Ch??? s??? BMI c???a b???n l?? : "+BMI+"\nB???n ??ang r???t g??y.\n B???n n??n t???p b??i t???p To??n th??n", Toast.LENGTH_LONG).show();
        }else if(BMI<25)
        {
            Toast.makeText(this, "Ch??? s??? BMI c???a b???n l?? : "+BMI+"\nB???n b??nh th?????ng.\n B???n n??n t???p b??i t???p B???ng v?? ng???c", Toast.LENGTH_LONG).show();
        }
        else if(BMI<35)
        {
            Toast.makeText(this, "Ch??? s??? BMI c???a b???n l?? : "+BMI+"\nB???n ??ang ??? m???c ????? b??o ph?? c???p ????? 1.\n B???n n??n t???p b??i t???p To??n th??n v?? Th??n d?????i", Toast.LENGTH_LONG).show();
        }else if(BMI<40)
        {
            Toast.makeText(this, "Ch??? s??? BMI c???a b???n l?? : "+BMI+"\nB???n ??ang ??? m???c ????? b??o ph?? c???p ????? 2.\n B???n n??n t???p b??i t???p To??n th??n v?? Th??n d?????i v?? b???ng", Toast.LENGTH_LONG).show();

        }else
        {
            Toast.makeText(this, "Ch??? s??? BMI c???a b???n l?? : "+BMI+"\nB???n ??ang ??? m???c ????? b??o ph?? c???p ????? 3.\n B???n n??n t???p b??i t???p T???t c??? c??c b??i t???p", Toast.LENGTH_LONG).show();
        }
    }
}
