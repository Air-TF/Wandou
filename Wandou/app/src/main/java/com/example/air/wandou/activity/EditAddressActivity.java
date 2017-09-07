package com.example.air.wandou.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.example.air.wandou.R;

/**
 * Created by Air on 2017/9/6.
 */

public class EditAddressActivity extends BaseActivity {
    EditText et_name;
    EditText et_phone;
    TextView tv_addr;
    EditText et_addr;
    Button bt_save;
    CheckBox cb_check;

    @Override

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_address);
        initView();


        tv_addr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EditAddressActivity.this, ChooseAreaActivity.class);
                startActivityForResult(intent,1);
            }
        });
    }

    void initView() {
        et_name = (EditText) findViewById(R.id.edit_name);
        et_phone = (EditText) findViewById(R.id.edit_phonenumber);
        tv_addr = (TextView) findViewById(R.id.edit_address1);
        et_addr = (EditText) findViewById(R.id.edit_address2);
        bt_save = (Button) findViewById(R.id.edit_save);
        cb_check = (CheckBox) findViewById(R.id.edit_check);
    }

    private static void actionStart(Context context,String data){
        Intent intent =new Intent(context,EditAddressActivity.class);
        intent.putExtra("addr1",data);
        context.startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case 1:
                if(resultCode==RESULT_OK){
                    tv_addr.setText(data.getStringExtra("addr"));
                }
        }
    }
}
