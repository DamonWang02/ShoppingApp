package com.example.shopping.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.shopping.R;

public class BillDetailActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView billId;
    private TextView billAmount;
    private TextView billTime;

    private Button backMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill_detail);
        initView();
        initData();

        backMenu.setOnClickListener(this);

    }

    private void initView(){

        billId = (TextView) findViewById(R.id.bill_testview_id_two);
        billAmount = (TextView) findViewById(R.id.bill_testview_amount_two);
        billTime = (TextView) findViewById(R.id.bill_testview_time_two);

        backMenu = (Button) findViewById(R.id.bill_button_back);
    }

    private void initData(){

        SharedPreferences preferences = getSharedPreferences("bill",MODE_PRIVATE);
        String out_trade_no = preferences.getString("out_trade_no",null);
        String total_amount = preferences.getString("total_amount",null);
        String time_stamp = preferences.getString("time_stamp",null);

        billId.setText(out_trade_no);
        billAmount.setText(total_amount);
        billTime.setText(time_stamp);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.bill_button_back:

                finish();
            break;
            default:
                break;
        }
    }
}