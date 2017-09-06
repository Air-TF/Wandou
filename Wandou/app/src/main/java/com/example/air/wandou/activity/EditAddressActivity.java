package com.example.air.wandou.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.example.air.wandou.R;

/**
 * Created by Air on 2017/9/6.
 */

public class EditAddressActivity extends BaseActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_address);

        findViewById(R.id.ly_edit_address).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }
}
