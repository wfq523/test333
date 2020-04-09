package com.example.a509zlyjsj.activities;

import android.content.Context;
import android.content.SharedPreferences;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.a509zlyjsj.R;
import com.example.a509zlyjsj.common.Common;
import com.example.a509zlyjsj.iface.CollectListener;
import com.example.a509zlyjsj.model.CollectModel;
import com.example.a509zlyjsj.service.RetrofitService;
import com.github.barteksc.pdfviewer.PDFView;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import androidx.appcompat.app.AppCompatActivity;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class TwareViewActivity extends AppCompatActivity{
    private int resid;
    private PDFView pdfView;
    private Boolean flagcollect=false;//收藏标志
    private CollectModel collectmodel;//收藏model
    private MenuItem item,menuitem;
    private String sessionID="";  //sessionid
    Context context;
    private SharedPreferences sp;//简单存储

    CollectListener listener=new CollectListener() {
        @Override
        public void onResponse(String msg) {
            //获取菜单视图
            if (item==null)
                item=findViewById(R.id.collect);

            //根据mode中response返回的字符串区分返回结果
            switch (msg)
            {
                case "2": System.out.println("----收藏成功");
                    flagcollect=true;
                    item.setTitle("取消收藏");
                    break;
                case "1":System.out.println("----收藏失败");
                    break;
                case "4":System.out.println("----取消收藏成功");
                    flagcollect=false;
                    item.setTitle("收藏");
                    break;
                case "3":System.out.println("----取消收藏失败");
                    break;
                case "5":System.out.println("----已收藏");
                    flagcollect=true;
                    item.setTitle("取消收藏");
                    break;
                case "6":System.out.println("----未收藏");
                    flagcollect=false;
                    item.setTitle("收藏");
                    break;
                default:
                    Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
            }
        }
        @Override
        public void onFail(String msg) {
            Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_tware);
        context = TwareViewActivity.this;
        pdfView =  findViewById(R.id.pdfView);
        resid  = getIntent().getIntExtra("resid",1);
        sp=context.getSharedPreferences("login",MODE_PRIVATE);
        readSP();//读取sessionid
    }

    private void readSP() {
        sessionID=sp.getString("sessionID",null);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_progress, menu);
        menuitem = menu.findItem(R.id.progress);
        item = menu.findItem(R.id.collect);
        collectmodel=new CollectModel();//实例化对象
        collectmodel.exist("tware",resid,sessionID,listener);//判断是否收藏
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.collect:
                if(flagcollect)//如果已收藏，则调用取消收藏
                {
                    System.out.println("----准备取消收藏");
                    collectmodel.uncollect("tware",resid,sessionID,listener);
                }
                else//如果未收藏，则调用收藏
                {
                    System.out.println("----准备收藏");
                    collectmodel.collect("tware",resid,sessionID,listener);
                }
                break;
            case R.id.menufocus:

                break;
            case R.id.progress:
                //显示进度
                setLoadingState(true);
                //加载PDF
                loadPdf();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    //设置Retrofit访问网络的超时时间
    private static final OkHttpClient client =
            new OkHttpClient.Builder().
                    connectTimeout(600, TimeUnit.SECONDS).
                    readTimeout(600, TimeUnit.SECONDS).
                    writeTimeout(600, TimeUnit.SECONDS).build();
    private void loadPdf(){
        String url = getIntent().getStringExtra("pdfattach");
        Retrofit retrofit =
                new Retrofit.Builder()
                        .baseUrl(Common.IMAGEURL)
                        .client(client)
                        .build();


        RetrofitService service = retrofit.create(RetrofitService.class);

        final Call<ResponseBody> call = service.getPdf(url);

        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                if (response.isSuccessful()){

                    try {
                        byte[] data = response.body().bytes();

                        //加载PDF
                        pdfView.fromBytes(data).swipeHorizontal(true).load();
                        //隐藏进度
                        setLoadingState(false);

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }
    public void setLoadingState(boolean refreshing) {

        if (refreshing){

            menuitem.setActionView(R.layout.progress);
        }else {

            menuitem.setActionView(null);
        }
    }
}
