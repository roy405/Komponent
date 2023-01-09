package com.example.mobilekomponent.Adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.mobilekomponent.Activities.ProductDetail;
import com.example.mobilekomponent.R;
import com.example.mobilekomponent.models.Product;
import com.google.gson.Gson;

import java.io.Serializable;
import java.util.ArrayList;

import androidx.recyclerview.widget.RecyclerView;

public class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.RequestViewHolder> {

    private ArrayList<Product> items = new ArrayList<>();

    Context mContext;

    public ProductListAdapter(Context mContext,ArrayList<Product> items)
    {
        this.mContext=mContext;
        this.items=items;
    }


    @Override
    public RequestViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.item_grid, null);
        RecyclerView.LayoutParams lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(lp);
        RequestViewHolder viewHolder = new RequestViewHolder(view);

        return new RequestViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RequestViewHolder holder, int position)
    {
        final Product product=items.get(position);


        String name=product.getName();

        String imageLink=product.getScaledImage();


        holder.grid_name.setText(name);

        Glide.with(mContext)
                .asBitmap()
                .load(imageLink)
                .into(holder.imageView);


        holder.item_grid_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Integer productId = product.getId();

                Gson gson = new Gson();

                String current_product=gson.toJson(product);

                Intent intent = new Intent(mContext, ProductDetail.class);

                intent.putExtra("current_product", current_product);

                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                mContext.startActivity(intent);



            }
        });

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class RequestViewHolder extends RecyclerView.ViewHolder
    {


        public View vm;

        TextView grid_name;
        ImageView imageView;
        LinearLayout item_grid_layout;

        public RequestViewHolder(View itemView)
        {
            super(itemView);

            grid_name =itemView.findViewById(R.id.grid_name);

            imageView =itemView.findViewById(R.id.grid_image);

            item_grid_layout =itemView.findViewById(R.id.item_grid_layout);



        }

    }
}