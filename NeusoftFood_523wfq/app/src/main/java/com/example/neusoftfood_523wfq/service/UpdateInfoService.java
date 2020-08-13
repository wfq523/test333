package com.example.neusoftfood_523wfq.service;

import com.example.neusoftfood_523wfq.beans.Success;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface UpdateInfoService {
    @GET("updateUserById.do")
    Call<Success> updateInfo(
            @Query("user_id") int user_id,
            @Query("username") String username,
            @Query("userpass") String userpass,
            @Query("mobilenum") String mobilenum,
            @Query("address") String address
    );
}
