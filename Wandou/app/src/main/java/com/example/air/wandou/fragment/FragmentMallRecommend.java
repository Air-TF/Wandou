package com.example.air.wandou.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.air.wandou.R;
import com.example.air.wandou.widget.Banner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Air on 2017/8/1.
 */

public class FragmentMallRecommend extends Fragment {
    Banner mBannerLocal;

    public static FragmentMallRecommend newInstance(String text) {
        FragmentMallRecommend fragment_home = new FragmentMallRecommend();
        Bundle bundle = new Bundle();
        bundle.putString("text", text);
        fragment_home.setArguments(bundle);
        return fragment_home;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mall_recommend, container, false);
        mBannerLocal = (Banner) view.findViewById(R.id.mall_banner);
        initLocalBanner();

        return view;
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
        mBannerLocal.setImages(images);

        mBannerLocal.setOnItemClickListener(new Banner.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(getContext(), "点击了第" + position + "张图片", Toast.LENGTH_SHORT).show();
            }
        });
    }

//
//    /**
//     * 加载网页图片
//     */
//    private void initNetBanner() {
//        mBannerNet = (FlyBanner) findViewById(R.id.banner);
//
//        List<String> imgesUrl = new ArrayList<>();
//        for (int i = 0; i < mImagesUrl.length; i++) {
//            imgesUrl.add(mImagesUrl[i]);
//        }
//        mBannerNet.setImagesUrl(imgesUrl);
//
//        mBannerNet.setOnItemClickListener(new FlyBanner.OnItemClickListener() {
//            @Override
//            public void onItemClick(int position) {
//                toast("点击了第" + position + "张图片");
//            }
//        });
//    }
}