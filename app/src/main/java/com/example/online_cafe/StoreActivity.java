package com.example.online_cafe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.online_cafe.products.CategoryFragment;

public class StoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);
        CategoryFragment fragment = new CategoryFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragmentContainer,fragment)
                .addToBackStack(CategoryFragment.class.getSimpleName())
                .commit();
    }

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() == 1){
            finish();
        }else{
            super.onBackPressed();
        }
    }
}