package com.example.shopping.ui.dashboard;

import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.shopping.R;
import com.example.shopping.adapter.RecyclerAdapter;
import com.example.shopping.bean.RecyclerviewItemBean;
import com.example.shopping.databinding.FragmentDashboardBinding;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class DashboardFragment extends Fragment {

    private List<RecyclerviewItemBean> recyclerviewItemBeansList = new ArrayList<>();
    private RecyclerView recyclerView;
    private String url;
    private FragmentDashboardBinding binding;

    private EditText searchEditTextBar;
    private Button searchButtonBar;

    private void getCommodityInformation(){
        new Thread(new Runnable() {
            @Override
            public void run() {

                try {

                    OkHttpClient client = new OkHttpClient();
                    RequestBody requestBody = new FormBody.Builder().build();

                    System.out.println("------------->");
                    url = getResources().getString(R.string.server_url) + "findImage";
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
                        String ImageUrl = jsonObject.getString("url");
                        // 应在此处，设置ImageWeb的路径；
                        recyclerviewItemBeansList.add(new RecyclerviewItemBean("http://ipp.natapp1.cc/" +ImageUrl, name, id));
                    }
                    RecyclerAdapter adapter = new RecyclerAdapter(recyclerviewItemBeansList, getActivity());
                    recyclerView.setAdapter(adapter);


                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

    }
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();



        /**
         *
         searchEditTextBar = (EditText) getActivity().findViewById(R.id.search_edit_editView);
         searchButtonBar = (Button) getActivity().findViewById(R.id.search_edit_button);
         searchButtonBar.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
        String editText = searchEditTextBar.getText().toString();

        Toast.makeText(getActivity(),"The Content is:"+ editText,Toast.LENGTH_SHORT).show();
        }
        });
         */

        recyclerView = root.findViewById(R.id.recycleViewMainCenter);
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        getCommodityInformation();

        RecyclerAdapter recyclerAdapter = new RecyclerAdapter(recyclerviewItemBeansList,getActivity());
        recyclerView.setAdapter(recyclerAdapter);


        return root;
    }




    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}