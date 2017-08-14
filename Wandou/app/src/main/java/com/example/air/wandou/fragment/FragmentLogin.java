package com.example.air.wandou.fragment;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.air.wandou.R;
import com.example.air.wandou.activity.ForgetPwdActivity;
import com.example.air.wandou.activity.LoginActivity;
import com.example.air.wandou.activity.MainActivity;
import com.example.air.wandou.utils.KeyBoardUtils;

/**
 * Created by Air on 2017/8/1.
 */

public class FragmentLogin extends Fragment {

    private EditText account, password;

    private Button btn_login;

    private TextView forgetpwd;

    LoginActivity loginActivity;
    Intent intent;
    //创建等待框
    private ProgressDialog dialog;
    //返回的数据
    private String info;
    //返回主线程更新数据
    private static Handler handler = new Handler();

    public static FragmentLogin newInstance(String text) {
        FragmentLogin fragment_home = new FragmentLogin();
        Bundle bundle = new Bundle();
        bundle.putString("text", text);
        fragment_home.setArguments(bundle);
        return fragment_home;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        loginActivity = (LoginActivity) getActivity();
        // /关联控件
        account = (EditText) view.findViewById(R.id.txt_account_name1);
        password = (EditText) view.findViewById(R.id.et_user_password);
        btn_login = (Button) view.findViewById(R.id.btn_login);
        forgetpwd = (TextView) view.findViewById(R.id.tv_forget_password);

        //设置按钮监听器
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                KeyBoardUtils.closeKeybord(v,getContext());

                // 检测网络，无法检测wifi
                if (!loginActivity.checkNetwork()) {
                    Toast toast = Toast.makeText(getActivity(), "网络未连接", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                }
                // 提示框
                dialog = new ProgressDialog(getContext());
                dialog.setTitle("提示");
                dialog.setMessage("正在登陆，请稍后...");
                dialog.setCancelable(false);
                dialog.show();
                // 创建子线程，分别进行Get和Post传输
                new Thread(new MyThread()).start();
            }
        });
        forgetpwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(loginActivity, ForgetPwdActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }


     //子线程接收数据，主线程修改数据
    public class MyThread implements Runnable {
        @Override
        public void run() {
//            info = WebService.executeHttpGet(account.getText().toString(), password.getText().toString());
            Intent intent = new Intent(getContext(), MainActivity.class);
//            intent.putExtra("mobile", account.getText().toString());
            startActivity(intent);

//            // info = WebServicePost.executeHttpPost(username.getText().toString(), password.getText().toString());
            handler.post(new Runnable() {
                @Override
                public void run() {
                    //infotv.setText(info);
                  //  dialog.dismiss();
                }
            });
        }
    }
}