package com.example.online_cafe;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

public class AuthenticationActivity extends AppCompatActivity {
    private Button loginButton;
    private TextView registerText;
    private TextView welcomeText;
    private EditText usernameEditText;
    private EditText passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentication);
        loginButton = findViewById(R.id.lLogin_button);
        welcomeText = findViewById(R.id.lWelcome_text);
        usernameEditText = findViewById(R.id.lUsername_area);
        passwordEditText = findViewById(R.id.lPassword_area);

        if (CONST.userType == "musteri") {
            welcomeText.setText(R.string.welcome_customer);
            loginButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    login("customer");
                }
            });


        } else if (CONST.userType == "garson") {
            welcomeText.setText(R.string.welcome_waiter);
            loginButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    login("waiter");
                }
            });
        }

        registerText = findViewById(R.id.lRegister_text);
        registerText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(intent);
            }
        });
    }

    private void login(String path) {
        final String userEnteredUsername =  usernameEditText.getText().toString().trim();
        final String userEnteredPassword = passwordEditText.getText().toString().trim();
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference(path);
        Query checkEMail = reference.orderByChild("username").equalTo(userEnteredUsername);
        checkEMail.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    String passwordDB = snapshot.child(userEnteredUsername).child("password").getValue(String.class);

                    if (passwordDB.equals(userEnteredPassword)) {
                        Toast.makeText(getApplicationContext(), "Giriş Başarılı", Toast.LENGTH_SHORT).show();
                        if(CONST.userType == "musteri"){
                            Intent intentStore = new Intent(getApplicationContext(),StoreActivity.class);
                            startActivity(intentStore);
                        }
                        else{
                            Intent intentWaiter = new Intent(getApplicationContext(),WaiterActivity.class);
                            startActivity(intentWaiter);
                        }
                    }else{
                        Toast.makeText(getApplicationContext(),"Kullanıcı Adı yada Şifre Hatalı",Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(getApplicationContext(),"Kullanıcı Adı yada Şifre Hatalı",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {

            }
        });
    }
}