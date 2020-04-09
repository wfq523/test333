package com.example.a509zlyjsj.service;

import com.example.a509zlyjsj.bean.ListBean;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ArticleService {
    @GET("api.php/lists/mod/{mod}")
    Call<List<ListBean>> getArticleList(
            @Path("mod") String mod,
            @Query("page") int page,
            @Header("SessionID") String sessionID);
}

