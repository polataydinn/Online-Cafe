package com.example.online_cafe;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.online_cafe.adapter.WaiterOrderAdapter;
import com.example.online_cafe.mapper.ProductDataMapper;
import com.example.online_cafe.products.ProductData;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;


public class ResultOrdersFragment extends Fragment {
    private TextView userNameText;
    private TextView totalAmount;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_result_orders, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        userNameText = view.findViewById(R.id.waiter_user_name);
        totalAmount = view.findViewById(R.id.price_will_pay);

        super.onViewCreated(view, savedInstanceState);

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("orders/" + CONST.qrResult + "/order");
        reference.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(Task<DataSnapshot> task) {
                if (task.isSuccessful()) {
                    ArrayList<ProductData> orderList = new ArrayList<>();
                    ArrayList<HashMap<String, Object>> map = task.getResult().getValue(new GenericTypeIndicator<ArrayList<HashMap<String, Object>>>() {
                    });
                    for (HashMap<String, Object> stringObjectHashMap : map) {
                        orderList.add(ProductDataMapper.mapToModel(stringObjectHashMap));

                    }
                    orderList.size();
                    CONST.orderListToFinish.addAll(orderList);
                    RecyclerView recyclerView = view.findViewById(R.id.result_order_rv);
                    recyclerView.setHasFixedSize(true);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
                    recyclerView.setAdapter(new WaiterOrderAdapter(CONST.orderListToFinish));

                }
            }
        });

        DatabaseReference totalAmountReferance = FirebaseDatabase.getInstance().getReference("orders/" + CONST.qrResult + "/user/totalAmount");
        totalAmountReferance.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull @NotNull Task<DataSnapshot> task) {
                if (task.isSuccessful()) {
                    CONST.waiterTotalAmount = task.getResult().getValue(Long.class);
                    totalAmount.setText(CONST.waiterTotalAmount.toString());
                }
            }
        });

        DatabaseReference userNameReferance = FirebaseDatabase.getInstance().getReference("orders/" + CONST.qrResult + "/user/userNameAndSurname");
        userNameReferance.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull @NotNull Task<DataSnapshot> task) {
                if (task.isSuccessful()) {
                    CONST.customerUserName = task.getResult().getValue(String.class);
                    userNameText.setText("Müşteri, " + CONST.customerUserName);
                }
            }
        });

    }
}



