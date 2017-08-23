package com.example.air.wandou.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.air.wandou.R;
import com.example.air.wandou.adapter.MallTabAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Air on 2017/8/1.
 */

public class FragmentMall extends Fragment {


    private TabLayout tab_title;                            //定义TabLayout
    private ViewPager vp_pager;                             //定义viewPager
    private FragmentStatePagerAdapter fAdapter;                               //定义adapter

    private List<Fragment> list_fragment;                                //定义要装fragment的列表
    private List<String> list_title;                                     //tab名称列表


    public static FragmentMall newInstance(String text) {
        FragmentMall fragment_home = new FragmentMall();
        Bundle bundle = new Bundle();
        bundle.putString("text", text);
        fragment_home.setArguments(bundle);
        return fragment_home;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mall, container, false);

        initControls(view);
        return view;
    }

    /**
     * 初始化各控件
     *
     * @param view
     */
    private void initControls(View view) {

        tab_title = (TabLayout) view.findViewById(R.id.mall_tablayout);
        vp_pager = (ViewPager) view.findViewById(R.id.mall_viewpage);

        //将fragment装进列表中
        list_fragment = new ArrayList<>();
        list_fragment.add(FragmentMallRecommend.newInstance(""));
        list_fragment.add(FragmentMallStore.newInstance(""));
        list_fragment.add(FragmentMallService.newInstance(""));

        //将名称加载tab名字列表，正常情况下，我们应该在values/arrays.xml中进行定义然后调用
        list_title = new ArrayList<>();
        list_title.add("推荐");
        list_title.add("商城");
        list_title.add("车服");

        fAdapter = new MallTabAdapter(getActivity().getSupportFragmentManager(), list_fragment, list_title);

        //viewpager加载adapter
        vp_pager.setAdapter(fAdapter);
        //TabLayout加载viewpager
        tab_title.setupWithViewPager(vp_pager);
    }


}


