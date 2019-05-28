package com.example.day13_http.ok_fengzhuang;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.day13_http.R;

public class Ok_FZActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ok__fz);

        //使用工具类做get请求
        OkUtils.newInstance().doGet("http://www.qubaobei.com/ios/cf/dish_list.php?stage_id=1&limit=10&page=1", new OkUtils.MyCallBack() {
            @Override
            public void success(String str) {
                Log.d("ytx", "get: "+str);
            }

            @Override
            public void error(String mesage) {
                Log.d("ytx", "error: "+mesage);
            }
        });
        //使用工具类做pos请求
        OkUtils.newInstance().doPost("http://www.qubaobei.com/ios/cf/dish_list.php?stage_id=1&limit=10", new OkUtils.MyCallBack() {
            @Override
            public void success(String str) {
                Log.d("ytx", "post: "+str);
            }

            @Override
            public void error(String mesage) {
                Log.d("ytx", "error: "+mesage);
            }
        },new String[]{"page"},new String[]{"1"});

    }
}
