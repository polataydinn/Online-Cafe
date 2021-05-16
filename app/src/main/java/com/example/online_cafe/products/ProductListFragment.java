package com.example.online_cafe.products;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.online_cafe.CONST;
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
        if(CONST.isProductSelected){
            return LayoutInflater.from(container.getContext()).inflate(R.layout.fragment_total_product, container, false);
        }
        else{
            return LayoutInflater.from(container.getContext()).inflate(R.layout.fragment_product, container, false);
        }
    }

    @Override
    public void onViewCreated( View view, Bundle savedInstanceState) {
        if(CONST.isProductSelected){
            Button confirmButton;
            confirmButton = view.findViewById(R.id.confirm_all_button);

            confirmButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startFragment();
                    Toast.makeText(getContext(),"Ben çalışıyorum",Toast.LENGTH_SHORT).show();
                }
            });
        }
        CONST.isProductSelected = false;
        RecyclerView recyclerView = view.findViewById(R.id.product_items);
        TextView totalPrice = view.findViewById(R.id.total_price);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(new ProductAdapter(list, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                totalPrice.setText("Toplam " + CONST.totalAmount + " TL");
            }
        }));


    }

    private void startFragment() {
        ProductPayment productPayment = new ProductPayment();
        getActivity()
                .getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentContainer,productPayment, "FragmentReplaced")
                .addToBackStack(null)
                .commit();

    }

}
