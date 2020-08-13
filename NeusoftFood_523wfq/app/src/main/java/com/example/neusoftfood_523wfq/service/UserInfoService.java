package com.example.neusoftfood_523wfq.service;

import com.example.neusoftfood_523wfq.beans.UserInfo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface UserInfoService {

    @GET("getUserById.do")
    Call<UserInfo> getUserInfo(
            @Query("user_id") int user_id
    );
}
