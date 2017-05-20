package com.example.com.example.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.calculator.Scientific;
import com.example.calculator.Standard;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private String[] mTitles=new String[]{"标准","科学"};

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment ft=null;
        switch (position){
            case 0:
                ft=new Standard();
                break;
            default:
                ft=new Scientific();
                break;
        }
        return ft;
    }

    @Override
    public int getCount() {
        return mTitles.length;
    }

    //viewpager与tablayout绑定后，这里获取到的mTitle就是tab的文字
    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }
}
