package com.example.air.wandou.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.air.wandou.R;
import com.example.air.wandou.adapter.CommodityAdapter;
import com.example.air.wandou.bean.Commodity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Air on 2017/8/1.
 */

public class FragmentCart extends Fragment {
    TextView textView;

    private List<Commodity> commodityList=new ArrayList<>();

    public static FragmentCart newInstance(String text) {
        FragmentCart fragment_home = new FragmentCart();
        Bundle bundle = new Bundle();
        bundle.putString("text", text);
        fragment_home.setArguments(bundle);
        return fragment_home;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cart, container, false);
        //初始化购物车数据
        initCommodity();
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.cart_RecyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        CommodityAdapter commodityAdapter= new CommodityAdapter(commodityList);
        recyclerView.setAdapter(commodityAdapter);
        return view;
    }

    private void initCommodity() {
        for (int i = 0;i<50;i++){
            Commodity goods = new Commodity("哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈",R.drawable.test,"1","￥1351.32");
            commodityList.add(goods);
            Commodity com = new Commodity("呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵",R.drawable.test,"1","￥13.32");
            commodityList.add(com);
        }

    }
}