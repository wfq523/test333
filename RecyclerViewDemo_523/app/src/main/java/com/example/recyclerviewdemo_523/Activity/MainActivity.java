package com.example.recyclerviewdemo_523.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.recyclerviewdemo_523.Adapter.MyAdapter;
import com.example.recyclerviewdemo_523.Bean.Food_523wfq;
import com.example.recyclerviewdemo_523.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView rv;
    List<Food_523wfq> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv=findViewById(R.id.rv);


        //创建默认的线性LayoutManager
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        //设置布局管理器
        rv.setLayoutManager(layoutManager);
        //如果可以确定每个item的高度是固定的，可以提高性能
        rv.setHasFixedSize(true);
        list=getData();
        //创建并设置Adapter
        MyAdapter myAdapter=new MyAdapter(MainActivity.this,list);
        rv.setAdapter(myAdapter);

    }


    public List<Food_523wfq> getData() {
        List<Food_523wfq> list = new ArrayList<Food_523wfq>();
        Food_523wfq demoBean;
        demoBean = new Food_523wfq();
        demoBean.setId(1);
        demoBean.setTitle("韭菜炒鸡蛋");
        demoBean.setImgid(R.drawable.icon_1);
        demoBean.setTime("2020-3-10 1:30");
        demoBean.setDescription("清淡");
        list.add(demoBean);

        demoBean = new Food_523wfq();
        demoBean.setId(2);
        demoBean.setTitle("麻婆豆腐");
        demoBean.setImgid(R.drawable.icon_2);
        demoBean.setTime("2020-3-10 1:30");
        demoBean.setDescription("微辣");
        list.add(demoBean);

        demoBean = new Food_523wfq();
        demoBean.setId(3);
        demoBean.setTitle("木耳拌鸡蛋");
        demoBean.setImgid(R.drawable.icon_3);
        demoBean.setTime("2020-3-10 1:30");
        demoBean.setDescription("清淡");
        list.add(demoBean);

        demoBean = new Food_523wfq();
        demoBean.setId(4);
        demoBean.setTitle("葱油大豆腐");
        demoBean.setImgid(R.drawable.icon_4);
        demoBean.setTime("2020-3-10 1:30");
        demoBean.setDescription("清淡");
        list.add(demoBean);

        demoBean = new Food_523wfq();
        demoBean.setId(5);
        demoBean.setTitle("凉拌莲藕");
        demoBean.setImgid(R.drawable.icon_5);
        demoBean.setTime("2020-3-10 1:30");
        demoBean.setDescription("清淡");
        list.add(demoBean);

        demoBean = new Food_523wfq();
        demoBean.setId(6);
        demoBean.setTitle("凉调海带丝");
        demoBean.setImgid(R.drawable.icon_6);
        demoBean.setTime("2020-3-10 1:30");
        demoBean.setDescription("微辣");
        list.add(demoBean);


        demoBean = new Food_523wfq();
        demoBean.setId(7);
        demoBean.setTitle("糖醋鱼片");
        demoBean.setImgid(R.drawable.icon_7);
        demoBean.setTime("2020-3-10 1:30");
        demoBean.setDescription("略甜");
        list.add(demoBean);

        demoBean = new Food_523wfq();
        demoBean.setId(8);
        demoBean.setTitle("泡椒凤爪");
        demoBean.setImgid(R.drawable.icon_8);
        demoBean.setTime("2020-3-10 1:30");
        demoBean.setDescription("中辣");
        list.add(demoBean);
        return list;

    }
}
