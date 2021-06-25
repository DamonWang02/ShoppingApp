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

import com.example.shopping.MainActivity;
import com.example.shopping.R;

import org.json.JSONArray;
import org.json.JSONObject;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editTextLoginEditPhone;
    private EditText editTextLoginEditPassword;
    private Button buttonLoginEnterSystem;
    private Button buttonLoginRegisterUser;
    private SharedPreferences.Editor editor;
    private String data;
    private String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initView();
        setButtonOnClickListener();
    }

    private void initView(){
        editTextLoginEditPhone = findViewById(R.id.edittextLoginEditPhone);
        editTextLoginEditPassword = findViewById(R.id.edittextLoginEditPassword);
        buttonLoginEnterSystem = findViewById(R.id.buttonLoginEnterSystem);
        buttonLoginRegisterUser = findViewById(R.id.buttonLoginRegisterUser);
    }

    private void setButtonOnClickListener(){
        buttonLoginEnterSystem.setOnClickListener(this);
        buttonLoginRegisterUser.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonLoginEnterSystem:
                sendRequestWithOkHttp();
                break;

            case R.id.buttonLoginRegisterUser:
                Intent intentEnterRegister = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intentEnterRegister);
            default:
                break;
        }
    }

    private void sendRequestWithOkHttp() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {

                    String phone = editTextLoginEditPhone.getText().toString();

                    OkHttpClient client = new OkHttpClient();
                    RequestBody requestBody = new FormBody.Builder().add("phone",phone).build();
                    url = getResources().getString(R.string.server_url);
                    Request request = new Request.Builder().url(url + "selectuser/" + phone).post(requestBody).build();
                    Response response = client.newCall(request).execute();
                    data = response.body().string();
                    parserData(data);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private void parserData(final String getData){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                try{

                    String password = editTextLoginEditPassword.getText().toString();

                    JSONArray jsonArray = new JSONArray(getData);
                    JSONObject jsonObject = jsonArray.getJSONObject(0);
                    String returnPhone = jsonObject.getString("phone");
                    saveUserInformation(returnPhone);
                    String returnPassword = jsonObject.getString("password");
                    System.out.println(jsonObject.toString());
                    if (password.equals(returnPassword)){
                        Intent enter_homepage = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(enter_homepage);
                        Log.d("MainActivity",data);

                    } else {

                        Toast.makeText(LoginActivity.this,"Sorry Sir, your phone or password is wrong!",Toast.LENGTH_SHORT).show();


                    }
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

    }

    private void saveUserInformation(String getInformation){

        editor = getSharedPreferences("userInformation",MODE_PRIVATE).edit();
        editor.putString("phone",getInformation);
        editor.commit();
    }
}