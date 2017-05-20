package com.example.com.example.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.calculator.R;

import java.util.List;

public class ShowAdapter extends BaseAdapter {

    private List<String> strs;
    private LayoutInflater mInflater;
    private Context mContext;

    public ShowAdapter(Context context,List<String> strings){
        strs=strings;
        mContext=context;
        mInflater=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return strs.size();
    }

    @Override
    public Object getItem(int position) {
        return strs.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder=null;
        if(convertView==null){
            holder=new ViewHolder();
            convertView=mInflater.inflate(R.layout.item_show,null);
            holder.tv_show= (TextView) convertView.findViewById(R.id.tv_show);
            convertView.setTag(holder);
        }else{
            holder= (ViewHolder) convertView.getTag();
        }
        if(position==strs.size()-1){
            holder.tv_show.setTextSize(40);
        }else {
            holder.tv_show.setTextSize(20);
        }
        holder.tv_show.setText(strs.get(position));
        return convertView;
    }

    class ViewHolder{
        private TextView tv_show;
    }
}
