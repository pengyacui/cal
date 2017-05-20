package com.example.calculator;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Scientific extends Fragment {


    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        View scientificView=inflater.inflate(R.layout.fragment_scientific,container,false);



        return scientificView;
    }
}
