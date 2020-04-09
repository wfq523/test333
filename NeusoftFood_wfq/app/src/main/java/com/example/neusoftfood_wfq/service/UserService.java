package com.example.neusoftfood_wfq.service;

import com.example.neusoftfood_wfq.beans.Success;
import com.example.neusoftfood_wfq.beans.UserInfo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface UserService {

    @GET("userLogin.do")
    Call<UserInfo> login(@Query("username")String username,
                         @Query("userpass")String password);

    @GET("userRegister.do")
    Call<Success> register(
            @Query("username") String username,
            @Query("userpass") String userpass,
            @Query("mobilenum") String mobilenum,
            @Query("address") String address,
            @Query("commet") String comment
    );
}
