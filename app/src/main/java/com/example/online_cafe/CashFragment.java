package com.example.online_cafe;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.SparseLongArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;


public class CashFragment extends Fragment {
    private EditText enteredCash;
    private Button calculate;
    private Long myCash;
    private Long totalCash;
    private TextView changeMoney;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_cash, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        changeMoney = view.findViewById(R.id.change_money);
        enteredCash = view.findViewById(R.id.money_entered);
        calculate = view.findViewById(R.id.calculate_button);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myCash = Long.parseLong(String.valueOf(enteredCash.getText().toString()));
                totalCash = myCash - CONST.totalAmount;
                if(totalCash> 0){
                    changeMoney.setText("Para Üstü : " +totalCash + " TL");
                }else{
                    changeMoney.setText("Yetersiz Bakiye");
                }
            }
        });


    }
}