package com.example.recyclerviewdemo_523.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.util.Linkify;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.recyclerviewdemo_523.Adapter.MyAdapter;
import com.example.recyclerviewdemo_523.Bean.Food_523wfq;
import com.example.recyclerviewdemo_523.R;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class FoodActivity_523 extends AppCompatActivity {

    private Button btn;
    ImageView imageView;
    TextView tvtitle, tvpeiliao, tvdianhua, tvcanting;
    List<Food_523wfq> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_523);


        initViews();

    }

    private void initViews() {
        btn = findViewById(R.id.button2);
        imageView = findViewById(R.id.imageView);
        tvtitle = findViewById(R.id.textView);
        tvpeiliao = findViewById(R.id.textView4);
        tvcanting = findViewById(R.id.textView5);
        tvdianhua = findViewById(R.id.textView6);

//        int id=0;
//
//        switch (Item.getId()){
//            case R.id.textView:
//                id=0;
//
//        }
        imageView.setImageResource(R.drawable.icon_1);
        tvtitle.setText("韭菜炒鸡蛋");
        tvpeiliao.setText("配料：鸡蛋，韭菜");
        tvcanting.setText("所在餐厅：俺家小厨房");
        tvdianhua.setText("订餐电话：15541150885");

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FoodActivity_523.this, MainActivity.class);
                startActivity(intent);


            }
        });
    }
}

