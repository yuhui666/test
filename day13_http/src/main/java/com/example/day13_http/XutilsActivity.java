package com.example.day13_http;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.image.ImageOptions;
import org.xutils.x;

public class XutilsActivity extends AppCompatActivity implements View.OnClickListener {
    Button bt_http_get,bt_http_post,bt_http_sd;
    ImageView imageView;
    private String get_url="http://www.qubaobei.com/ios/cf/dish_list.php?stage_id=1&limit=10&page=1";
    private String post_url="http://www.qubaobei.com/ios/cf/dish_list.php";//缺少page的请求参数 使用post提交
    private String pic_url="https://images0.cnblogs.com/blog/651487/201501/281616176915467.jpg";//视频网址

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xutils);

        bt_http_get=findViewById(R.id.bt_http_get);
        bt_http_get.setOnClickListener(this);
        bt_http_post=findViewById(R.id.bt_http_post);
        bt_http_post.setOnClickListener(this);
        bt_http_sd=findViewById(R.id.bt_http_sd);
        bt_http_sd.setOnClickListener(this);
        imageView=findViewById(R.id.image);
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
        x.image().bind(imageView,pic_url);
    }

    private void bt_http_post() {
        RequestParams requestParams = new RequestParams(post_url);//设置url网址
        requestParams.setReadTimeout(5000);
        requestParams.setConnectTimeout(5000);

        //设置请求体stage_id=1&limit=10&page=1
        requestParams.addQueryStringParameter("stage_id","1");
        requestParams.addQueryStringParameter("limit","10");
        requestParams.addQueryStringParameter("page","1");

        x.http().post(requestParams, new Callback.CommonCallback<String>() {//泛型放置请求结果类型

            @Override
            public void onSuccess(String result) {//成功
                Toast.makeText(XutilsActivity.this, "结果为"+result, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {//失败
                Toast.makeText(XutilsActivity.this, "失败了", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onCancelled(CancelledException cex) {//用户取消
                Toast.makeText(XutilsActivity.this, "取消了", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFinished() {//完成
                Toast.makeText(XutilsActivity.this, "完成了", Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void bt_http_get() {

        RequestParams requestParams = new RequestParams(get_url);//设置url网址
        requestParams.setReadTimeout(5000);
        requestParams.setConnectTimeout(5000);

        x.http().get(requestParams, new Callback.CommonCallback<String>() {//泛型放置请求结果类型

            @Override
            public void onSuccess(String result) {//成功
                Toast.makeText(XutilsActivity.this, "结果为"+result, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {//失败
                Toast.makeText(XutilsActivity.this, "失败了", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onCancelled(CancelledException cex) {//用户取消
                Toast.makeText(XutilsActivity.this, "取消了", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFinished() {//完成
                Toast.makeText(XutilsActivity.this, "完成了", Toast.LENGTH_SHORT).show();

            }
        });

    }
}
