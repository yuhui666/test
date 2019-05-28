package com.example.day13_http;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * 安卓中网络请求方式
 * 一.HttpUrlConnection:最基础的，重点
 * (1)get请求
 * (2)post请求
 * (3)get请求数据下载到SD卡中：图片,视频，音频，带进度条的下载
 * 二.HttpClient:已经过时的，安卓SDK26以后该类已经被谷歌删掉了
 * 三.Xutils:第三方框架，功能比较全(数据库，图片，网络。。。。)，发明这个东西的人想象很丰满，现实很难维护。
 * 四.OkHttp:第三方框架(重点，老app使用)
 * 这是一个开源项目,是安卓端最火热的轻量级框架,由移动支付Square公司贡献(该公司还贡献了Picasso和LeakCanary) 。
 * 用于替代HttpUrlConnection和Apache HttpClient(android API23 里已移除HttpClient)
 * (1)导入依赖implementation ‘com.squareup.okhttp3:okhttp:3.12.1’
 * (2)创建Okhttpclient对象
 * (3)创建Request对象
 * (4)通过client.newCall(request);得到call对象
 * (5）调用enqueue方法得到Response对象
 * 五.Volley：第三方框架(重点，老app使用)
 * (0)导入依赖 implementation 'eu.the4thfloor.volley:com.android.volley:2015.05.28'
 * (1)创建RequestQueue请求队列
 * (2)创建Request对象：StringRequest和ImageRequest对象
 * (3)add()添加到请求队列中
 * 六。Retrofit(下个月要学习，挺火的)
 * **/
public class HttpActivity extends AppCompatActivity implements View.OnClickListener{
    Button bt_http_get,bt_http_post,bt_http_sd;

    private String get_url="http://atp.fulishe.com/ClientApi/category.php?api_version=1.0&act=search_category_goods_list&c_id=35&order_price=0&page_num=20&page=1&debug=true&client_id=null";
//http://atp.fulishe.com/ClientApi/category.php?api_version=1.0&act=search_category_goods_list&c_id=35&order_price=0&page_num=20&page=1&debug=true&client_id=nullhttp://atp.fulishe.com/ClientApi/category.php?api_version=1.0&act=search_category_goods_list&c_id=35&order_price=0&page_num=20&page=1&debug=true&client_id=null
    private String post_url="http://atp.fulishe.com/ClientApi/category.php?api_version=1.0&act=search_category_goods_list&c_id=35&order_price=0&page_num=20";//缺少page的请求参数 使用post提交
    private String sd_url="http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4";//视频网址
    private ProgressBar bar;
    private TextView textView;
    int progress;
    int contentLength;
    @SuppressLint("HandlerLeak")
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            bar.setProgress(msg.arg1);
            textView.setText((int)((progress*100)/contentLength)+"%");
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_http);
        bt_http_get=findViewById(R.id.bt_http_get);
        bt_http_get.setOnClickListener(this);
        bt_http_post=findViewById(R.id.bt_http_post);
        bt_http_post.setOnClickListener(this);
        bt_http_sd=findViewById(R.id.bt_http_sd);
        bt_http_sd.setOnClickListener(this);
        bar=findViewById(R.id.pro);
        textView=findViewById(R.id.jindu);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_http_get:
                //使用URLconnection做get请求
                bt_http_get();
                break;
            case R.id.bt_http_post:
                bt_http_post();
                break;
            case R.id.bt_http_sd:
                bt_http_sd();
                break;
        }

    }

    private void bt_http_sd() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL(sd_url);
                    HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                    urlConnection.setConnectTimeout(5*1000);
                    urlConnection.setReadTimeout(5*1000);
                    contentLength = urlConnection.getContentLength();
                    bar.setMax(contentLength);
                    Log.d("sssss","长度："+contentLength);
                    if(urlConnection.getResponseCode()==200){
                        progress=0;
                        InputStream inputStream = urlConnection.getInputStream();
                        //SD卡输出流
                        FileOutputStream fileOutputStream = new FileOutputStream("/sdcard/Movies/aa.mp4");
                        byte[] bytes=new byte[1024];
                        int len=0;
                        while ((len=inputStream.read(bytes))!=-1){
                            //边从网络读，边往SD卡中
                            fileOutputStream.write(bytes,0,len);
                            Message message=new Message();
                            progress+=len;
                            message.arg1=progress;
                            handler.sendMessage(message);
                            Log.d("chang:","changdu"+len);
                        }
                    }
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private void bt_http_post() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                StringBuffer stringBuffer=new StringBuffer();
                try {
                    URL url = new URL(post_url);
                    HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                    urlConnection.setConnectTimeout(5*1000);
                    urlConnection.setReadTimeout(5*1000);
                    //TODO 1：设置请求方式，默认是get
                    urlConnection.setRequestMethod("POST");//大写的POST
                    //TODO 2：设置允许输出
                    urlConnection.setDoOutput(true);//允许向服务器提交数据、
                    //TODO 3：获得输出流写数据 "&page=1"
                    urlConnection.getOutputStream().write("&page=1&debug=true&client_id=null".getBytes());//请求参数放到请求体
                    if(urlConnection.getResponseCode()==200){
                        InputStream inputStream = urlConnection.getInputStream();
                        byte[] bytes=new byte[1024];
                        int len=0;
                        while ((len=inputStream.read(bytes))!=-1){
                            stringBuffer.append(new String(bytes,0,len));
                        }
                        Log.d("ytx", "run: "+stringBuffer.toString());
                    }
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }).start();
    }

    private void bt_http_get() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                StringBuffer stringBuffer=new StringBuffer();
                try {
                    URL url = new URL(get_url);
                    HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                    urlConnection.setConnectTimeout(5*1000);
                    urlConnection.setReadTimeout(5*1000);
                    if(urlConnection.getResponseCode()==200){
                        InputStream inputStream = urlConnection.getInputStream();
                        byte[] bytes=new byte[1024];
                        int len=0;
                        while ((len=inputStream.read(bytes))!=-1){
                            stringBuffer.append(new String(bytes,0,len));
                        }
                        Log.d("ytx",stringBuffer.toString());
                    }
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }).start();
    }
}
