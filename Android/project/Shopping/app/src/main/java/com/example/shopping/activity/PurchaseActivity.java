package com.example.shopping.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.alipay.sdk.app.EnvUtils;
import com.alipay.sdk.app.PayTask;
import com.bumptech.glide.Glide;
import com.example.shopping.R;
import com.example.shopping.alipay.AuthResult;
import com.example.shopping.alipay.PayResult;
import com.example.shopping.bean.RecyclerviewItemBean;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Map;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class PurchaseActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView textViewName;
    private TextView textViewPrice;

    private Button address;
    private Button submit;
    private ImageView commodityImage;
    private String url;
    private String name;
    private String price;
    private String imageUrl;

    private static final int SDK_PAY_FLAG = 1;
    private static final int SDK_AUTH_FLAG = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        EnvUtils.setEnv(EnvUtils.EnvEnum.SANDBOX);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase);

        initView();
        initData();

        address.setOnClickListener(this);
        submit.setOnClickListener(this);

    }

    private void initView(){
        address = (Button) findViewById(R.id.purchase_button_address);
        submit = (Button) findViewById(R.id.purchase_button_submit);
        textViewName = (TextView) findViewById(R.id.purchase_textview_name);
        textViewPrice = (TextView) findViewById(R.id.purchase_textview_price);
        commodityImage = (ImageView) findViewById(R.id.purchase_imageview_image);

        initAddress();
    }

    private void initAddress(){

        Intent intent = getIntent();
        String address = intent.getStringExtra("address");

    }
    private void initData(){

        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        price = intent.getStringExtra("price");
        imageUrl = intent.getStringExtra("url");

        textViewName.setText("名称                               " +name);
        textViewPrice.setText("价格                               " +price);
        System.out.println("---------------->数据" + imageUrl);
        Glide.with(PurchaseActivity.this).load(imageUrl).into(commodityImage);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.purchase_button_address:

                Intent intent = new Intent(PurchaseActivity.this,GettingMapActivity.class);
                startActivity(intent);
                /**
                 * 利用百度lbs，获取本地位置
                 */
            break;


            /**
             * 利用Alipay，完成订单支付
             */
            case  R.id.purchase_button_submit:
                initBil();

            default:
                break;
        }
    }

    /**
     * showAlert()方法用于提升输出结果；
     * @param ctx
     * @param info
     */
    private static void showAlert(Context ctx, String info) {
        showAlert(ctx, info, null);
    }

    private static void showAlert(Context ctx, String info, DialogInterface.OnDismissListener onDismiss) {
        new AlertDialog.Builder(ctx)
                .setMessage(info)
                .setPositiveButton(R.string.confirm, null)
                .setOnDismissListener(onDismiss)
                .show();
    }

    @SuppressLint("HandlerLeak")
    private Handler mHandler = new Handler() {
        @SuppressWarnings("unused")
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case SDK_PAY_FLAG: {
                    @SuppressWarnings("unchecked")
                    PayResult payResult = new PayResult((Map<String, String>) msg.obj);
                    /**
                     * 对于支付结果，请商户依赖服务端的异步通知结果。同步通知结果，仅作为支付结束的通知。
                     */
                    /**
                     * 付完成时，客户端返回的参数；在resultInfo中，同服务端一样，以map的方式存储；
                     */
                    String resultInfo = payResult.getResult();// 同步返回需要验证的信息
                    String resultStatus = payResult.getResultStatus();
                    // 判断resultStatus 为9000则代表支付成功
                    if (TextUtils.equals(resultStatus, "9000")) {
                        // 该笔订单是否真实支付成功，需要依赖服务端的异步通知。
                        //showAlert(PurchaseActivity.this, getString(R.string.pay_success) + payResult);
                        String pauResultData = payResult.getResult();
                        System.out.println("--------------->同步返回交易信息。" + pauResultData);
                        parseJSONPayResulting(pauResultData);
                    } else {
                        // 该笔订单真实的支付结果，需要依赖服务端的异步通知。
                        showAlert(PurchaseActivity.this, getString(R.string.pay_failed) + payResult);
                    }
                    break;
                }
                case SDK_AUTH_FLAG: {
                    @SuppressWarnings("unchecked")
                    AuthResult authResult = new AuthResult((Map<String, String>) msg.obj, true);
                    String resultStatus = authResult.getResultStatus();

                    // 判断resultStatus 为“9000”且result_code
                    // 为“200”则代表授权成功，具体状态码代表含义可参考授权接口文档
                    if (TextUtils.equals(resultStatus, "9000") && TextUtils.equals(authResult.getResultCode(), "200")) {
                        // 获取alipay_open_id，调支付时作为参数extern_token 的value
                        // 传入，则支付账户为该授权账户
                       showAlert(PurchaseActivity.this, getString(R.string.auth_success) + authResult);
                    } else {
                        // 其他状态值则为授权失败
                       showAlert(PurchaseActivity.this, getString(R.string.auth_failed) + authResult);
                    }
                    break;
                }
                default:
                    break;
            }
        };
    };

    /**
     * 支付宝支付业务示例
     */
    public void payV2(String orderInfo) {

        final Runnable payRunnable = new Runnable() {

            @Override
            public void run() {
                PayTask alipay = new PayTask(PurchaseActivity.this);
                Map<String, String> result = alipay.payV2(orderInfo, true);
                Log.i("msp", result.toString());

                Message msg = new Message();
                msg.what = SDK_PAY_FLAG;
                msg.obj = result;
                mHandler.sendMessage(msg);
            }
        };

        // 必须异步调用
        Thread payThread = new Thread(payRunnable);
        payThread.start();

        Intent intoDetail = new Intent(PurchaseActivity.this,BillDetailActivity.class);
        /**
         intoDetail.putExtra("out_trade_no",out_trade_no);
         intoDetail.putExtra("total_amount",total_amount);
         intoDetail.putExtra("time_stamp",time_stamp);
         */

        startActivity(intoDetail);
    }

    private void initBil(){

        new Thread(new Runnable() {
            @Override
            public void run() {

                try {

                    OkHttpClient client = new OkHttpClient();
                    RequestBody requestBody = new FormBody.Builder().build();
                    System.out.println("----->Pay 参数+"+name +"---------+" +price);

                    /**
                     * 注：此出处应修改为自己的支付宝回调URL
                     */
                    url = "http://9gqud7.natappfree.cc/pay/confirm?subject=";
                    Request request = new Request.Builder().url(url+ name + "&total=" + price).post(requestBody).build();
                    Response response = client.newCall(request).execute();
                    final String data = response.body().string();

                    System.out.println("-------------->回调订单SDK信息" + data);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            payV2(data);
                        }
                    });

                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        }).start();
    }

    String out_trade_no = null;
    String total_amount = null;
    String time_stamp = null;


    private void parseJSONPayResulting(String payResultData){

        try {
            JSONObject jsonObjectOne = new JSONObject(payResultData);

            for (int i = 0; i < jsonObjectOne.length(); i++){
                JSONObject jsonObject = (JSONObject) jsonObjectOne.get("alipay_trade_app_pay_response");

                 out_trade_no = jsonObject.getString("out_trade_no");
                 total_amount = jsonObject.getString("total_amount");
                 time_stamp = jsonObject.getString("timestamp");


                System.out.println("------------->回调订单信息" + out_trade_no + total_amount + time_stamp );

                SharedPreferences.Editor editor = getSharedPreferences("bill",MODE_PRIVATE).edit();
                editor.putString("out_trade_no",out_trade_no);
                editor.putString("total_amount",total_amount);
                editor.putString("time_stamp",time_stamp);
                editor.commit();

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }


}