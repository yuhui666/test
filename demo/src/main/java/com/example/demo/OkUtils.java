package com.example.demo;

import android.util.Log;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 原则：代码复用强，少写多余的代码+节省系统的资源(只有一个Client对象)
 *
 *
 * */
//单例的类:构造私有化 自行实例化 提供公开的方法
public class OkUtils {
    OkHttpClient okHttpClient;
    private OkUtils(){//由于构造方法直走一次，client只创建了一次
        Log.d("ytx", "创建一次");
        //创建Client对象
        okHttpClient= new OkHttpClient
                .Builder()
                .connectTimeout(5, TimeUnit.SECONDS)
                .readTimeout(5,TimeUnit.SECONDS)
                .build();
    }
    private static OkUtils okUtils=new OkUtils();//饿汉 没有现成安全问题

    public static OkUtils newInstance(){
        return okUtils;
    }

    //TODO 1:方法 get请求

    /***
     *
     * @param url  网址
     * @param myCallBack  结果回调给Activity  成功或者失败
     */
    public void doGet(String url, final MyCallBack myCallBack){
        //请求对象
        final Request request = new Request.Builder()
                .get()
                .url(url)
                .build();
        //发起连接
        Call call = okHttpClient.newCall(request);
        //得到结果
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                myCallBack.error(e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                myCallBack.success(response.body().string());
            }
        });
    }
    //TODO 2:方法 post请求

    /***
     *
     * @param url  网址
     * @param myCallBack  结果回调给Activity  成功或者失败
     * @param keyname 请求体名称数组
     *  @param value 请求体值数组
     */
    public void doPost(String url, final MyCallBack myCallBack,String[] keyname,String[] value){
        //请求体对象
        FormBody.Builder builder = new FormBody.Builder();
        for(int i=0;i<keyname.length;i++){
            builder.add(keyname[i],value[i]);
        }
        FormBody formBody = builder.build();

        //请求对象
        final Request request = new Request.Builder()
                .post(formBody)//放置请求体
                .url(url)
                .build();
        //发起连接
        Call call = okHttpClient.newCall(request);
        //得到结果
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                myCallBack.error(e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                myCallBack.success(response.body().string());
            }
        });
    }
    //TODO 3:下载各种文件

    /***
     *
     * @param url  请求网址
     * @param filepath  SD卡路径
     * @param myCallBack  回调接口
     */
    public void download(String url,String filepath,MyCallBack myCallBack){

    }


    //TODO 4：文件的上传



    //回调接口 ：成功 失败
    interface MyCallBack{
        public void success(String str);
        public void error(String mesage);
    }










}
