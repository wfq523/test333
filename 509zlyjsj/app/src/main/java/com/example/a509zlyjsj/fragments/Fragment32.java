package com.example.a509zlyjsj.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.a509zlyjsj.R;
import com.example.a509zlyjsj.adapter.SpecialVideoAdapter;
import com.example.a509zlyjsj.bean.SpecialVideoBean;
import com.example.a509zlyjsj.iface.SpecialVideoListener;
import com.example.a509zlyjsj.model.SpecialVideoModel;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;

public class Fragment32 extends BaseFragment {
    private int page=1; // 代表页数，并初始化为1，代表第1页。
    private int lastVisibleItemPosition;//最后一条可见条目的位置
    private List<SpecialVideoBean> list;
    private XRecyclerView recyclerView;
    private LinearLayoutManager layoutManager;//显示布局效果
    private SpecialVideoAdapter adapter;

    private SpecialVideoListener listener = new SpecialVideoListener() {

        @Override
        public void onResponse(List<SpecialVideoBean> specialVideoBeans) {
            if(page==1)
            {
                list=specialVideoBeans;
            }
            else {
                list.removeAll(specialVideoBeans);
                list.addAll(specialVideoBeans);
            }
            adapter.setList(list);
        }

        @Override
        public void onFail(String msg) {
            Toast.makeText(context, "失败："+msg, Toast.LENGTH_SHORT).show();

        }
    };
    public Fragment32() {    }
    @Nullable
    @Override //生命周期方法，创建View
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return  inflater.inflate(R.layout.fragment32,container,false);
    }
    @Override//生命周期方法，View创建完成
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        System.out.println("--f32--"+getSessionId());
        initRecyclerView(view);
        SpecialVideoModel model=new SpecialVideoModel();
        model.getResultList("video",page,getSessionId(),listener);//页码默认第一页
    }
    private void initRecyclerView(View view) {
        recyclerView=view.findViewById(R.id.XRecyclerView32);
        layoutManager=new LinearLayoutManager(context);
        recyclerView.setLayoutManager(layoutManager);
        //每个item如果是确定高度，设置此项提高性能
        recyclerView.setHasFixedSize(true);
        //实例化适配器
        adapter=new SpecialVideoAdapter(context);
        recyclerView.setAdapter(adapter);
        recyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                list.clear();
                page = 1;
                SpecialVideoModel model = new SpecialVideoModel();
                model.getResultList("video", page, getSessionId(), listener);
                recyclerView.refreshComplete();
            }

            @Override
            public void onLoadMore() {
                page += 1;
                SpecialVideoModel model = new SpecialVideoModel();
                model.getResultList("video", page, getSessionId(), listener);
                recyclerView.refreshComplete();
            }
        });

    }
}