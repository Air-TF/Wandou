package com.example.air.wandou.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.air.wandou.R;

/**
 * 作者：yaochangliang on 2016/8/14 08:18
 * 邮箱：yaochangliang159@sina.com
 */
public class FragmentCommon extends Fragment {
    TextView textView;

    public static FragmentCommon newInstance(String text){
        FragmentCommon fragmentCommon=new FragmentCommon();
        Bundle bundle=new Bundle();
        bundle.putString("text",text);
        fragmentCommon.setArguments(bundle);
        return fragmentCommon;
    }
    @Nullable @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_home,container,false);
        switch (getArguments().getString("text")){
            case "首页":
                view=inflater.inflate(R.layout.fragment_home,container,false);
                break;
            case "商城":
                view=inflater.inflate(R.layout.fragment_mall,container,false);
                break;
            case "购物车":
                view=inflater.inflate(R.layout.fragment_cart,container,false);
                break;
            case "我的":
                view=inflater.inflate(R.layout.fragment_mine,container,false);
                break;
        }
//        textView= (TextView) view.findViewById(R.id.textView);
//        textView.setText(getArguments().getString("text"));
        return view;
    }
}
