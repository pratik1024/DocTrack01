package com.example.project_test;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import io.github.muddz.styleabletoast.StyleableToast;

public class MainActivity3 extends AppCompatActivity {
    private FirebaseAuth auth ;
    private EditText signupemail, signuppw;
    EditText name,phone,at,postal_pin;
 Button button;
    String email_txt;
    String pw_txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        button = findViewById(R.id.next_btn);
        signupemail = findViewById(R.id.email_id);
        signuppw= findViewById(R.id.PW);
        name = findViewById(R.id.ID);
        phone=findViewById(R.id.PHN);
        at = findViewById(R.id.at_);
        postal_pin=findViewById(R.id.post_);
        auth = FirebaseAuth.getInstance();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = signupemail.getText().toString().trim();
                String pass = signuppw.getText().toString().trim();
                if(user.isEmpty()){
                    signupemail.setError("Email can't be empty");
                }
                if ( pass.isEmpty()){
                    signuppw.getText().toString().trim();
                }
                else {
                    auth.createUserWithEmailAndPassword(user,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if( task.isSuccessful()){
                                StyleableToast.makeText(MainActivity3.this, "Dataset Updated", Toast.LENGTH_LONG, R.style.mytoast).show();
                                startActivity(new Intent(MainActivity3.this,MainActivity4.class));
                            }
                            else {
                                StyleableToast.makeText(MainActivity3.this, "Dataset Updated Failed" + task.getException().getMessage(), Toast.LENGTH_LONG, R.style.mytoast).show();
                            }
                        }
                    });
                }

            }
        });
    }
}