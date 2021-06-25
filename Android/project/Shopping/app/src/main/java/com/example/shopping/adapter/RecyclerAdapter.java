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
import com.example.shopping.activity.DetailActivity;
import com.example.shopping.bean.RecyclerviewItemBean;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private List<RecyclerviewItemBean> mRecyclerViewItemBeanList;
    private Context context;

    // Inner class and use for getting RecyclerView' items.
    static class ViewHolder extends RecyclerView.ViewHolder {
        View recyclerView;
        ImageView recyclerViewImageItem;
        TextView recyclerViewTextItem;

        public ViewHolder(View itemView) {
            super(itemView);
            recyclerView = itemView;
            recyclerViewImageItem = itemView.findViewById(R.id.recycleViewItem_image);
            recyclerViewTextItem = itemView.findViewById(R.id.recycleViewItem_text);
        }
    }

    public RecyclerAdapter(List<RecyclerviewItemBean> recyclerViewItemBeanList, Context context){
        mRecyclerViewItemBeanList = recyclerViewItemBeanList;
        this.context = context;

    }

    @Override
    public ViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item,parent,false);
        final ViewHolder holder = new ViewHolder(itemView);

        holder.recyclerViewImageItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                RecyclerviewItemBean itemBean = mRecyclerViewItemBeanList.get(position);

                Intent sendIntent = new Intent(context, DetailActivity.class);
                sendIntent.putExtra("detail_id",itemBean.getId());

                context.startActivity(sendIntent);
            }
        });

        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        RecyclerviewItemBean itemBean = mRecyclerViewItemBeanList.get(position);
        holder.recyclerViewTextItem.setText(itemBean.getName());
        Glide.with(context).load(itemBean.getImageURL()).into(holder.recyclerViewImageItem);
        //holder.recyclerViewImageItem.setImageResource(Integer.parseInt(itemBean.getId()));
    }


    @Override
    public int getItemCount() {
        return mRecyclerViewItemBeanList.size();
    }
}
