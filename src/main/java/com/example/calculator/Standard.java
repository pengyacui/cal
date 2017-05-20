package com.example.calculator;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.com.example.adapter.ShowAdapter;
import com.example.com.example.adapter.StandardGridAdapter;

import java.util.ArrayList;
import java.util.List;

public class Standard extends Fragment {

    private List<String> showTexts;
    private boolean canback=false;
    private String tempString="";

    private String tempNum="";

    private float a=0;
    private float b=0;

    private boolean isPlus=false;
    private boolean isDivide=false;
    private boolean isMultiply=false;
    private boolean isSubtract=false;

    private ListView listView;

    private float endNum=0;

    private String[] mBtNnames=new String[]{"C","←","%","÷","7","8","9","×","4","5","6","－","1","2","3","＋","00","0",".","＝"};

    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        View standard=inflater.inflate(R.layout.fragment_standard,container,false);
        showTexts=new ArrayList<String>();

        initView(standard);

        return standard;
    }

    private boolean isEnd=false;
    private void initView(View view) {

        listView= (ListView) view.findViewById(R.id.standard_show_list);
        final ShowAdapter showAdapter=new ShowAdapter(getContext(),showTexts);
        listView.setAdapter(showAdapter);
        showAdapter.notifyDataSetChanged();
        GridView btn_grid= (GridView) view.findViewById(R.id.standard_btn_grid);
        btn_grid.setAdapter(new StandardGridAdapter(mBtNnames));

        btn_grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(tempString.equals("0")){
                    tempString="";
                }
                switch (position){
                    case 0://C
//                        if(!tempString.equals("")){
                            if(showTexts.size()>0) {
                                showTexts.remove(showTexts.size() - 1);
                            }
                            showTexts.add("0");
                            showAdapter.notifyDataSetChanged();
                            tempString="0";
//                        }
                        break;
                    case 1://backspace
                        if(!tempString.equals("")){

                        }
                        break;
                    case 2://%
                        tempString+="%";
                        if(tempNum!=null&&!tempNum.equals("")) {
                            a = Float.parseFloat(tempNum) / 100;
                            tempNum = "";
                        }else{
                            Toast.makeText(getContext(),"错误",Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case 3://  /
                        isDivide=true;
                        tempString+="÷";
                        if(tempNum!=null&&!tempNum.equals("")) {
                            a = Float.parseFloat(tempNum);
                            tempNum = "";
                        }else{
                            Toast.makeText(getContext(),"错误",Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case 4://7
                        tempString+="7";
                        tempNum+="7";
                        break;
                    case 5://8
                        tempString+="8";
                        tempNum+="8";
                        break;
                    case 6://9
                        tempString+="9";
                        tempNum+="9";
                        break;
                    case 7://X
                        isMultiply=true;
                        tempString+="×";
                        a=Float.parseFloat(tempNum);
                        tempNum="";
                        break;
                    case 8://4
                        tempString+="4";
                        tempNum+="4";
                        break;
                    case 9://5
                        tempString+="5";
                        tempNum+="5";
                        break;
                    case 10://6
                        tempString+="6";
                        tempNum+="6";
                        break;
                    case 11://-
                        isSubtract=true;
                        tempString+="-";
                        a=Float.parseFloat(tempNum);
                        tempNum="0";
                        break;
                    case 12://1
                        tempString+="1";
                        tempNum+="1";
                        break;
                    case 13://2
                        tempString+="2";
                        tempNum+="2";
                        break;
                    case 14://3
                        tempString+="3";
                        tempNum+="3";
                        break;
                    case 15://+
                        isPlus=true;

                        if(tempNum!=null&&!tempNum.equals("")) {
                            tempString+="+";
                            a = Float.parseFloat(tempNum);
                            tempNum = "0";
                        }else{
                            tempString+=endNum+"+";
                            tempNum = "0";
                        }
                        break;
                    case 16://00
                        tempString+="00";
                        tempNum+="00";
                        break;
                    case 17://0
                        tempString+="0";
                        tempNum+="0";
                        break;
                    case 18://.

                        if(tempNum!=null&&!tempNum.equals("")){
                            tempString+=".";
                            tempNum+=".";
                        }else{
                            tempString+="0.";
                            tempNum+="0.";
                        }
                        break;
                    case 19://=
                            isEnd=true;
                        if(!tempNum.equals("")) {
                            b = Float.parseFloat(tempNum);

                            if(isPlus){
                                endNum=a+b;
                                isPlus=false;
                            }else if(isSubtract){
                                endNum=a-b;
                                isSubtract=false;
                            }else if(isMultiply){
                                endNum=a*b;
                                isMultiply=false;
                            }else if(isDivide){
                                if(b!=0) {
                                    endNum = a / b;
                                }else{
                                    tempString="ERROR";
                                }
                                isDivide=false;
                            }else if(!tempNum.equals("")){
                                if(a!=0){//第一个数不是0
                                    tempString+="a";
                                }else {
                                    endNum = Float.parseFloat(tempNum);
                                }
                            }

                        }
//                        showTexts.add(tempString+endNum);
                        a=0;
                        b=0;

                        tempNum="0";

                        break;
                }
                if(!tempString.equals("")){
                    if(showTexts.size()>0) {
                        showTexts.remove(showTexts.size() - 1);
                    }
                    if(isEnd) {
                        if(!tempString.equals("ERROR")){
                        showTexts.add(tempString + "=" + endNum);
                        }else{
                            showTexts.add(tempString);
                        }
                        tempString="";
                        endNum=0;
                        isEnd=false;
                    }else{
                        showTexts.add(tempString);
                    }
                }
                showAdapter.notifyDataSetChanged();
                listView.setSelection(listView.getBottom());
            }
        });
    }

}
