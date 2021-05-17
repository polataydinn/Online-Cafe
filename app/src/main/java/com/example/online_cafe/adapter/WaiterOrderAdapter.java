package com.example.online_cafe.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.online_cafe.R;
import com.example.online_cafe.products.ProductData;


import java.util.Collections;
import java.util.List;

public class WaiterOrderAdapter extends RecyclerView.Adapter<WaiterOrderAdapter.ViewHolder>{
    List<ProductData> list = Collections.emptyList();

    public WaiterOrderAdapter(List<ProductData> list) {
        this.list = list;
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.product_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(WaiterOrderAdapter.ViewHolder holder, int position) {
        holder.productPrice.setText(list.get(position).productPrice + " TL");
        holder.productImage.setImageResource(list.get(position).productPicturePath);
        holder.productName.setText(list.get(position).productName);
    }



    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView productName;
        ImageView productImage;
        TextView productPrice;

        public ViewHolder( View itemView) {
            super(itemView);
            productName = itemView.findViewById(R.id.product_name);
            productImage = itemView.findViewById(R.id.product_image);
            productPrice = itemView.findViewById(R.id.product_price);
        }
    }
}
