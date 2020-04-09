package com.example.a509zlyjsj.model;

import com.example.a509zlyjsj.bean.ListBean;
import com.example.a509zlyjsj.common.Common;
import com.example.a509zlyjsj.iface.ArticleIface;
import com.example.a509zlyjsj.iface.ArticleListener;
import com.example.a509zlyjsj.service.ArticleService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

//model  获取文章数据
public class ArticleModel implements ArticleIface {
    private Retrofit retrofit;

    //构造函数
    public ArticleModel()
    {   //使用Retrofit----1
        retrofit=new Retrofit.Builder()
                .baseUrl(Common.BASEURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Override
    public void getResultList(String mod, int page, String sessionID, final ArticleListener listener) {
        //使用Retrofit----2
        ArticleService service
                =retrofit.create(ArticleService.class);
        Call<List<ListBean>> call
                =service.getArticleList(mod,page,sessionID);
        //使用Retrofit----3
        ((Call) call).enqueue(new Callback<List<ListBean>>() {
            @Override
            public void onResponse(Call<List<ListBean>> call, Response<List<ListBean>> response) {
                if(response.isSuccessful() && response!=null)
                {  listener.onResponse(response.body());
                }
                else   listener.onFail("on response fail");
            }
            @Override
            public void onFailure(Call<List<ListBean>> call, Throwable t) {
                listener.onFail(t.toString());
            }
        });
    }
}