package com.example.neusoftfood_523wfq.model;

import com.example.neusoftfood_523wfq.beans.Success;
import com.example.neusoftfood_523wfq.common.Constants;
import com.example.neusoftfood_523wfq.iface.UpdateInfoInterface;
import com.example.neusoftfood_523wfq.listener.UpdateInfoListener;
import com.example.neusoftfood_523wfq.service.UpdateInfoService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UpdateInfoModel implements UpdateInfoInterface {
    private Retrofit retrofit;

    public UpdateInfoModel(){
        retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Override
    public void updateInfoResult(int user_id, String username, String userpass, String mobilenum, String address, final UpdateInfoListener updateInfoListener) {
        UpdateInfoService updateInfoService = retrofit.create(UpdateInfoService.class);
        Call<Success> call = updateInfoService.updateInfo(user_id, username, userpass, mobilenum, address);
        call.enqueue(new Callback<Success>() {
            @Override
            public void onResponse(Call<Success> call, Response<Success> response) {
                updateInfoListener.onResponse(response.body());
            }

            @Override
            public void onFailure(Call<Success> call, Throwable t) {
                updateInfoListener.onFail();
            }
        });
    }
}
