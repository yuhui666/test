package com.example.day14_xrecyclerview_soundpool.xrecyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.day14_xrecyclerview_soundpool.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

//TODO 2:添加泛型重写方法
public class RVAdapter extends RecyclerView.Adapter<RVAdapter.RVViewHolder>{
    ArrayList<Bean.DataBean> list;

    Context context;

    public RVAdapter(ArrayList<Bean.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    //增加
    public void add(ArrayList<Bean.DataBean> list1){
        this.list.addAll(list1);
        this.notifyDataSetChanged();

    }
    //删除
    public void delete(int position){
        this.list.remove(position);
        this.notifyDataSetChanged();

    }
    //清空
    public void clear(){
        this.list.clear();
        this.notifyDataSetChanged();

    }



    //TODO :创建航布局的RVViewHolder
    @NonNull
    @Override
    public RVViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(context).inflate(R.layout.item, viewGroup,false);
        return new RVViewHolder(view);
    }

    //TODO :绑定数据
    @Override
    public void onBindViewHolder(@NonNull RVViewHolder rvViewHolder, final int i) {//i是下标
        rvViewHolder.textView.setText(list.get(i).getFood_str());
        Picasso.get().load(list.get(i).getPic()).into(rvViewHolder.imageView);



    }
    //TODO:返回集合的长度
    @Override
    public int getItemCount() {
        return list.size();
    }

    //TODO 1:视图持有者：item控件
    class RVViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView;

        public RVViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.image);
            textView=itemView.findViewById(R.id.tv);
        }
    }

}
