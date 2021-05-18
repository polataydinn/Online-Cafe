package com.example.online_cafe;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.online_cafe.CONST;
import com.example.online_cafe.R;
import com.example.online_cafe.authentication.Authentication;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {
    private Button registerButton;
    private EditText nameSurnameEditText;
    private EditText usernameEditText;
    private EditText passwordEditText;
    private String nameSurname;
    private String username;
    private String password;
    FirebaseDatabase rootNode;
    private Boolean returnValue = true;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        registerButton = findViewById(R.id.rRegister_button);
        nameSurnameEditText = findViewById(R.id.rName_surname_area);
        usernameEditText = findViewById(R.id.rUsername_area);
        passwordEditText = findViewById(R.id.rPassword_area);
        FirebaseApp.initializeApp(getApplicationContext());

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(CONST.userType == "garson"){
                    register("waiter");
                }else{
                    register("customer");
                }
            }

            private void register(String path) {
                nameSurname = nameSurnameEditText.getText().toString();
                username = usernameEditText.getText().toString();
                password = passwordEditText.getText().toString();
                Authentication user = new Authentication(nameSurname, username, password);

                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference(path);
                reference.child(username).setValue(user);
                Toast.makeText(getApplicationContext(), "Kullanıcı Başarıyla Oluşturuldu", Toast.LENGTH_SHORT).show();
            }
        });


    }


}