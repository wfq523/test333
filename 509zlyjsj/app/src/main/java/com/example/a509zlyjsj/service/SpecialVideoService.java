package com.example.a509zlyjsj.service;

import com.example.a509zlyjsj.bean.SpecialVideoBean;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface SpecialVideoService {
    @GET("api.php/listspecial/mod/{mod}")
    Call<List<SpecialVideoBean>> getArticleList(
            @Path("mod") String mod,
            @Query("page") int page,
            @Header("SessionID") String sessionID);
}
