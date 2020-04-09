package com.example.retrofitmvcdemo523.service;

import com.example.retrofitmvcdemo523.bean.LoginBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface UserService {
    @GET("userLogin.do")
    Call<LoginBean> login(
            @Query("username") String username,
            @Query("userpass") String userpass
    );

}
