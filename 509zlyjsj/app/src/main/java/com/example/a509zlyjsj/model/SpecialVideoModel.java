package com.example.a509zlyjsj.model;

import com.example.a509zlyjsj.bean.SpecialVideoBean;
import com.example.a509zlyjsj.common.Common;
import com.example.a509zlyjsj.iface.SpecialVideoIface;
import com.example.a509zlyjsj.iface.SpecialVideoListener;
import com.example.a509zlyjsj.service.SpecialVideoService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

//model  获取文章数据
public class SpecialVideoModel implements SpecialVideoIface {
    private Retrofit retrofit;

    //构造函数
    public SpecialVideoModel()
    {   //使用Retrofit----1
        retrofit=new Retrofit.Builder()
                .baseUrl(Common.BASEURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }


    @Override
    public void getResultList(String mod, int page, String sessionID, final SpecialVideoListener listener) {
        //使用Retrofit----2
        SpecialVideoService service
                =retrofit.create(SpecialVideoService.class);
        Call<List<SpecialVideoBean>> call
                =service.getArticleList(mod,page,sessionID);
        //使用Retrofit----3
        ((Call) call).enqueue(new Callback<List<SpecialVideoBean>>() {
            @Override
            public void onResponse(Call<List<SpecialVideoBean>> call, Response<List<SpecialVideoBean>> response) {
                if(response.isSuccessful() && response!=null)
                {  listener.onResponse(response.body());
                }
                else   listener.onFail("on response fail");
            }
            @Override
            public void onFailure(Call<List<SpecialVideoBean>> call, Throwable t) {
                listener.onFail(t.toString());
            }
        });
    }
}
