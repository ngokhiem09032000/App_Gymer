package com.example.app_gymer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class SamPham_Adapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<SanPham> sanPhamList;

    public SamPham_Adapter(Context context, int layout, List<SanPham> sanPhamList) {
        this.context = context;
        this.layout = layout;
        this.sanPhamList = sanPhamList;
    }

    @Override
    public int getCount() {
        return sanPhamList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    class ViewHolder{
        TextView txtSanPham;
        ImageView imgBG;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null)
        {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout,null);
            holder.txtSanPham = (TextView) convertView.findViewById(R.id.bt);
            holder.imgBG = (ImageView) convertView.findViewById(R.id.avatar);
            convertView.setTag(holder);
        }
        else
        {
            holder = (ViewHolder) convertView.getTag();
        }

        SanPham sanPham = sanPhamList.get(position);
        holder.txtSanPham.setText(sanPham.getTenbt());
        Picasso.with(context).load(sanPham.getHinh()).placeholder(R.drawable.ic_launcher_background).error(R.drawable.ic_launcher_background)
                .into(holder.imgBG);
        return convertView;
    }
}
