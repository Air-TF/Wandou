package com.example.air.wandou.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;

import com.example.air.wandou.R;

/**
 * Created by Air on 2017/8/14.
 */

public class ForgetPwdActivity extends BaseActivity {

    private Button button;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password1);

        button= (Button) findViewById(R.id.btn_next);
    }
}
