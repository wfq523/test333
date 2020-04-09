package com.example.a509zlyjsj.service;

import com.example.a509zlyjsj.bean.RegistBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RegistService {
    @GET("api.php/reg")
    Call<String> reg(@Query("username") String username,
                         @Query("password") String password,
                         @Query("tel") String tel
    );
}
