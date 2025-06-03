package com.example.qlthietbi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class LoaiThietbiAdapter extends BaseAdapter {
    Context mycontext;
    int mylayout;
    ArrayList<LoaiThietbi> mangloaithietbi;

    public LoaiThietbiAdapter(Context mycontext, int mylayout, ArrayList<LoaiThietbi> mangloaithietbi) {
        this.mycontext = mycontext;
        this.mylayout = mylayout;
        this.mangloaithietbi = mangloaithietbi;
    }

    @Override
    public int getCount() {
        return mangloaithietbi.size();
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
        TextView txtvTenloaithietbi;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder vh;
        if(convertView==null){
            vh=new ViewHolder();
            LayoutInflater inflater=(LayoutInflater) mycontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(mylayout, null);
            vh.txtvTenloaithietbi=(TextView) convertView.findViewById(R.id.textViewTenloaithietbi);
            convertView.setTag(vh);
        }else{
            vh=(ViewHolder) convertView.getTag();
        }
        LoaiThietbi loaixe = mangloaithietbi.get(position);
        vh.txtvTenloaithietbi.setText(loaixe.getTenloaimay());
        return convertView;
    }
}
