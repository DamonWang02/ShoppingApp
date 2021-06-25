package com.example.shopping.activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.shopping.MainActivity;
import com.example.shopping.R;
import com.mob.MobSDK;

import org.json.JSONArray;
import org.json.JSONObject;

import cn.sharesdk.onekeyshare.OnekeyShare;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class DetailActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView imageView;
    private TextView textViewName;
    private TextView textViewPrice;
    private Button save;
    private Button purchase;
    private Button shareSDK;
    private String url;
    private String id;
    private String name;
    private String price;
    private String imageUrl;

    private void initView(){
        imageView = (ImageView) findViewById(R.id.detail_image_view);
        textViewName = (TextView) findViewById(R.id.detail_text_view_name);
        textViewPrice = (TextView) findViewById(R.id.detail_text_view_price);
        save = (Button) findViewById(R.id.detail_button_save);
        purchase = (Button) findViewById(R.id.detail_button_purchase);
        shareSDK = (Button) findViewById(R.id.detail_button_sharesdk);

    }

    private void initData(){
        final Intent getIntent = getIntent();
        new Thread(new Runnable() {
            @Override
            public void run() {

                try {

                    OkHttpClient client = new OkHttpClient();
                    RequestBody requestBody = new FormBody.Builder().build();
                    url = getResources().getString(R.string.server_url);
                    Request request = new Request.Builder().url(url+ "commodityall/"+ getIntent.getStringExtra("detail_id")).post(requestBody).build();
                    Response response = client.newCall(request).execute();
                    final String data = response.body().string();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            paintView(data);
                        }
                    });

                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private void paintView(String data){
        try{
            JSONArray jsonArray = new JSONArray(data);
            JSONObject jsonObject = jsonArray.getJSONObject(0);
            Glide.with(DetailActivity.this).load(jsonObject.getString("url")).into(imageView);
            textViewName.setText(jsonObject.getString("name"));
            textViewPrice.setText(jsonObject.getString("price"));

            id = jsonObject.getString("id");
            name = jsonObject.getString("name");
            price = jsonObject.getString("price");
            imageUrl = jsonObject.getString("url");
            System.out.println("---------->imageUrl" + imageUrl);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        initView();
        initData();

        save.setOnClickListener(this);
        purchase.setOnClickListener(this);
        shareSDK.setOnClickListener(this);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home :
                Intent intent = new Intent(DetailActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                break;
            default:
                break;
        }

        return super.onOptionsItemSelected(item);

    }

    private void saveShopCar(){
        new Thread(new Runnable() {
            @Override
            public void run() {

                try {

                    OkHttpClient client = new OkHttpClient();
                    RequestBody requestBody = new FormBody.Builder().build();
                    url = getResources().getString(R.string.server_url);
                    Request request = new Request.Builder().url(url+ "savelistentity?id="+id+"&name="+name+"&price="+price+"&url="+imageUrl).post(requestBody).build();
                    Response response = client.newCall(request).execute();
                    final String data = response.body().string();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            System.out.println("--------------> CarShop" + data);
                            Toast.makeText(DetailActivity.this,"已加入购物车！",Toast.LENGTH_SHORT).show();
                        }
                    });

                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        }).start();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.detail_button_save:

                SharedPreferences.Editor editor = getSharedPreferences("order",MODE_PRIVATE).edit();
                editor.putString("id",id);
                editor.putString("name",name);
                editor.putString("price",price);
                editor.commit();

                saveShopCar();
                break;

            case R.id.detail_button_purchase:

                Intent intent = new Intent(DetailActivity.this,PurchaseActivity.class);
                intent.putExtra("name",name);
                intent.putExtra("price",price);
                intent.putExtra("url",imageUrl);
                startActivity(intent);
                break;


             case R.id.detail_button_sharesdk:

                 /**
                  * 用于一键分享
                  */
             OnekeyShare oks = new OnekeyShare();
             // title标题，微信、QQ和QQ空间等平台使用
             oks.setTitle(getString(R.string.share));
             // titleUrl QQ和QQ空间跳转链接
             oks.setTitleUrl("http://sharesdk.cn");
             // text是分享文本，所有平台都需要这个字段
             oks.setText(name+price);
             // setImageUrl是网络图片的url
             oks.setImageUrl(imageUrl);
             // url在微信、Facebook等平台中使用
             oks.setUrl("http://sharesdk.cn");
             // 启动分享GUI
             oks.show(MobSDK.getContext());


            default:
                break;
        }
    }
}