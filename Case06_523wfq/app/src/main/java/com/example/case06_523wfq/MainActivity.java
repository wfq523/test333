package com.example.case06_523wfq;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;



import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rv;
    private int page = 1;
    private List<FoodBean> list = new ArrayList<>();
    private Context context;
    private FoodAdapter adapter;

    private int lastVisibleItemPosition;//最后一条可见条目的位置
    private LinearLayoutManager layoutManager;

    private FoodListener listener = new FoodListener() {

        @Override
        public void onResponse(List<FoodBean> beanlist) {
            if (page == 1) {
                list = beanlist;
            } else {
                list.removeAll(beanlist);
                list.addAll(beanlist);
            }
            adapter.setList(list);
        }

        @Override
        public void onFail() {
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        rv = findViewById(R.id.recyclerview);
        layoutManager = new LinearLayoutManager(context);
        rv.setLayoutManager(layoutManager);
        adapter = new FoodAdapter(context);
        rv.setAdapter(adapter);
        login();
    }

    void login() {
        FoodModel userModel = new FoodModel();
        userModel.userLogin(1, listener);
    }
}

