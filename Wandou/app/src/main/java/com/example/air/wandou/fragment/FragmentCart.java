package com.example.air.wandou.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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
    Button CheckAll;
    RecyclerView recyclerView;
    CommodityAdapter commodityAdapter;

    private List<Commodity> commodityList = new ArrayList<>();

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
        final View view = inflater.inflate(R.layout.fragment_cart, container, false);
        CheckAll = (Button) view.findViewById(R.id.btn_checkall);
        textView = (TextView) view.findViewById(R.id.cart_total);

        //初始化购物车数据
        initCommodity();
        recyclerView = (RecyclerView) view.findViewById(R.id.cart_RecyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        commodityAdapter = new CommodityAdapter(commodityList);
        recyclerView.setAdapter(commodityAdapter);

        CheckAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                commodityAdapter.CheckAll();
                Refresh();
            }
        });


        return view;
    }

    private void initCommodity() {
        for (int i = 0; i < 5; i++) {
            Commodity goods = new Commodity(true, "哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈", R.drawable.test, 1, 13535);
            commodityList.add(goods);
            Commodity com = new Commodity(false, "呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵", R.drawable.tyre, 1, 54635);
            commodityList.add(com);
        }
    } 

    public void Refresh() {
        recyclerView.setAdapter(commodityAdapter);
        textView.setText(Html.fromHtml(commodityAdapter.isChose()), TextView.BufferType.SPANNABLE);
    }
}