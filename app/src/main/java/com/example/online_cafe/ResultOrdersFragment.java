package com.example.online_cafe;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.online_cafe.mapper.ProductDataMapper;
import com.example.online_cafe.mapper.UserPaymentDataMapper;
import com.example.online_cafe.products.ProductData;
import com.example.online_cafe.products.UserPaymentDataClass;
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_result_orders, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("orders/" +CONST.qrResult +"/order");

        reference.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull @NotNull Task<DataSnapshot> task) {
                if (task.isSuccessful()) {
                    ArrayList<ProductData> orderList = new ArrayList<>();
                    ArrayList<HashMap<String, Object>> map = task.getResult().getValue(new GenericTypeIndicator<ArrayList<HashMap<String, Object>>>() {
                    });
                    for (HashMap<String, Object> stringObjectHashMap : map) {
                        orderList.add(ProductDataMapper.mapToModel(stringObjectHashMap));

                    }
                    orderList.size();
                    CONST.orderListToFinish.addAll(orderList);
                    System.out.println("");
                }
            }
        });

        DatabaseReference userInfoReferance = FirebaseDatabase.getInstance().getReference("orders/" + CONST.qrResult + "/user");

        userInfoReferance.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull @NotNull Task<DataSnapshot> task) {
                if (task.isSuccessful()){
                    ArrayList<UserPaymentDataClass> listOfUser = new ArrayList<>();
                    ArrayList<HashMap<String,Object>> map = task.getResult().getValue(new GenericTypeIndicator<ArrayList<HashMap<String, Object>>>() {
                    });

                    for (HashMap <String, Object> stringObjectHashMap : map){
                        listOfUser.add(UserPaymentDataMapper.mapToModel(stringObjectHashMap));
                    }
                    listOfUser.size();
                    CONST.userListToFinish.addAll(listOfUser);
                    System.out.println("");
                }
            }
        });
    }

}

