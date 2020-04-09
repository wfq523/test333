package com.example.a509zlyjsj.iface;

import com.example.a509zlyjsj.bean.LoginBean;

public interface LoginListener {
    //成功返回登录信息
    void onResponse(LoginBean loginBean);
    //失败返回错误字符串
    void onFail(String msg);
}
