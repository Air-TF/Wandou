package com.example.air.wandou.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.air.wandou.R;

/**
 * Created by Air on 2017/9/9.
 */

public class DetailsPageAcitvity extends BaseActivity {
    private ImageView iv_tocart;
    private Button bt_addcart;
    private TextView tv_infor;
    private Intent intent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailspage);

        initView();
        intent = new Intent(DetailsPageAcitvity.this, MainActivity.class);
        intent.putExtra("tocart", 2);

        Intent mIntent = getIntent();

        tv_infor.setText("" + mIntent.getIntExtra("position", -1));

        iv_tocart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
                finish();
            }
        });

        bt_addcart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(intent);
            }
        });
    }

    private void initView() {
        iv_tocart = (ImageView) findViewById(R.id.iv_tocart);
        bt_addcart = (Button) findViewById(R.id.bt_addcart);
        tv_infor = (TextView) findViewById(R.id.information);
    }


}
