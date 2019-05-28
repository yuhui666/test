package com.example.day14_xrecyclerview_soundpool.xrecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.day14_xrecyclerview_soundpool.R;
import com.google.gson.Gson;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;

public class XrecyclerViewActivity extends AppCompatActivity {
    XRecyclerView recyclerView;
    ArrayList<Bean.DataBean> list=new ArrayList<>();
    RVAdapter adapter;
    String url="http://www.qubaobei.com/ios/cf/dish_list.php?stage_id=1&limit=10&page=";
    int page=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xrecycler_view);

        //集合中是没有数据的
        recyclerView=findViewById(R.id.rv);
        adapter=new RVAdapter(list,this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));//列表

        //上啦加载 load ，下拉刷新 fresh

        recyclerView.setLoadingMoreEnabled(true);//支持加载
        recyclerView.setPullRefreshEnabled(true);//支持刷新
        recyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {//刷新
                page=1;
                list.clear();
                net();
            }

            @Override
            public void onLoadMore() {//加载
                page++;
                net();
            }
        });

        //网络请求数据
        net();

    }

    public void net(){
        //TODO 1:请求队列
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        //TODO 2:请求对象
        StringRequest stringRequest=new StringRequest(Request.Method.GET, url+page, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(XrecyclerViewActivity.this, ""+response, Toast.LENGTH_SHORT).show();
                //gson解析
                Gson gson = new Gson();
                Bean bean = gson.fromJson(response, Bean.class);
                //添加数据
                adapter.add((ArrayList<Bean.DataBean>) bean.getData());


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(XrecyclerViewActivity.this, "失败", Toast.LENGTH_SHORT).show();
            }
        });
        //TODO 3：队列中添加请求对象
        requestQueue.add(stringRequest);

        //TODO 重点 加载或刷新完毕
        recyclerView.loadMoreComplete();
        recyclerView.refreshComplete();
    }



}
