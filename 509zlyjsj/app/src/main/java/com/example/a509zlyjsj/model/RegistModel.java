package com.example.a509zlyjsj.model;

import android.util.Log;


import com.example.a509zlyjsj.bean.RegistBean;
import com.example.a509zlyjsj.common.Common;
import com.example.a509zlyjsj.iface.RegistIface;
import com.example.a509zlyjsj.iface.RegistListener;
import com.example.a509zlyjsj.service.RegistService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class RegistModel implements RegistIface {
    private Retrofit retrofit;

    public RegistModel(){
        retrofit = new Retrofit.Builder()
                .baseUrl(Common.BASEURL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();
    }

    @Override
    public void getRegistResult(String account, String pass, String phone, final RegistListener registListener) {
        RegistService registService = retrofit.create(RegistService.class);
        Call<String> call = registService.reg(account,pass,phone);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if(response.body().equals("1")){
                    registListener.onResponse("注册成功");
                    Log.i("registInfo", "response: "+response.body());
                }else{
                    registListener.onFail(response.body());
                    Log.i("registInfo", "response: "+response.body());
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                registListener.onFail(t.getMessage());
            }
        });
    }
}
