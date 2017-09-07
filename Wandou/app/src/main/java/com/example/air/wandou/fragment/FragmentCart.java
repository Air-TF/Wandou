package com.example.air.wandou.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.air.wandou.R;
import com.example.air.wandou.activity.SettltmentActivity;
import com.example.air.wandou.adapter.CommodityAdapter;
import com.example.air.wandou.bean.Commodity;
import com.example.air.wandou.widget.RecyclerViewDivider;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Air on 2017/8/1.
 */

public class FragmentCart extends Fragment {
    TextView textView;
    Button CheckAll, Settlement;

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
        Settlement = (Button) view.findViewById(R.id.btn_settlement);
        //初始化购物车数据
        initCommodity();
        final RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.cart_RecyclerView);
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        //设置分割线
        recyclerView.addItemDecoration(new RecyclerViewDivider(getContext(), LinearLayoutManager.VERTICAL));
        //如果可以确定每个item的高度是固定的，设置这个选项可以提高性能
        recyclerView.setHasFixedSize(true);
        final CommodityAdapter commodityAdapter = new CommodityAdapter(commodityList);
        recyclerView.setAdapter(commodityAdapter);
        textView.setText(fromHtml(commodityAdapter.isChose()), TextView.BufferType.SPANNABLE);


        CheckAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                commodityAdapter.CheckAll();
                recyclerView.setAdapter(commodityAdapter);
                textView.setText(fromHtml(commodityAdapter.isChose()), TextView.BufferType.SPANNABLE);
            }
        });

        commodityAdapter.setOnClickListener(new CommodityAdapter.OnClickListener() {
            @Override
            public void setOnClick(View view, int position) {
                textView.setText(fromHtml(commodityAdapter.isChose()), TextView.BufferType.SPANNABLE);
            }
        });

        Settlement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), SettltmentActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }

    private void initCommodity() {
        for (int i = 0; i < 30; i++) {
            Commodity goods = new Commodity(true, "哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈", R.drawable.test, 1, 13535);
            commodityList.add(goods);
            Commodity com = new Commodity(false, "呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵", R.drawable.tyre, 1, 54635);
            commodityList.add(com);
        }
    }

    public boolean addCommodity(Commodity commodity) {
        if (commodityList.add(commodity)) {
            return true;
        } else {
            return false;
        }

    }

    public interface addCommodity{
        boolean addCommodity(Commodity commodity);
    }


    public static Spanned fromHtml(String html) {
        Spanned result;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            result = Html.fromHtml(html, Html.FROM_HTML_MODE_LEGACY);
        } else {
            result = Html.fromHtml(html);
        }
        return result;
    }
}