package com.example.a509zlyjsj.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.example.a509zlyjsj.R;
import com.example.a509zlyjsj.bean.LoginBean;
import com.example.a509zlyjsj.iface.LoginListener;
import com.example.a509zlyjsj.model.LoginModel;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    private EditText etuser, etpass;
    private Button btnlogin,btnregist;
    private Switch sw;
    private String username = "", password = "", sessionID = "";
    private SharedPreferences sp;

    private LoginListener loginListener = new LoginListener() {
        @Override
        public void onResponse(LoginBean loginBean) {
            sessionID = loginBean.getSessionid();
            Log.i("loginInfo", "----sessionID=" + sessionID);
            if (sessionID != null) {
                saveSP();
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
    private void saveSP() {
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("username",etuser.getText().toString());
        editor.putString("password",etpass.getText().toString());
        editor.putBoolean("remember",sw.isChecked());
        editor.putString("sessionID",sessionID);
        editor.commit();
    }
    private void readSP() {
        String name = sp.getString("username","");
        String pass = sp.getString("password","");
        Boolean remember = sp.getBoolean("remember",false);
        if(remember){
            etuser.setText(name);
            etpass.setText(pass);
            sw.setChecked(remember);
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initViews();
        sp = getSharedPreferences("login",MODE_PRIVATE);
        readSP();
    }
    private void initViews() {
        etuser = findViewById(R.id.editText);
        etpass = findViewById(R.id.editText2);
        btnlogin = findViewById(R.id.button);
        btnregist = findViewById(R.id.button4);
        sw = findViewById(R.id.switch1);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //登录的代码
                username = etuser.getText().toString();
                password = etpass.getText().toString();
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
        btnregist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,RegistActivity.class);
                startActivity(intent);
            }
        });
    }
}