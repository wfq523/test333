package com.example.a509zlyjsj.service;

import com.example.a509zlyjsj.bean.LoginBean;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface UserService {
    @POST("api.php/login")
    Call<LoginBean> login(
            @Query("username") String username,
            @Query("password") String password
    );
}
