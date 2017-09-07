package com.example.air.wandou.http;

import android.os.Handler;
import android.os.Looper;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


public class OkHttpHelper {

    public static final String TAG="OkHttpHelper";

    private  static  OkHttpHelper mInstance;
    private OkHttpClient mHttpClient;
    private Gson mGson;
    private Handler mHandler;

    static {
        mInstance = new OkHttpHelper();
    }

    private OkHttpHelper(){

        okhttp3.OkHttpClient.Builder ClientBuilder=new okhttp3.OkHttpClient.Builder();
        ClientBuilder.readTimeout(30, TimeUnit.SECONDS);//读取超时
        ClientBuilder.connectTimeout(10, TimeUnit.SECONDS);//连接超时
        ClientBuilder.writeTimeout(60, TimeUnit.SECONDS);//写入超时
        mHttpClient=ClientBuilder.build();


        mGson = new Gson();

        mHandler = new Handler(Looper.getMainLooper());

    };

    public static  OkHttpHelper getInstance(){
        return  mInstance;
    }

    public void get(String url,BaseCallback callback){

        Request request = buildGetRequest(url);

        request(request,callback);

    }


    public void post(String url,Map<String,String> param, BaseCallback callback){

        Request request = buildPostRequest(url,param);
        request(request,callback);
    }

    public  void request(final Request request,final  BaseCallback callback){

        callback.onBeforeRequest(request);

        mHttpClient.newCall(request).enqueue(new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {
                callback.onFailure(request,e);

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                callback.onResponse(response);

                if(response.isSuccessful()) {

                    String resultStr = response.body().string();

                    if (callback.mType == String.class){
                        callbackSuccess(callback,response,resultStr);
                    }
                    else {
                        try {

                            Object obj = mGson.fromJson(resultStr, callback.mType);
                            callbackSuccess(callback,response,obj);
                        }
                        catch (com.google.gson.JsonParseException e){ // Json解析的错误
                            callback.onError(response,response.code(),e);
                        }
                    }
                }
                else {
                    callbackError(callback,response,null);
                }
            }
        });


    }

    private void callbackSuccess(final  BaseCallback callback , final Response response, final Object obj ){

        mHandler.post(new Runnable() {
            @Override
            public void run() {
                callback.onSuccess(response, obj);
            }
        });
    }

    private void callbackError(final  BaseCallback callback , final Response response, final Exception e ){

        mHandler.post(new Runnable() {
            @Override
            public void run() {
                callback.onError(response,response.code(),e);
            }
        });
    }

    private  Request buildPostRequest(String url,Map<String,String> params){

        return  buildRequest(url,HttpMethodType.POST,params);
    }

    private  Request buildGetRequest(String url){

        return  buildRequest(url,HttpMethodType.GET,null);
    }

    private  Request buildRequest(String url,HttpMethodType methodType,Map<String,String> params){


        Request.Builder builder = new Request.Builder()
                .url(url);

        if (methodType == HttpMethodType.POST){
            RequestBody body = builderFormData(params);
            builder.post(body);
        }
        else if(methodType == HttpMethodType.GET){
            builder.get();
        }
        return builder.build();
    }

    private RequestBody builderFormData(Map<String,String> params){


        FormBody.Builder builder = new FormBody.Builder();

        if(params !=null){

            for (Map.Entry<String,String> entry :params.entrySet() ){

                builder.add(entry.getKey(),entry.getValue());
            }
        }

        return  builder.build();
    }

    enum  HttpMethodType{
        GET,
        POST,

    }



}

