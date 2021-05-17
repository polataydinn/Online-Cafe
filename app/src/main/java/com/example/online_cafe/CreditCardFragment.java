package com.example.online_cafe;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class CreditCardFragment extends Fragment {
    private Button confirmButton;
    private TextView onSuccessText;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_credit_card, container, false);

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        confirmButton = view.findViewById(R.id.confirm_credit_card_button);
        onSuccessText = view.findViewById(R.id.success_textView);

        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onSuccessText.setText("Ödeme Başarılı");
            }
        });

    }
}