package com.example.retrofitmvcdemo523.iface;

public interface Loginiface {

    void getLoginResult(String username,
                        String userpass,
                        LoginListener loginListener
    );
}
