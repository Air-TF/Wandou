package com.example.air.wandou.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.air.wandou.R;

/**
 * Created by Air on 2017/9/9.
 */

public class DetailsPageAcitvity extends BaseActivity {
    private ImageView iv_tocart;
    private Button bt_addcart;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailspage);

        initView();

        iv_tocart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailsPageAcitvity.this,MainActivity.class);
                intent.putExtra("tocart", 1);
                startActivity(intent);
                finish();
            }
        });
    }

    private void initView() {
        iv_tocart = (ImageView) findViewById(R.id.iv_tocart);
        bt_addcart = (Button) findViewById(R.id.bt_addcart);
    }


}
