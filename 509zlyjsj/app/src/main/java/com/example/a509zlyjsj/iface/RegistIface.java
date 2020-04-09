package com.example.a509zlyjsj.iface;

public interface RegistIface {
    void getRegistResult(String account,
                         String pass,
                         String phone,
                         RegistListener registListener
    );
}
