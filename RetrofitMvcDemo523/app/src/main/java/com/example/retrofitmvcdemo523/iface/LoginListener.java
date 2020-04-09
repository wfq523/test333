package com.example.retrofitmvcdemo523.iface;

import com.example.retrofitmvcdemo523.bean.LoginBean;

public interface LoginListener {
    //成功返回登录信息
    void onResponse (LoginBean loginBean);
    //失败返回错误字符串
    void onFail(String msg);
}
