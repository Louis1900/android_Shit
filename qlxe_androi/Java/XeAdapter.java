package com.example.qlbanxe2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class XeAdapter extends BaseAdapter {
    Context ct;
    int mylayout;
    ArrayList<Xe> mangxe;

    public XeAdapter(Context ct, int mylayout, ArrayList<Xe> mangxe) {
        this.ct = ct;
        this.mylayout = mylayout;
        this.mangxe = mangxe;
    }

    @Override
    public int getCount() {
        return mangxe.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public class ViewHolder{
        TextView txtTenxe, txtNamsx;
        ImageView imgHinh;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder vh = new ViewHolder();
        if (convertView==null){
            LayoutInflater layoutInflater = (LayoutInflater) ct.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=layoutInflater.inflate(mylayout, null);
            vh.txtTenxe = (TextView) convertView.findViewById(R.id.textViewTenxe);
            vh.txtNamsx = (TextView) convertView.findViewById(R.id.textViewNamsx);
            vh.imgHinh = (ImageView) convertView.findViewById(R.id.imageViewHinh);
            convertView.setTag(vh);
        }else{
            vh=(ViewHolder) convertView.getTag();
        }
        Xe xe = mangxe.get(position);
        vh.txtTenxe.setText(xe.tenxe);
        vh.txtNamsx.setText(xe.namsx);
        Glide.with(ct).load(xe.getHinh()).into(vh.imgHinh);
        return convertView;
    }
}
