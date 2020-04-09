package com.example.case06_523wfq;


import java.util.List;


public interface FoodListener {
    //成功返回信息
    void onResponse(List<FoodBean> beanlist);
    //失败返回错误字符串
    void onFail();
}
