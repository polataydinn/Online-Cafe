package com.example.online_cafe;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.budiyev.android.codescanner.CodeScanner;
import com.budiyev.android.codescanner.CodeScannerView;
import com.example.online_cafe.products.CategoryFragment;

public class WaiterActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waiter);
        WaiterMainFragment fragment = new WaiterMainFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.frame_layout_container, fragment)
                .addToBackStack(CategoryFragment.class.getSimpleName())
                .commit();
    }
}