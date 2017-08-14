package com.example.air.wandou.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.air.wandou.R;
import com.example.air.wandou.fragment.FragmentLogin;
import com.example.air.wandou.fragment.FragmentRegister;
import com.ycl.tabview.library.TabView;
import com.ycl.tabview.library.TabViewChild;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Air on 2017/8/3.
 */

public class LoginActivity extends BaseActivity {

//    //用户名和密码
//    private EditText usernameEdit, passwordEdit;
//    //登陆按钮
//    private Button loginbtn;
    //创建等待框
    private ProgressDialog dialog;
    //返回的数据
    private String info;
    //返回主线程更新数据
    private static Handler handler = new Handler();

    TabView tabView;

    //空白区域
    View blank;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        tabView = (TabView) findViewById(R.id.tologin);
        List<TabViewChild> tabViewChildList = new ArrayList<>();
        TabViewChild tabViewChild01 = new TabViewChild(0, 0, "登录", FragmentLogin.newInstance("登录"));
        TabViewChild tabViewChild02 = new TabViewChild(0, 0, "注册", FragmentRegister.newInstance("注册"));
        tabViewChildList.add(tabViewChild01);
        tabViewChildList.add(tabViewChild02);
        //设置首页为默认启动页
        tabView.setTabViewDefaultPosition(0);
        //设置选项相应事件
        tabView.setTabViewChild(tabViewChildList, getSupportFragmentManager());
        tabView.setOnTabChildClickListener(new TabView.OnTabChildClickListener() {
            @Override
            public void onTabChildClick(int position, ImageView currentImageIcon, TextView currentTextView) {
//                Fragment fragmentLogin=getFragmentManager().findFragmentById(R.id.fragment_login);
            }
        });

        //获取控件
//        usernameEdit = (EditText) findViewById(R.id.et_user_account);
//        passwordEdit = (EditText) findViewById(R.id.et_user_password);
        blank = findViewById(R.id.blank);

//        loginbtn = (Button) findViewById(R.id.btn_login);

        tabView.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) blank.getLayoutParams();
                    params.height = 50;//设置当前控件布局的高度
                    blank.setLayoutParams(params);//将设置好的布局参数应用到控件中
                }
            }
        });

        //设置按钮监听器
//        loginbtn.setOnClickListener(this);
    }
//
//    @Override
//    public void onClick(View v) {
//        switch (v.getId()) {
//            case R.id.btn_login:
//                // 检测网络，无法检测wifi
//                if (!checkNetwork()) {
//                    Toast toast = Toast.makeText(LoginActivity.this, "网络未连接", Toast.LENGTH_SHORT);
//                    toast.setGravity(Gravity.CENTER, 0, 0);
//                    toast.show();
//                    break;
//                }
//                // 提示框
//                dialog = new ProgressDialog(this);
//                dialog.setTitle("提示");
//                dialog.setMessage("正在登陆，请稍后...");
//                dialog.setCancelable(false);
//                dialog.show();
//                // 创建子线程，分别进行Get和Post传输
//                new Thread(new MyThread()).start();
//
//                break;
//        }
//    }
//
//
//    // 子线程接收数据，主线程修改数据
//    public class MyThread implements Runnable {
//        @Override
//        public void run() {
//            info = WebService.executeHttpGet(usernameEdit.getText().toString(), passwordEdit.getText().toString());
//            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
//            intent.putExtra("mobile", usernameEdit.getText().toString());
//            startActivity(intent);
//
////            // info = WebServicePost.executeHttpPost(username.getText().toString(), password.getText().toString());
////            handler.post(new Runnable() {
////                @Override
////                public void run() {
////                    infotv.setText(info);
////                    dialog.dismiss();
////                }
////            });
//        }
//    }
//
    // 检测网络
    public boolean checkNetwork() {
        ConnectivityManager connManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connManager.getActiveNetworkInfo() != null) {
            return connManager.getActiveNetworkInfo().isAvailable();
        }
        return false;
    }
}
