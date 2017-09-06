package com.example.air.wandou.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.air.wandou.R;
import com.example.air.wandou.adapter.MallAdapter;
import com.example.air.wandou.bean.Commodity;
import com.example.air.wandou.widget.Banner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Air on 2017/8/1.
 */

public class FragmentMallStore extends Fragment {
    private MallAdapter mallAdapter;
    private RecyclerView recyclerView1;
    private RecyclerView recyclerView2;
    List<Commodity> commodityList = new ArrayList<>();
    Banner BannerLocal;

    public static FragmentMallStore newInstance(String text) {
        FragmentMallStore fragment_home = new FragmentMallStore();
        Bundle bundle = new Bundle();
        bundle.putString("text", text);
        fragment_home.setArguments(bundle);
        return fragment_home;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mall_store, container, false);
        BannerLocal = (Banner) view.findViewById(R.id.mall_banner2);


        recyclerView1 = (RecyclerView) view.findViewById(R.id.mall_recycler1);
        recyclerView2 = (RecyclerView) view.findViewById(R.id.mall_recycler2);


        recyclerView1.setNestedScrollingEnabled(false);
        recyclerView2.setNestedScrollingEnabled(false);
        mallAdapter = new MallAdapter(commodityList);
        recyclerView1.setAdapter(mallAdapter);
        recyclerView1.setLayoutManager(new GridLayoutManager(getContext(), 2));
        //设置分割线
//        recyclerView1.addItemDecoration(new RecyclerViewDivider(getContext(), LinearLayoutManager.VERTICAL));

        recyclerView2.setAdapter(mallAdapter);
        recyclerView2.setLayoutManager(new GridLayoutManager(getContext(), 2));
        //设置分割线
//        recyclerView2.addItemDecoration(new RecyclerViewDivider(getContext(), LinearLayoutManager.VERTICAL));

        //初始化广告
        initLocalBanner();
        //初始化布局
        initCommodity();
        return view;
    }

    private void initCommodity() {
        for (int i = 0; i < 2; i++) {
            Commodity goods = new Commodity(true, "全动力多元醇酯全合成机油", R.drawable.test, 1, 13535);
            commodityList.add(goods);
            Commodity com = new Commodity(false, "全动力多元醇酯全合成机油", R.drawable.tyre, 1, 54635);
            commodityList.add(com);
        }
    }

    /**
     * 加载本地图片
     */
    private void initLocalBanner() {

        List<Integer> images = new ArrayList<>();
        images.add(R.mipmap.banner1);
        images.add(R.mipmap.banner2);
        images.add(R.mipmap.banner3);
        images.add(R.mipmap.banner4);
        BannerLocal.setImages(images);

        BannerLocal.setOnItemClickListener(new Banner.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(getContext(), "点击了第" + position + "张图片", Toast.LENGTH_SHORT).show();
            }
        });
    }
}