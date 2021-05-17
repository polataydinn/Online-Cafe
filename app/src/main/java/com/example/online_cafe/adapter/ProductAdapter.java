package com.example.online_cafe.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.online_cafe.CONST;
import com.example.online_cafe.R;
import com.example.online_cafe.products.ProductData;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {
    private View.OnClickListener mListener;
    List<ProductData> list = Collections.emptyList();
    public ProductAdapter(List<ProductData> data, View.OnClickListener listener){
        this.list = data;
        this.mListener = listener;
    }

    public ProductAdapter(ArrayList<ProductData> orderListToFinish) {
        this.list = orderListToFinish;
    }


    @Override
    public ProductAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.product_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductAdapter.ViewHolder holder, int position) {
        holder.itemView.getRootView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.productCheckBox
                        .setChecked(!holder.productCheckBox.isChecked());
                if(holder.productCheckBox.isChecked()){
                    CONST.totalAmount = CONST.totalAmount + list.get(position).productPrice;
                    CONST.listOfOrders.add(list.get(position));
                }else{
                    CONST.totalAmount = CONST.totalAmount -list.get(position).productPrice;
                }
                mListener.onClick(v);
            }
        });
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
        CheckBox productCheckBox;

        public ViewHolder( View itemView) {
            super(itemView);
            productName = itemView.findViewById(R.id.product_name);
            productImage = itemView.findViewById(R.id.product_image);
            productPrice = itemView.findViewById(R.id.product_price);
            productCheckBox = itemView.findViewById(R.id.product_check_box);
        }
    }
}
