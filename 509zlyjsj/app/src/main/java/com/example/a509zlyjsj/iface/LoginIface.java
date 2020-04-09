package com.example.a509zlyjsj.iface;

public interface LoginIface {
    void getLoginResult(String username,
                        String pass,
                        LoginListener loginListener
    );
}
