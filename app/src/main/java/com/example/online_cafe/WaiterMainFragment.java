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
import com.google.zxing.Result;

import org.jetbrains.annotations.NotNull;

public class WaiterMainFragment extends Fragment {
    CodeScanner codeScanner;
    CodeScannerView codeScannerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_waiter_main, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupPermissions();
        codeScannerView = view.findViewById(R.id.qr_scanner);
        codeScanner = new CodeScanner(getContext(), codeScannerView);

        codeScanner.setDecodeCallback(new DecodeCallback() {
            @Override
            public void onDecoded(@NonNull @NotNull Result result) {
                CONST.qrResult = result.getText();
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

    private void setupPermissions(){
        int perm = ContextCompat.checkSelfPermission(getContext(), Manifest.permission.CAMERA);
        if (perm != PackageManager.PERMISSION_GRANTED){
            makeRequest();
        }

    }

    private void makeRequest() {
        String[] perm = {Manifest.permission.CAMERA};
        ActivityCompat.requestPermissions(getActivity(), perm, 111);

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull @NotNull String[] permissions, @NonNull @NotNull int[] grantResults) {
        if (requestCode == 111){
            if (grantResults[0] != PackageManager.PERMISSION_GRANTED){
                Toast.makeText(getContext(), "Kameraya izin vermelisin", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        codeScanner.startPreview();
    }
}