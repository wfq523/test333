package com.example.neusoftfood_523wfq.model;

import com.example.neusoftfood_523wfq.beans.UserInfo;
import com.example.neusoftfood_523wfq.common.Constants;
import com.example.neusoftfood_523wfq.iface.UserInfoInterface;
import com.example.neusoftfood_523wfq.listener.UserInfoListener;
import com.example.neusoftfood_523wfq.service.UserInfoService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UserInfoModel implements UserInfoInterface {
    private Retrofit retrofit;

    public UserInfoModel(){
        retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Override
    public void getUserInfo(int user_id, final UserInfoListener userInfoListener) {
        UserInfoService userInfoService = retrofit.create(UserInfoService.class);
        Call<UserInfo> call = userInfoService.getUserInfo(user_id);
        call.enqueue(new Callback<UserInfo>() {
            @Override
            public void onResponse(Call<UserInfo> call, Response<UserInfo> response) {
                userInfoListener.onResponse(response.body());
            }

            @Override
            public void onFailure(Call<UserInfo> call, Throwable t) {
                userInfoListener.onFail();
            }
        });
    }
}
