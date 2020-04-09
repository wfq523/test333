package com.example.a509zlyjsj.iface;

import com.example.a509zlyjsj.bean.ListBean;

import java.util.List;

//获取网络数据结果
public interface ArticleListener {
    //成功返回信息
    void onResponse(List<ListBean> beanlist);
    //失败返回错误字符串
    void onFail(String msg);
}