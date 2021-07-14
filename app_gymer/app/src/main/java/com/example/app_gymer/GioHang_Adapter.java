package com.example.app_gymer;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class GioHang_Adapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<GioHang> GioHangList;
    public GioHang_Adapter(Context context, int layout, List<GioHang> gioHangList) {
        this.context = context;
        this.layout = layout;
        GioHangList = gioHangList;
    }

    @Override
    public int getCount() {
        return GioHangList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(layout,null);
        TextView tvtensp = (TextView) convertView.findViewById(R.id.tensp);
        TextView tvgia = (TextView) convertView.findViewById(R.id.gia);
        Spinner spsoluong = (Spinner) convertView.findViewById(R.id.spnSoluong);

        List<String> list = new ArrayList<>();
        list.add("0");
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

        ArrayAdapter<String> adapter = new ArrayAdapter(context, android.R.layout.simple_spinner_item,list);
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spsoluong.setAdapter(adapter);
        spsoluong.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position1, long id) {
                GioHangToanCuc.hang.get(position).setSoluong(Integer.valueOf(spsoluong.getSelectedItem().toString()));

                int tong=0;
                for(int i = 0 ;i<GioHangToanCuc.hang.size();i++)
                {
                    tong+=(Integer.valueOf(GioHangToanCuc.hang.get(i).getGia()) * GioHangToanCuc.hang.get(i).getSoluong());
                }
                String tien = String.valueOf(tong);
                GioHang_Page.tongtien.setText(tien + "Đ");
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        ImageView imgBG = (ImageView) convertView.findViewById(R.id.anh);
        ImageButton xoa = (ImageButton)convertView.findViewById(R.id.delete);

        xoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i = 0 ;i<GioHangToanCuc.hang.size();i++)
                {
                    if(GioHangToanCuc.hang.get(i).getTensp().equals(tvtensp.getText().toString()))
                    {
                        GioHangToanCuc.hang.remove(i);
                        break;
                    }
                }
                int tong=0;
                for(int i = 0 ;i<GioHangToanCuc.hang.size();i++)
                {
                    tong+=(Integer.valueOf(GioHangToanCuc.hang.get(i).getGia()) * GioHangToanCuc.hang.get(i).getSoluong());
                }
                String tien = String.valueOf(tong);
                GioHang_Page.tongtien.setText(tien + "Đ");
                notifyDataSetChanged();
            }
        });

        GioHang gioHang = GioHangList.get(position);
        tvtensp.setText(gioHang.getTensp());
        tvgia.setText(gioHang.getGia());
        spsoluong.setSelection(gioHang.getSoluong());
        Picasso.with(context).load(gioHang.getHinh()).placeholder(R.drawable.ic_launcher_background).error(R.drawable.ic_launcher_background)
                .into(imgBG);
        return convertView;
    }

}
