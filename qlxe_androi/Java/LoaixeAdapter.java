package com.example.qlbanxe2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class LoaixeAdapter extends BaseAdapter {
    Context ct;
    int mylyout;
    ArrayList<Loaixe> mangloaixe;

    public LoaixeAdapter(Context ct, int mylyout, ArrayList<Loaixe> mangloaixe){
        this.ct=ct;
        this.mylyout=mylyout;
        this.mangloaixe=mangloaixe;
    }

    @Override
    public int getCount() {
        return mangloaixe.size();
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
        TextView txtTenloaixe;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder vh;
        if (convertView==null){
            vh =  new ViewHolder();
            LayoutInflater layoutInflater = (LayoutInflater) ct.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(mylyout, null);
            vh.txtTenloaixe = (TextView) convertView.findViewById(R.id.textViewTenloaixe);
            convertView.setTag(vh);
        }else{
            vh=(ViewHolder) convertView.getTag();
        }
        Loaixe x = mangloaixe.get(position);
        vh.txtTenloaixe.setText(x.getTenloai());
        return convertView;
    }
}
