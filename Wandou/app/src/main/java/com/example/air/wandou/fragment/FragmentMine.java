package com.example.air.wandou.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.air.wandou.R;
import com.example.air.wandou.activity.LoginActivity;
import com.example.air.wandou.activity.SettingActivity;

/**
 * Created by Air on 2017/8/1.
 */

public class FragmentMine extends Fragment {

    public static FragmentMine newInstance(String text) {
        FragmentMine fragment_home = new FragmentMine();
        Bundle bundle = new Bundle();
        bundle.putString("text", text);
        fragment_home.setArguments(bundle);
        return fragment_home;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mine, container, false);

        //获取控件
        view.findViewById(R.id.layout_login_before).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), LoginActivity.class));
            }
        });
        view.findViewById(R.id.setings).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), SettingActivity.class));
            }
        });
        view.findViewById(R.id.bt_mine_business).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new FragmentBus());
            }
        });
        TextView textView = (TextView) view.findViewById(R.id.txt_account_phone);
        return view;
    }


    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.mine_business, fragment);
        transaction.commit();
    }
}