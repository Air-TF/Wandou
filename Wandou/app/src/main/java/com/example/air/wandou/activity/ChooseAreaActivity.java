package com.example.air.wandou.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.air.wandou.R;

/**
 * Created by Air on 2017/9/7.
 */

public class ChooseAreaActivity extends BaseActivity{
    String string;

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_area);
    }
}
