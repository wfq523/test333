package com.example.case06_523wfq;


import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FoodModel {
    private FoodService service;
    private Retrofit retrofit;

    public FoodModel() {
        retrofit = new Retrofit.Builder()
                .baseUrl(Common.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(FoodService.class);
    }
    public void userLogin(int shop_id, final FoodListener listener)  {
        Call call=service.getFoodList(shop_id);
        Callback<List<FoodBean>> callback = new Callback<List<FoodBean>>() {
            @Override
            public void onResponse(Call<List<FoodBean>> call, Response<List<FoodBean>> response) {
//                listener.onSuccess(response.body(),1);
                listener.onResponse(response.body());
            }

            @Override
            public void onFailure(Call<List<FoodBean>> call, Throwable t) {
                listener.onFail();
            }
        };
        call.enqueue(callback);
    }
}

