package com.example.online_cafe.products;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.online_cafe.R;
import com.example.online_cafe.adapter.ProductAdapter;

import java.util.Collections;
import java.util.List;


public class ProductListFragment extends Fragment {
    List<ProductData> list = Collections.emptyList();

    public ProductListFragment(List<ProductData> data) {
        this.list = data;
    }

    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return LayoutInflater.from(container.getContext()).inflate(R.layout.fragment_product, container, false);
    }

    @Override
    public void onViewCreated( View view, Bundle savedInstanceState) {
        RecyclerView recyclerView = view.findViewById(R.id.product_items);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(new ProductAdapter(list));
    }

}
