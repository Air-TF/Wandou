package com.example.air.wandou.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.air.wandou.R;

/**
 * Created by Air on 2017/8/3.
 */

public class SettingActivity extends BaseActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        Button logout = (Button) findViewById(R.id.label_logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.example.air.wandou.activity.FORCE_OFFLINE");
                sendBroadcast(intent);
            }
        });
    }
}
