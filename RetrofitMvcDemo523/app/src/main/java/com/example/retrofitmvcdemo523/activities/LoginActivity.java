package com.example.retrofitmvcdemo523.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.retrofitmvcdemo523.R;
import com.example.retrofitmvcdemo523.bean.LoginBean;
import com.example.retrofitmvcdemo523.iface.LoginListener;
import com.example.retrofitmvcdemo523.model.LoginModel;
import com.example.retrofitmvcdemo523.service.UserService;
import com.squareup.picasso.Picasso;

import retrofit2.Retrofit;

public class LoginActivity extends AppCompatActivity {

    private EditText etname;
    private EditText etpass;
    private Button btn_login;
    private Button btn_reg;
    private String username ="",password="",sessionID ="";

    ImageView imageView;

    private LoginListener loginListener =new LoginListener() {
        @Override
        public void onResponse(LoginBean loginBean) {

            sessionID=loginBean.getSessiodid();
            Log.i("LoginActivity","--sessionID=" +sessionID);
            if (sessionID!=null){
                Toast.makeText(LoginActivity.this, "登录成功" + sessionID, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            } else
                Toast.makeText(LoginActivity.this, "登录失败", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onFail(String msg) {

            Toast.makeText(LoginActivity.this, msg, Toast.LENGTH_SHORT).show();
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        imageView=findViewById(R.id.imagepicasso);
        Picasso.with(this).load("http://i0.hdslb.com/bfs/archive/ea1b27e66098ffb709b76d2e3837e798f8d4de75.jpg").into(imageView);

        initViews();

    }
    private void initViews() {
        btn_reg=findViewById(R.id.button_register);
        btn_login=findViewById(R.id.button_login);
        etname=findViewById(R.id.etuser);
        etpass=findViewById(R.id.etpass);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //登录代码
                username=etname.getText().toString();
                password=etpass.getText().toString();
                if(username.equals(""))
                    Toast.makeText(LoginActivity.this, "请输入用户名", Toast.LENGTH_SHORT).show();
                else if(password.equals(""))
                    Toast.makeText(LoginActivity.this, "请输入密码", Toast.LENGTH_SHORT).show();
                else {
                    LoginModel loginModel = new LoginModel();
                    loginModel.getLoginResult(username, password, loginListener);
                }
            }
        });

    }
}
