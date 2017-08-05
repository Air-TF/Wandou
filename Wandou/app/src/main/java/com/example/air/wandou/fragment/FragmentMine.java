package com.example.air.wandou.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.example.air.wandou.activity.MainActivity;

/**
 * Created by Air on 2017/8/2.
 */

public class FragmentMine extends Fragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MainActivity activity= (MainActivity) getActivity();

    }
}
