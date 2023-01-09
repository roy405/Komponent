package com.example.mobilekomponent.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.mobilekomponent.R;
import com.example.mobilekomponent.models.Product;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.RequestViewHolder> {

    private ArrayList<Product> items = new ArrayList<>();

    Context mContext;

    public CartAdapter(Context mContext,ArrayList<Product> items)
    {
        this.mContext=mContext;
        this.items=items;
    }


    @Override
    public RequestViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.cart_item_grid, null);
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

        String price= Double.toString(product.getPrice());

        String quantity = Integer.toString(product.getQuantity());

        String imageLink=product.getScaledImage();

        holder.grid_name.setText(name);
        holder.grid_quantity.setText(quantity);
        holder.grid_price.setText(price);

        Glide.with(mContext)
                .asBitmap()
                .load(imageLink)
                .into(holder.imageView);



    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class RequestViewHolder extends RecyclerView.ViewHolder
    {

        public View vm;

        TextView grid_name;
        TextView grid_quantity;
        TextView grid_price;
        ImageView imageView;
        LinearLayout cart_item_layout;

        public RequestViewHolder(View itemView)
        {
            super(itemView);

            grid_name =itemView.findViewById(R.id.cartProductName);

            grid_quantity=itemView.findViewById(R.id.cartProductQuantity);

            grid_price =itemView.findViewById(R.id.cartProductPrice);

            imageView =itemView.findViewById(R.id.cartProductImage);

            cart_item_layout =itemView.findViewById(R.id.cart_item_layout);



        }

    }
}
