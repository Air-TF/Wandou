package com.example.air.wandou.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

import com.example.air.wandou.utils.ActivityStack;

/**
 * Created by Air on 2017/8/10.
 */

public class BaseActivity extends AppCompatActivity {
    private ForceOfflineReceiver receiver;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityStack.create().add(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter intentFilter =new IntentFilter();
        intentFilter.addAction("com.example.air.wandou.activity.FORCE_OFFLINE");
        receiver =new ForceOfflineReceiver();
        registerReceiver(receiver,intentFilter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (receiver!=null){
            unregisterReceiver(receiver);
            receiver = null;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityStack.create().remove(this);
    }
}

class ForceOfflineReceiver extends BroadcastReceiver{

    @Override
    public void onReceive(final Context context, Intent intent) {
        AlertDialog.Builder builder=new AlertDialog.Builder(context);
        builder.setTitle("警告");
        builder.setMessage("您被迫离线。请尝试再次登录。"); //对话框的信息
        builder.setCancelable(false); //false，将对话框设为不可取消，否则按一下Back键就可以关闭对话框继续使用程序了
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            //给对话框注册确定按钮，当点击确定按钮时，就调用ActivityCollector的finishAll()方法来销毁当前所有活动，并重启LoginActivity这个活动
            public void onClick(DialogInterface dialog, int which) {
                ActivityStack.create().finishAll();
                Intent intent = new Intent(context, LoginActivity.class);
                context.startActivity(intent);
            }
        });
        builder.show();
    }
}
