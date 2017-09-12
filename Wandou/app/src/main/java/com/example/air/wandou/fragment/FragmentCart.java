package com.example.air.wandou.fragment;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
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
import com.example.air.wandou.activity.MainActivity;
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
    private TextView textView;
    private Button CheckAll, Settlement;
    private SwipeRefreshLayout refreshLayout;
    private CommodityAdapter commodityAdapter;

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

        initView(view);
        //初始化购物车数据
        initCommodity();

        final RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.cart_RecyclerView);
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        //设置分割线
        recyclerView.addItemDecoration(new RecyclerViewDivider(getContext(), LinearLayoutManager.VERTICAL));
        //如果可以确定每个item的高度是固定的，设置这个选项可以提高性能
        recyclerView.setHasFixedSize(true);
        commodityAdapter = new CommodityAdapter(commodityList);
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

        refreshLayout.setColorSchemeColors(Color.parseColor("#FFC648"));
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshLists();
            }
        });
        return view;
    }

    private void refreshLists() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                MainActivity activity = (MainActivity) getActivity();
                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        initCommodity();
                        commodityAdapter.notifyDataSetChanged();
                        textView.setText(fromHtml(commodityAdapter.isChose()), TextView.BufferType.SPANNABLE);
                        refreshLayout.setRefreshing(false);
                    }
                });
            }
        }).start();
    }

    private void initView(View view) {
        CheckAll = (Button) view.findViewById(R.id.btn_checkall);
        textView = (TextView) view.findViewById(R.id.cart_total);
        Settlement = (Button) view.findViewById(R.id.btn_settlement);
        refreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipe_refresh);
    }

    private void initCommodity() {
        commodityList.clear();
        Commodity goods = new Commodity(true, "哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈", R.drawable.test, 1, 13535);
        commodityList.add(goods);
        Commodity com = new Commodity(false, "呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵", R.drawable.tyre, 1, 54635);
        commodityList.add(com);
    }


    public boolean addCommodity(Commodity commodity) {
        if (commodityList.add(commodity)) {
            return true;
        } else {
            return false;
        }
    }

    public interface addCommodity {
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