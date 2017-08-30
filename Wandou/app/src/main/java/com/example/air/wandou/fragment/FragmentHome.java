package com.example.air.wandou.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.example.air.wandou.R;
import com.example.air.wandou.widget.Banner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Air on 2017/8/1.
 */

public class FragmentHome extends Fragment {
    View view;
    Banner BannerLocal;

    public static FragmentHome newInstance(String text) {
        FragmentHome fragment_home = new FragmentHome();
        Bundle bundle = new Bundle();
        bundle.putString("text", text);
        fragment_home.setArguments(bundle);
        return fragment_home;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, container, false);
        EditText seachEdit = (EditText) view.findViewById(R.id.toolbar_searchview);

        initLocalBanner();

        return view;
    }


    /**
     * 加载本地图片
     */
    private void initLocalBanner() {
        BannerLocal = (Banner) view.findViewById(R.id.home_banner);

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