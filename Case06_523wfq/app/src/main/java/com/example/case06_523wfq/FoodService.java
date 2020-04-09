package com.example.case06_523wfq;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface FoodService {
    @GET("getFoodByShop.do")
    Call<List<FoodBean>> getFoodList(
            @Query("shop_id") int shop_id
    );

}
