package com.example.project_test;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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

public class MainActivity9 extends AppCompatActivity {
    Button button;
    private EditText signupemail_d, signuppw_d;
    EditText d_name,d_phone,d_at,d_postal_pin;
    private  FirebaseAuth auth;

    String d_email_txt;
    String d_pw_txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main9);
        button= findViewById(R.id.next_btn);
        signupemail_d=findViewById(R.id.email_id);
        signuppw_d=findViewById(R.id.PW);
        d_name=findViewById(R.id.ID_);
        d_phone=findViewById(R.id.PHN);
        d_at=findViewById(R.id.at_);
        d_postal_pin=findViewById(R.id.post_);
        auth = FirebaseAuth.getInstance();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = signupemail_d.getText().toString().trim();
                String pass = signuppw_d.getText().toString().trim();
                if(user.isEmpty()){
                    signupemail_d.setError("Email can't be empty");
                }
                if ( pass.isEmpty()){
                    signuppw_d.getText().toString().trim();
                }
                else {
                    auth.createUserWithEmailAndPassword(user,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if( task.isSuccessful()){
                                StyleableToast.makeText(MainActivity9.this, "Dataset Updated", Toast.LENGTH_LONG, R.style.mytoast).show();
                                startActivity(new Intent(MainActivity9.this,MainActivity10.class));
                            }
                            else {
                                StyleableToast.makeText(MainActivity9.this, "Dataset Updated Failed" + task.getException().getMessage(), Toast.LENGTH_LONG, R.style.mytoast).show();
                            }
                        }
                    });
                }
                Intent iPtnt = new Intent(getApplicationContext(), MainActivity10.class);
                startActivity(iPtnt);
            }
        });

    }
}