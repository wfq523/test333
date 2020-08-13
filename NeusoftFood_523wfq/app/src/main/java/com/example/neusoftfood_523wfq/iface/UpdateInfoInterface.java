package com.example.neusoftfood_523wfq.iface;

import com.example.neusoftfood_523wfq.listener.UpdateInfoListener;

public interface UpdateInfoInterface {

    void updateInfoResult(int user_id, String username, String userpass, String mobilenum, String address, UpdateInfoListener updateInfoListener);
}
