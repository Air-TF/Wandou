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
 * Created by Air on 2017/8/1.
 */

public class FragmentMine extends Fragment{
    TextView textView;

    public static FragmentMine newInstance(String text){
        FragmentMine fragment_home=new FragmentMine();
        Bundle bundle=new Bundle();
        bundle.putString("text",text);
        fragment_home.setArguments(bundle);
        return fragment_home;
    }
    @Nullable @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_home,container,false);
        return view;
    }
}