package com.example.day13_http;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class OkActivity extends AppCompatActivity implements View.OnClickListener{
    Button bt_http_get,bt_http_post,bt_http_sd;
    TextView textView;
    ProgressBar bar;
    int count;
    int length;
    private String get_url="http://www.qubaobei.com/ios/cf/dish_list.php?stage_id=1&limit=10&page=1";
    private String post_url="http://www.qubaobei.com/ios/cf/dish_list.php";//缺少page的请求参数 使用post提交
    private String sd_url="http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4";//视频网址

    @SuppressLint("HandlerLeak")
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            bar.setProgress(msg.arg1);
            textView.setText(((count*100)/length)+"%");
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ok);
        bt_http_get=findViewById(R.id.bt_http_get);
        bt_http_get.setOnClickListener(this);
        bt_http_post=findViewById(R.id.bt_http_post);
        bt_http_post.setOnClickListener(this);
        bt_http_sd=findViewById(R.id.bt_http_sd);
        bt_http_sd.setOnClickListener(this);
        bar=findViewById(R.id.pro2);
        textView=findViewById(R.id.jindu2);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_http_get:
                //get请求
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
    FileOutputStream outputStream;
    private void bt_http_sd() {
        //TODO 1：创建HttpClient对象:客户端
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.readTimeout(5, TimeUnit.SECONDS);//5秒
        builder.connectTimeout(5,TimeUnit.SECONDS);
        OkHttpClient client = builder.build();
        //TODO 2:创建Request对象
        Request.Builder builder1 = new Request.Builder();
        builder1.url(sd_url);
        builder1.get();//get请求
        final Request request = builder1.build();
        //TODO 3:用client发起一个request请求
        Call call = client.newCall(request);
        //TODO 4:获得response
        call.enqueue(new Callback() {
            //请求失败
            @Override
            public void onFailure(Call call, final IOException e) {
                runOnUiThread(new Runnable() {//不能直接更新UI，因为是在线程中
                    @Override
                    public void run() {
                        Toast.makeText(OkActivity.this, "请求失败"+e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
            //请求成功
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                //TODO:获得数据的总大小
                long max = response.body().contentLength();
                bar.setMax((int) max);
                InputStream inputStream = response.body().byteStream();//转成inputStream
                FileOutputStream outputStream = new FileOutputStream("/sdcard/Movies/gaoyang.mp4");
                byte[] bytes=new byte[1024];
                int len=0;
                int count=0;
                while ((len=inputStream.read(bytes))!=-1){
                    outputStream.write(bytes,0,len);
                    count+=len;
                    final int finalCount = count;
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            bar.setProgress(finalCount);//更新进度条
                        }
                    });
                }
                outputStream.flush();
                outputStream.close();
            }
        });

    }

    private void bt_http_post() {
        //TODO 1:client 客户端
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.readTimeout(5,TimeUnit.SECONDS);
        builder.connectTimeout(5,TimeUnit.SECONDS);
        OkHttpClient client = builder.build();
        //TODO 2：request 请求
        Request.Builder builder1 = new Request.Builder();
        builder1.url(post_url);

        FormBody.Builder builder2 = new FormBody.Builder();//requestBody是抽象类 使用子类FormBody
        //stage_id=1&limit=10&page=1
        builder2.add("stage_id","1");
        builder2.add("limit","10");
        builder2.add("page","1");
        FormBody formBody = builder2.build();
        builder1.post(formBody);//post提交数据
        Request request = builder1.build();
        //TODO 3:call 链接
        Call call = client.newCall(request);
        //TODO 4:response 响应
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        Toast.makeText(OkActivity.this, "请求失败", Toast.LENGTH_SHORT).show();
                    }
                });

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String string = response.body().string();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(OkActivity.this, ""+ string, Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });


    }

    private void bt_http_get() {
        //TODO 1：创建HttpClient对象:客户端
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.readTimeout(5, TimeUnit.SECONDS);//5秒
        builder.connectTimeout(5,TimeUnit.SECONDS);
        OkHttpClient client = builder.build();
        //TODO 2:创建Request对象
        Request.Builder builder1 = new Request.Builder();
        builder1.url(get_url);
        builder1.get();//get请求
        final Request request = builder1.build();
        //TODO 3:用client发起一个request请求
        Call call = client.newCall(request);
        //TODO 4:获得response
        call.enqueue(new Callback() {
            //请求失败
            @Override
            public void onFailure(Call call, final IOException e) {
                runOnUiThread(new Runnable() {//不能直接更新UI，因为是在线程中
                    @Override
                    public void run() {
                        Toast.makeText(OkActivity.this, "请求失败"+e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
            //请求成功
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                //获得响应体
                ResponseBody body = response.body();

                //直接将body装成string
                final String string = body.string();//千万不要调用toString
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(OkActivity.this, ""+string, Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });






    }
}
