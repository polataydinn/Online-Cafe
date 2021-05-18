package com.example.online_cafe;

import android.Manifest;

import android.content.pm.PackageManager;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.budiyev.android.codescanner.CodeScanner;
import com.budiyev.android.codescanner.CodeScannerView;
import com.budiyev.android.codescanner.DecodeCallback;
import com.example.online_cafe.products.UserPaymentDataClass;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.zxing.Result;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

public class WaiterMainFragment extends Fragment {
    CodeScanner codeScanner;
    CodeScannerView codeScannerView;
    DatabaseReference reference;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_waiter_main, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        codeScannerView = view.findViewById(R.id.qr_scanner);
        codeScanner = new CodeScanner(getContext(), codeScannerView);

        codeScanner.setDecodeCallback(new DecodeCallback() {
            @Override
            public void onDecoded(Result result) {
                CONST.qrResult = result.getText();

                reference = FirebaseDatabase.getInstance().getReference( "orders/" + CONST.qrResult);
                HashMap hashMap = new HashMap();
                hashMap.put("qrRead",true);
                reference.child(CONST.UUID).child("/user").updateChildren(hashMap);

                ResultOrdersFragment fragment = new ResultOrdersFragment();
                getActivity()
                        .getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frame_layout_container,fragment, "FragmentReplaced")
                        .addToBackStack(null)
                        .commit();
            }
        });


    }



    @Override
    public void onResume() {
        super.onResume();
        codeScanner.startPreview();
    }
}