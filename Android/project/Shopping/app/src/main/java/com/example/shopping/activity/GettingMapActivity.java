package com.example.shopping.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.example.shopping.R;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GettingMapActivity extends AppCompatActivity implements View.OnClickListener {

    private LocationClient mLocationClient;
    private EditText editTextPosition;
    private Button savePosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        mLocationClient = new LocationClient(getApplicationContext());
        mLocationClient.registerLocationListener(new MyLocationListener());
        setContentView(R.layout.activity_getting_map);



        editTextPosition = (EditText) findViewById(R.id.position_edittext_view);
        savePosition = (Button) findViewById(R.id.position_button_save);

        savePosition.setOnClickListener(this);

        List<String> permissionList = new ArrayList<>();

        if (ContextCompat.checkSelfPermission(GettingMapActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED){

            permissionList.add(Manifest.permission.ACCESS_FINE_LOCATION);
        }

        if (ContextCompat.checkSelfPermission(GettingMapActivity.this,Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED){

            permissionList.add(Manifest.permission.READ_PHONE_STATE);
        }

        if (ContextCompat.checkSelfPermission(GettingMapActivity.this,Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){

            permissionList.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
        }

        if (!permissionList.isEmpty()){

            String[] permissions = permissionList.toArray(new String[permissionList.size()]);
            ActivityCompat.requestPermissions(GettingMapActivity.this,permissions,1);
        }else {
            requestLocation();
        }
    }

    private void requestLocation(){
        initLocation();
        mLocationClient.start();
    }

    private void initLocation(){

        LocationClientOption option = new LocationClientOption();
        option.setScanSpan(5000);
        option.setIsNeedAddress(true);
        //  option.setLocationMode(LocationClientOption.LocationMode.Device_Sensors);
        mLocationClient.setLocOption(option);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mLocationClient.stop();

    }

    /**
     * 权限判断
     * @param requestCode
     * @param permissions
     * @param grantResults
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        switch (requestCode){
            case 1:
                if (grantResults.length > 0){
                    for (int result: grantResults){
                        if (result != PackageManager.PERMISSION_GRANTED){

                            Toast.makeText(this,"需同意所有权限才能使用本程序。",Toast.LENGTH_SHORT).show();
                            finish();
                            return;
                        }
                    }

                }else {
                    Toast.makeText(this,"发生未知错误。",Toast.LENGTH_SHORT).show();
                    finish();
                }
                break;
            default:
        }
    }

    private String userAddress = null;

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.position_button_save:

                Intent intent = new Intent();
                userAddress = editTextPosition.getText().toString();

                SharedPreferences.Editor editor = getSharedPreferences("Address",MODE_PRIVATE).edit();
                editor.putString("Address",userAddress);
                editor.commit();

                Toast.makeText(GettingMapActivity.this,"地址保存成功",Toast.LENGTH_SHORT).show();
                break;

            default:
                break;
        }
    }

    /**
     * 获取位置。
     */

    private static StringBuilder currentPosition = new StringBuilder();

    public class MyLocationListener implements BDLocationListener {

        @Override
        public void onReceiveLocation(BDLocation bdLocation) {


            /**
             currentPosition.append("维度：").append(bdLocation.getLatitude()).append("\n");
             currentPosition.append("径度：").append(bdLocation.getLongitude()).append("\n");
             currentPosition.append("定位方式：");

             */


            currentPosition.append("国家：").append(bdLocation.getCountry()).append("\n");
            currentPosition.append("省：").append(bdLocation.getProvince()).append("\n");
            currentPosition.append("市：").append(bdLocation.getCity()).append("\n");
            currentPosition.append("区：").append(bdLocation.getDistrict()).append("\n");
            currentPosition.append("街道：").append(bdLocation.getStreet()).append("\n");


            if (bdLocation.getLocType() == BDLocation.TypeGpsLocation){
                currentPosition.append("GPS");
            }else if (bdLocation.getLocType() == BDLocation.TypeNetWorkLocation){
                currentPosition.append("网络");
            }

            editTextPosition.setText(currentPosition);

            mLocationClient.stop();

        }

    }
}