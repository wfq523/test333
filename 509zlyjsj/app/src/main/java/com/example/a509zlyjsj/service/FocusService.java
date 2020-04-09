package com.example.a509zlyjsj.service;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface FocusService {
    //判断是否已经关注
    @GET("api.php/exists/mod/{mod}")
    Call<String> exists(@Path("mod") String mod, @Query("idolid") int idolid, @Header("SessionID") String sessionID);

    //关注
    @GET("api.php/create/mod/{mod}")
    Call<String> focus(@Query("mod") String mod, @Query("idolid") int idolid,
                       @Header("SessionID") String SessionID);

    //取消关注
    Call<String> unfocus(@Path("mod") String mod,@Query("idolid") int idolid,@Header("SessionID") String sessionID);
}
