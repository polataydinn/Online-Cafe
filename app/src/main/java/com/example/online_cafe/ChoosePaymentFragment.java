package com.example.online_cafe;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class ChoosePaymentFragment extends Fragment {
    Button creditCard;
    Button cash;
    TextView totalDebt;
    DatabaseReference reference;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_choose_payment, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        creditCard = view.findViewById(R.id.credit_card_button);
        cash = view.findViewById(R.id.cash_button);
        totalDebt = view.findViewById(R.id.final_payment_amount);

        totalDebt.setText("Toplam Borcunuz : " + CONST.totalAmount + " TL");

        reference = FirebaseDatabase.getInstance().getReference( "orders/" + CONST.qrResult);
        HashMap hashMap = new HashMap();
        hashMap.put("qrRead",false);
        reference.child(CONST.UUID).child("/user").updateChildren(hashMap);

        creditCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CreditCardFragment creditCardFragment = new CreditCardFragment();
                startFragment(creditCardFragment);
            }
        });

        cash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CashFragment cashFragment = new CashFragment();
                startFragment(cashFragment);
            }
        });
    }

    private void startFragment(Fragment fragment) {
        getActivity()
                .getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentContainer, fragment, "FragmentReplaced")
                .addToBackStack(null)
                .commit();

    }
}