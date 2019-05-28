package com.example.day13_http;

import android.graphics.Bitmap;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.Map;

public class VolleyActivity extends AppCompatActivity implements View.OnClickListener {
    Button bt_http_get,bt_http_post,bt_http_pic;
    ImageView imageView;

    private String get_url="http://www.qubaobei.com/ios/cf/dish_list.php?stage_id=1&limit=10&page=1";
    private String post_url="http://www.qubaobei.com/ios/cf/dish_list.php";//缺少page的请求参数 使用post提交
    private String pic_url="https://images0.cnblogs.com/blog/651487/201501/281616176915467.jpg";//视频网址
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volley);
        bt_http_get=findViewById(R.id.bt_http_get);
        bt_http_get.setOnClickListener(this);
        bt_http_post=findViewById(R.id.bt_http_post);
        bt_http_post.setOnClickListener(this);
        bt_http_pic=findViewById(R.id.bt_http_pic);
        bt_http_pic.setOnClickListener(this);
        imageView=findViewById(R.id.image);
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
            case R.id.bt_http_pic:
                bt_http_pic();
                break;
        }
    }

    private void bt_http_pic() {
        //TODO 1:请求队列
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        //String url, Response.Listener<Bitmap> listener, int maxWidth, int maxHeight,Config decodeConfig, Response.ErrorListener errorListener
        //参数一：网址
        //参数二： 成功监听
        //参数三：最大宽度
        //参数四：最大高度
        //参数五：Config
        //参数六：错误监听
        //TODO 2:request对象
        ImageRequest imageRequest=new ImageRequest(pic_url, new Response.Listener<Bitmap>() {
            @Override
            public void onResponse(Bitmap response) {
                Toast.makeText(VolleyActivity.this, "请求成功", Toast.LENGTH_SHORT).show();
                imageView.setImageBitmap(response);


            }
        }, 500, 500, Bitmap.Config.RGB_565, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(VolleyActivity.this, "请求失败", Toast.LENGTH_SHORT).show();
            }
        });
        //TODO 3:将request放到队列中
        requestQueue.add(imageRequest);

    }

    private void bt_http_post() {
        //TODO 1:请求队列
        RequestQueue requestQueue = Volley.newRequestQueue(this);//单例模式，保证是一个请求队列
        //TODO 2:request对象
        //int method, String url, Listener<String> listener,ErrorListener errorListener
        //参数一 请求方式 Method.POST 或者Method.GET
        //参数二 网址
        //参数三 正确监听
        //参数四 失败监听
        StringRequest stringRequest = new StringRequest(Request.Method.POST, post_url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {//成功
                Toast.makeText(VolleyActivity.this, ""+response, Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {//失败
                Toast.makeText(VolleyActivity.this, "请求失败"+error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {//放置请求参数的
                HashMap<String, String> map = new HashMap<>();
                //stage_id=1&limit=10&page=1
                map.put("stage_id","1");
                map.put("limit","10");
                map.put("page","1");
                return map;
            }
        };
        //TODO 3:将request放到队列中
        requestQueue.add(stringRequest);
    }

    private void bt_http_get() {
        //TODO 1:请求队列
        final RequestQueue requestQueue = Volley.newRequestQueue(this);//单例模式，保证是一个请求队列
        //TODO 2:request对象
        //int method, String url, Listener<String> listener,ErrorListener errorListener
    //参数一 请求方式 Method.POST 或者Method.GET
    //参数二 网址
    //参数三 正确监听
    //参数四 失败监听
    StringRequest stringRequest = new StringRequest(Request.Method.GET, get_url, new Response.Listener<String>() {
        @Override
        public void onResponse(String response) {//成功

            //string--->输入流
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(response.getBytes());


            Toast.makeText(VolleyActivity.this, ""+response, Toast.LENGTH_SHORT).show();
        }
    }, new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {//失败
            Toast.makeText(VolleyActivity.this, "请求失败"+error.getMessage(), Toast.LENGTH_SHORT).show();
        }
    });
    //TODO 3:将request放到队列中
        requestQueue.add(stringRequest);

}
}
