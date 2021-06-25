package com.example.shopping.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.shopping.R;
import com.example.shopping.bean.ShopCartBean;

import java.util.List;



public class ShopCartAdapter extends RecyclerView.Adapter<ShopCartAdapter.ViewHolder> {

    private List<ShopCartBean> mShopCartBeansList;
    private Context context;

    // Inner class and use for getting RecyclerView' items.
    static class ViewHolder extends RecyclerView.ViewHolder {
        View recyclerView;
        ImageView shopCartImageViewItem;
        TextView shopCartTextViewNameItem;
        TextView shopCartTextViewPriceItem;

        public ViewHolder(View itemView) {
            super(itemView);
            recyclerView = itemView;
            shopCartImageViewItem = itemView.findViewById(R.id.shopCarItem_image);
            shopCartTextViewNameItem = itemView.findViewById(R.id.shopCarItem_name);
            shopCartTextViewPriceItem = itemView.findViewById(R.id.shopCarItem_price);
        }
    }

    public ShopCartAdapter(List<ShopCartBean> shopCartBeanList, Context context){
        mShopCartBeansList = shopCartBeanList;
        this.context = context;

    }

    @Override
    public ViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.shaopcarview_item,parent,false);
        final ViewHolder holder = new ViewHolder(itemView);
        return holder;

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ShopCartBean shopCartBean = mShopCartBeansList.get(position);
        holder.shopCartTextViewNameItem.setText(shopCartBean.getName());
        holder.shopCartTextViewPriceItem.setText(shopCartBean.getPrice());
        Glide.with(context).load(shopCartBean.getImageURL()).into(holder.shopCartImageViewItem);
    }


    @Override
    public int getItemCount() {
        return mShopCartBeansList.size();
    }
}
