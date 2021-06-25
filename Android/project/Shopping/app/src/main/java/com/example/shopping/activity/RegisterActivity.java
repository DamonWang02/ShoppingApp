package com.example.shopping.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.shopping.R;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editTextRegisterEditPhone;
    private EditText editTextRegisterEditPassword;
    private Button buttonRegisterEnter;
    private SharedPreferences.Editor editor;
    private String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        initView();

        buttonRegisterEnter.setOnClickListener(this);
    }

    private void initView(){

        editTextRegisterEditPhone = findViewById(R.id.editTextRegisterEditPhone);
        editTextRegisterEditPassword = findViewById(R.id.editTextRegisterEditPassword);
        buttonRegisterEnter = findViewById(R.id.buttonRegisterEnter);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonRegisterEnter:
                getInformation();
                break;
            default:

        }
    }

    private void getInformation(){

        String phone = editTextRegisterEditPhone.getText().toString();
        String password = editTextRegisterEditPassword.getText().toString();

        if (phone.length() <= 12  && password.length() <=  12) {

            editor = getSharedPreferences("user_information",MODE_PRIVATE).edit();
            editor.putString("phone",phone);
            editor.putString("password",password);
            editor.apply();

            sendRequestWithOkHttp();

            Intent enterLogin = new Intent(RegisterActivity.this,LoginActivity.class);
            startActivity(enterLogin);

            Toast.makeText(RegisterActivity.this,"Congratulation register succeed!",Toast.LENGTH_SHORT).show();

        } else {

            Toast.makeText(RegisterActivity.this,"Sorry, phone or password too long or short!",Toast.LENGTH_SHORT).show();

        }
    }

    private void sendRequestWithOkHttp() {
        new Thread(new Runnable() {
            @Override
            public void run() {

                try {

                    String phone = editTextRegisterEditPhone.getText().toString();
                    String password = editTextRegisterEditPassword.getText().toString();

                    OkHttpClient client = new OkHttpClient();
                    RequestBody requestBody = new FormBody.Builder().add("phone",phone).add("password",password).build();
                    url = getResources().getString(R.string.server_url);

                    Request request = new Request.Builder().url(url+ "saveuser").post(requestBody).build();
                    Response response = client.newCall(request).execute();

                    String data = response.body().string();
                    Log.d("Register",data);


                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }).start();
    }
}