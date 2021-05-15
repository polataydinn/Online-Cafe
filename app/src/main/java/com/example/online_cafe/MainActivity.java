package com.example.online_cafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button customerButton;
    private Button waiterButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        customerButton = findViewById(R.id.customer_button);
        waiterButton = findViewById(R.id.waiter_button);

        customerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CONST.userType = "musteri";
                startNewActivity();
            }
        });

        waiterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CONST.userType = "garson";
                startNewActivity();
            }
        });
    }

    private void startNewActivity(){
        AuthenticationActivity aa = new AuthenticationActivity();
        Intent intent = new Intent(getApplicationContext(),aa.getClass());
        startActivity(intent);
    }
}

