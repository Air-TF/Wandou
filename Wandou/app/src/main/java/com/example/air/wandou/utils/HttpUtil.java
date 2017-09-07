package com.example.air.wandou.utils;

import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by Air on 2017/9/7.
 */

public class HttpUtil {
    public static void sendOkHttpRequest(String address,okhttp3.Callback callback){
        OkHttpClient client=new OkHttpClient();
        Request request =new Request.Builder().url(address).build();
        client.newCall(request).enqueue(callback);
    }
}
