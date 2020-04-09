package com.example.recyclerviewdemo_523wfq;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private List<DemoBean> list;
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        //线性布局
        layoutManager= new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        //设置 item 高度固定的，提高性能
        recyclerView.setHasFixedSize(true);

        list=getData();
        myAdapter=new MyAdapter(this);
        myAdapter.setList(list);
        recyclerView.setAdapter(myAdapter);
    }

    private void initViews() {

        recyclerView=findViewById(R.id.recyclerview);

    }

    public List<DemoBean> getData() {
        List<DemoBean> list = new ArrayList<DemoBean>();
        DemoBean demoBean;
        demoBean = new DemoBean();
        demoBean.setId(1);
        demoBean.setTitle("标题1");
        demoBean.setImgid(R.drawable.icon_1);
        demoBean.setTime("2017-4-1 15:16");
        demoBean.setDescription("描述1");
        list.add(demoBean);

        demoBean = new DemoBean();
        demoBean.setId(2);
        demoBean.setTitle("标题2");
        demoBean.setImgid(R.drawable.icon_2);
        demoBean.setTime("2017-4-2 15:16");
        demoBean.setDescription("描述2");
        list.add(demoBean);

        demoBean = new DemoBean();
        demoBean.setId(3);
        demoBean.setTitle("标题3");
        demoBean.setImgid(R.drawable.icon_3);
        demoBean.setTime("2017-4-3 15:16");
        demoBean.setDescription("描述3");
        list.add(demoBean);

        demoBean = new DemoBean();
        demoBean.setId(4);
        demoBean.setTitle("标题4");
        demoBean.setImgid(R.drawable.icon_4);
        demoBean.setTime("2017-4-4 15:16");
        demoBean.setDescription("描述4");
        list.add(demoBean);

        demoBean = new DemoBean();
        demoBean.setId(5);
        demoBean.setTitle("标题5");
        demoBean.setImgid(R.drawable.icon_5);
        demoBean.setTime("2017-4-3 15:16");
        demoBean.setDescription("描述3");
        list.add(demoBean);

        demoBean = new DemoBean();
        demoBean.setId(6);
        demoBean.setTitle("标题6");
        demoBean.setImgid(R.drawable.icon_6);
        demoBean.setTime("2017-4-4 15:16");
        demoBean.setDescription("描述4");
        list.add(demoBean);
        demoBean = new DemoBean();
        demoBean.setId(7);
        demoBean.setTitle("标题7");
        demoBean.setImgid(R.drawable.f1);
        demoBean.setTime("2017-4-3 15:16");
        demoBean.setDescription("描述3");
        list.add(demoBean);

        demoBean = new DemoBean();
        demoBean.setId(8);
        demoBean.setTitle("标题8");
        demoBean.setImgid(R.drawable.f2);
        demoBean.setTime("2017-4-4 15:16");
        demoBean.setDescription("描述4");
        list.add(demoBean);
        return list;

    }

}
