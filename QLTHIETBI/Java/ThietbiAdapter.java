package com.example.qlthietbi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ThietbiAdapter extends BaseAdapter {
    Context mycontext;
    int mylayout;
    ArrayList<Thietbi> mangthietbi;

    public ThietbiAdapter(Context mycontext, int mylayout, ArrayList<Thietbi> mangthietbi) {
        this.mycontext = mycontext;
        this.mylayout = mylayout;
        this.mangthietbi = mangthietbi;
    }

    @Override
    public int getCount() {
        return mangthietbi.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    private class ViewHolder
    {
        TextView txtvMamay,txtvTenmay,txtvMaloaimay, txtvDonvitinh, txtvSoluong;
        ImageView imgAnh;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView==null){
            viewHolder=new ViewHolder();
            LayoutInflater inflater=(LayoutInflater) mycontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(mylayout,null);
            viewHolder.txtvMamay=(TextView)convertView.findViewById(R.id.textViewMamay);
            viewHolder.txtvTenmay=(TextView)convertView.findViewById(R.id.textViewTenmay);
            viewHolder.txtvMaloaimay=(TextView)convertView.findViewById(R.id.textViewMaloaimay);
            viewHolder.txtvDonvitinh=(TextView)convertView.findViewById(R.id.textViewDonvitinh);
            viewHolder.txtvSoluong=(TextView)convertView.findViewById(R.id.textViewSoluong);
            viewHolder.imgAnh=(ImageView) convertView.findViewById(R.id.imageViewHinh);
            convertView.setTag(viewHolder);
        }else {
            viewHolder=(ViewHolder) convertView.getTag();
        }
        Thietbi tb=mangthietbi.get(position);
        viewHolder.txtvMamay.setText(tb.getMamay());
        viewHolder.txtvTenmay.setText(tb.getTenmay());
        viewHolder.txtvMaloaimay.setText(tb.getMaloaimay());
        viewHolder.txtvDonvitinh.setText(tb.getDonvitinh());
        viewHolder.txtvSoluong.setText(String.valueOf(tb.getSoluong()));
//        Context context = viewHolder.imgAnh.getContext();
//        int id = context.getResources().getIdentifier(tb.getAnh(), "drawable", context.getPackageName());
//        viewHolder.imgAnh.setImageResource(id);
        Glide.with(mycontext).load(tb.getAnh()).into(viewHolder.imgAnh);

        return convertView;
    }
}
