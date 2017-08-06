package com.example.air.wandou.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.air.wandou.R;
import com.example.air.wandou.fragment.FragmentCommon;
import com.ycl.tabview.library.TabView;
import com.ycl.tabview.library.TabViewChild;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class MainActivity extends FragmentActivity {
    TabView tabView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabView = (TabView) findViewById(R.id.tabView);
        //添加导航页数据
        List<TabViewChild> tabViewChildList = new ArrayList<>();
        TabViewChild tabViewChild01 = new TabViewChild(R.drawable.tab01_sel, R.drawable.tab01_unsel, "首页", FragmentCommon.newInstance("首页"));
        TabViewChild tabViewChild02 = new TabViewChild(R.drawable.tab02_sel, R.drawable.tab02_unsel, "商城", FragmentCommon.newInstance("商城"));
        TabViewChild tabViewChild03 = new TabViewChild(R.drawable.tab03_sel, R.drawable.tab03_unsel, "购物车", FragmentCommon.newInstance("购物车"));
        TabViewChild tabViewChild04 = new TabViewChild(R.drawable.tab04_sel, R.drawable.tab04_unsel, "我的", FragmentCommon.newInstance("我的"));
        tabViewChildList.add(tabViewChild01);
        tabViewChildList.add(tabViewChild02);
        tabViewChildList.add(tabViewChild03);
        tabViewChildList.add(tabViewChild04);
        //设置首页为默认启动页
        tabView.setTabViewDefaultPosition(0);

        //设置选项相应事件
        tabView.setTabViewChild(tabViewChildList, getSupportFragmentManager());
        tabView.setOnTabChildClickListener(new TabView.OnTabChildClickListener() {
            @Override
            public void onTabChildClick(int position, ImageView currentImageIcon, TextView currentTextView) {
            }
        });
    }
}
