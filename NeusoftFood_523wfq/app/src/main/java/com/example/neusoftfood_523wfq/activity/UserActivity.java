package com.example.neusoftfood_523wfq.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.neusoftfood_523wfq.R;
import com.example.neusoftfood_523wfq.beans.Success;
import com.example.neusoftfood_523wfq.listener.UpdateInfoListener;
import com.example.neusoftfood_523wfq.model.UpdateInfoModel;

public class UserActivity extends AppCompatActivity {
    private int user_id;
    private Button btnRegister, backLand;
    private String username = "", userpass = "", mobilenum = "", address = "";
    private EditText et_reg_user, et_reg_password, et_reg_repassword, et_reg_telephone, et_reg_address;

    // 更新用户信息监听对象
    private UpdateInfoListener updateInfoListener = new UpdateInfoListener() {
        @Override
        public void onResponse(Success success) {
            // 修改成功
            if ("1".equals(success.getSuccess())){
                Toast.makeText(UserActivity.this, "修改成功", Toast.LENGTH_SHORT).show();
                finish();
            // 修改失败
            }else {
                Toast.makeText(UserActivity.this, "修改失败", Toast.LENGTH_SHORT).show();
            }
        }

        @Override
        public void onFail() {
            Toast.makeText(UserActivity.this, "网络错误", Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        // 接收数据
        user_id = getIntent().getIntExtra("user_id",0);
        username = getIntent().getStringExtra("username");
        mobilenum = getIntent().getStringExtra("mobilenum");
        address = getIntent().getStringExtra("address");
        initViews();
    }

    // 获取控件id
    private void initViews() {//初始化组件
        et_reg_user = findViewById(R.id.editText);
        et_reg_password = findViewById(R.id.editText2);
        et_reg_repassword = findViewById(R.id.editText3);
        et_reg_telephone = findViewById(R.id.editText4);
        et_reg_address = findViewById(R.id.editText5);
        btnRegister = findViewById(R.id.button);
        backLand = findViewById(R.id.button2);

        et_reg_user.setText(username);
        et_reg_telephone.setText(mobilenum);
        et_reg_address.setText(address);
        //创建返回监听事件
        backLand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//判断注册信息
                if (et_reg_user.getText().toString().equals("")) {
                    Toast.makeText(UserActivity.this, "请输入账号", Toast.LENGTH_SHORT).show();
                } else if (et_reg_password.getText().toString().equals("")) {//密码为空
                    Toast.makeText(UserActivity.this, "请输入密码", Toast.LENGTH_SHORT).show();
                } else if (et_reg_repassword.getText().toString().equals("")) {//重复密码为空
                    Toast.makeText(UserActivity.this, "请再次输入密码", Toast.LENGTH_SHORT).show();
                } else if (et_reg_telephone.getText().toString().equals("")) {//电话为空
                    Toast.makeText(UserActivity.this, "请输入联系方式", Toast.LENGTH_SHORT).show();
                } else if (et_reg_address.getText().toString().equals("")) {//用户地址
                    Toast.makeText(UserActivity.this, "请输入用户地址", Toast.LENGTH_SHORT).show();
                } else if (!et_reg_repassword.getText().toString().equals(et_reg_password.getText().toString())) {//两次密码不一样
                    Toast.makeText(UserActivity.this, "密码不一致，请重新输入", Toast.LENGTH_SHORT).show();
                    et_reg_password.setText("");
                    et_reg_repassword.setText("");
                } else {//校验后提交数据，并作出相应的页面跳转
                    username = et_reg_user.getText().toString().trim();
                    userpass = et_reg_password.getText().toString().trim();
                    mobilenum = et_reg_telephone.getText().toString().trim();
                    address = et_reg_address.getText().toString().trim();
                    // 发更新信息请求
                    UpdateInfoModel updateInfoModel = new UpdateInfoModel();
                    updateInfoModel.updateInfoResult(user_id,username,userpass,mobilenum,address,updateInfoListener);
                }
            }
        });
    }
}
