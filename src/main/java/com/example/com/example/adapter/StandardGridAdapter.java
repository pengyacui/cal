package com.example.com.example.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.calculator.CircleTextView;
import com.example.calculator.R;

public class StandardGridAdapter extends BaseAdapter {

    //,"√"

    private String[] strings;

    public StandardGridAdapter(String[] names){
        strings=names;
    }

    @Override
    public int getCount() {
        return strings.length;
    }

    @Override
    public Object getItem(int position) {
        return strings[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        StandardGridViewHolder sgholder=null;
        if(convertView==null){
            sgholder=new StandardGridViewHolder();
//            if((position+1)%4==0){
//                convertView=LayoutInflater.from(parent.getContext()).inflate(R.layout.item_circle_btn,null);
//                sgholder.tv= (CircleTextView) convertView.findViewById(R.id.btn_circle);

//            }else {
                convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_btn, null);
                sgholder.tv = (TextView) convertView.findViewById(R.id.btn_num);
//            }
            convertView.setTag(sgholder);
        }else{
            sgholder= (StandardGridViewHolder) convertView.getTag();
        }

        sgholder.tv.setText(strings[position]);
        return convertView;
    }

    class StandardGridViewHolder{
        private TextView tv;
    }
}
