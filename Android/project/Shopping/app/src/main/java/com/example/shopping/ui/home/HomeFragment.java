package com.example.shopping.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shopping.R;
import com.example.shopping.adapter.RecyclerAdapter;
import com.example.shopping.adapter.ShopCartAdapter;
import com.example.shopping.bean.RecyclerviewItemBean;
import com.example.shopping.bean.ShopCartBean;
import com.example.shopping.databinding.FragmentHomeBinding;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class HomeFragment extends Fragment {


    private List<ShopCartBean> shopCartBeansList = new ArrayList<>();
    private RecyclerView recyclerView;
    private String url;
    private FragmentHomeBinding binding;

    private void getCommodityInformation(){
        new Thread(new Runnable() {
            @Override
            public void run() {

                try {

                    OkHttpClient client = new OkHttpClient();
                    RequestBody requestBody = new FormBody.Builder().build();

                    System.out.println("------------->");
                    url = getResources().getString(R.string.server_url) + "findallsavelist";
                    Request request = new Request.Builder().url(url).post(requestBody).build();
                    Response response = client.newCall(request).execute();
                    String data = response.body().string();
                    System.out.println("----------------->数据" + data);
                    parserData(data);

                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        }).start();

    }

    private void parserData(final String getData){
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                try{
                    JSONArray jsonArray = new JSONArray(getData);
                    for (int i = 0; i < jsonArray.length(); i++){
                        JSONObject jsonObject = jsonArray.getJSONObject(i);

                        String id = jsonObject.getString("id");
                        String name = jsonObject.getString("name");
                        String price = jsonObject.getString("price");
                        String ImageUrl = jsonObject.getString("url");
                        // 应在此处，设置ImageWeb的路径；
                        shopCartBeansList.add(new ShopCartBean(ImageUrl,name,price,id));
                    }

                    ShopCartAdapter shopCartAdapter = new ShopCartAdapter(shopCartBeansList,getActivity());
                    recyclerView.setAdapter(shopCartAdapter);


                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        recyclerView = root.findViewById(R.id.recycleViewShopCart);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        getCommodityInformation();

        ShopCartAdapter adapter = new ShopCartAdapter(shopCartBeansList,getActivity());
        recyclerView.setAdapter(adapter);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}