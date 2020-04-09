package com.example.a509zlyjsj.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.a509zlyjsj.R;
import com.example.a509zlyjsj.iface.RegistListener;
import com.example.a509zlyjsj.model.RegistModel;

import androidx.appcompat.app.AppCompatActivity;

public class RegistActivity extends AppCompatActivity {

    private EditText etaccount,etpass,etrepass,etphone,etemail;
    private Button btnreturn,btnregist;

    private RegistListener registListener = new RegistListener(){

        @Override
        public void onResponse(String info) {
            Toast.makeText(RegistActivity.this, ""+info, Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(RegistActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        }

        @Override
        public void onFail(String msg) {
            Toast.makeText(RegistActivity.this, "注册失败："+msg, Toast.LENGTH_SHORT).show();
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist);
        InitViews();
    }
    private void InitViews(){
        etaccount = findViewById(R.id.editText3);
        etpass = findViewById(R.id.editText4);
        etrepass = findViewById(R.id.editText5);
        etphone = findViewById(R.id.editText6);
        etemail = findViewById(R.id.editText7);
        btnreturn = findViewById(R.id.button2);
        btnregist = findViewById(R.id.button3);

        btnregist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etaccount.getText().toString().equals(""))
                    Toast.makeText(RegistActivity.this, "请输入用户名", Toast.LENGTH_SHORT).show();
                else if(etpass.getText().toString().equals(""))
                    Toast.makeText(RegistActivity.this, "请输入密码", Toast.LENGTH_SHORT).show();
                else if(etrepass.getText().toString().equals(""))
                    Toast.makeText(RegistActivity.this, "请再次输入密码", Toast.LENGTH_SHORT).show();
                else if(etphone.getText().toString().equals(""))
                    Toast.makeText(RegistActivity.this, "请输入手机号", Toast.LENGTH_SHORT).show();
                else if(etemail.getText().toString().equals(""))
                    Toast.makeText(RegistActivity.this, "请输入邮箱", Toast.LENGTH_SHORT).show();
                else if(!etpass.getText().toString().equals(etrepass.getText().toString()))
                    Toast.makeText(RegistActivity.this, "两次输入密码不一致", Toast.LENGTH_SHORT).show();
                else{
                    RegistModel registModel = new RegistModel();
                    registModel.getRegistResult(etaccount.getText().toString(),etpass.getText().toString(),etphone.getText().toString(),registListener);
                }
            }
        });
        btnreturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(RegistActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
