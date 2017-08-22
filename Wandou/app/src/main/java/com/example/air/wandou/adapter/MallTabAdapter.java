package com.example.air.wandou.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * Created by Air on 2017/8/22.
 */

public class MallTabAdapter extends FragmentStatePagerAdapter {

    private List<Fragment> list_fragment;         //fragment 列表
    private List<String> list_Title;         //tab名的列表

    public MallTabAdapter(FragmentManager fm,List<Fragment> list_fragment,List<String> list_Title) {
        super(fm);
        this.list_fragment=list_fragment;
        this.list_Title=list_Title;
    }


    @Override
    public Fragment getItem(int position) {
        return list_fragment.get(position);
    }

    @Override
    public int getCount() {
        return list_Title.size();
    }


    //显示tab
    public CharSequence getPageTitle(int position){
        return list_Title.get(position);
    }

}
