package com.example.a509zlyjsj.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.a509zlyjsj.R;
import com.example.a509zlyjsj.adapter.ArticleAdapter;
import com.example.a509zlyjsj.adapter.ProjectAdapter;
import com.example.a509zlyjsj.adapter.SpecialVideoAdapter;
import com.example.a509zlyjsj.bean.ListBean;
import com.example.a509zlyjsj.bean.SpecialVideoBean;
import com.example.a509zlyjsj.iface.ArticleListener;
import com.example.a509zlyjsj.iface.SpecialVideoListener;
import com.example.a509zlyjsj.model.ArticleModel;
import com.example.a509zlyjsj.model.SpecialVideoModel;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;

public class Fragment42 extends BaseFragment {
    private int page=1; // 代表页数，并初始化为1，代表第1页。
    private List<ListBean> list;
    private XRecyclerView recyclerView;
    private LinearLayoutManager layoutManager;//显示布局效果
    private ProjectAdapter adapter;

    private ArticleListener listener = new ArticleListener() {

        @Override
        public void onResponse(List<ListBean> listbean) {
            if(page==1)
            {
                list=listbean;
            }
            else {
                list.removeAll(listbean);
                list.addAll(listbean);
            }
            adapter.setList(list);
        }

        @Override
        public void onFail(String msg) {
            Toast.makeText(context, "失败："+msg, Toast.LENGTH_SHORT).show();

        }
    };
    public Fragment42() {    }
    @Nullable
    @Override //生命周期方法，创建View
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return  inflater.inflate(R.layout.fragment42,container,false);
    }
    @Override//生命周期方法，View创建完成
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        System.out.println("--f42--"+getSessionId());
        initRecyclerView(view);
        ArticleModel model=new ArticleModel();
        model.getResultList("project",page,getSessionId(),listener);//页码默认第一页
    }
    private void initRecyclerView(View view) {
        recyclerView=view.findViewById(R.id.XRecyclerView42);
        layoutManager=new LinearLayoutManager(context);
        recyclerView.setLayoutManager(layoutManager);
        //每个item如果是确定高度，设置此项提高性能
        recyclerView.setHasFixedSize(true);
        //实例化适配器
        adapter=new ProjectAdapter(context);
        recyclerView.setAdapter(adapter);
        recyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                list.clear();
                page = 1;
                ArticleModel model = new ArticleModel();
                model.getResultList("project", page, getSessionId(), listener);
                recyclerView.refreshComplete();
            }

            @Override
            public void onLoadMore() {
                page += 1;
                ArticleModel model = new ArticleModel();
                model.getResultList("project", page, getSessionId(), listener);
                recyclerView.refreshComplete();
            }
        });

    }
}