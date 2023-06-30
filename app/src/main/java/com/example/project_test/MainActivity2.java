package com.example.project_test;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import io.github.muddz.styleabletoast.StyleableToast;

public class MainActivity2 extends AppCompatActivity {
    private FirebaseAuth auth;
    private EditText loginemail, loginpw;
    Button lgbutton;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        auth = FirebaseAuth.getInstance();

        lgbutton = findViewById(R.id.login_btn);
        loginemail= findViewById(R.id.email);
        loginpw = findViewById(R.id.PW);

        button = findViewById(R.id.signup_btn);

        lgbutton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                String email = loginemail.getText().toString();
                String pass = loginpw.getText().toString();

                if (!email.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                    if(!pass.isEmpty()){
                        auth.signInWithEmailAndPassword(email,pass)
                                .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                                    @Override
                                    public void onSuccess(AuthResult authResult) {
                                        StyleableToast.makeText(getApplicationContext(), "Login Successful", Toast.LENGTH_LONG, R.style.mytoast).show();
                                        startActivity(new Intent(getApplicationContext(),MainActivity5.class));
                                        finish();
                                    }
                                }).addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        StyleableToast.makeText(getApplicationContext(), "Login Failed", Toast.LENGTH_LONG, R.style.mytoast).show();
                                    }
                                });
                    }else{
                        loginpw.setError("Password Can not be Empty");
                    }
                } else if (email.isEmpty()) {
                    loginemail.setError("Email Can not be Empty");
                }else{
                    loginemail.setError("Please enter the valid email");
                }
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iPtnt = new Intent(getApplicationContext(), MainActivity3.class);
                startActivity(iPtnt);
            }
        });
    }
}