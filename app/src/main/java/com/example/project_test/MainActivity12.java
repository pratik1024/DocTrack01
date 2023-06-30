package com.example.project_test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity12 extends AppCompatActivity {
Button btn ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main12);
        btn= findViewById(R.id.back_btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iPtnt = new Intent(getApplicationContext(), MainActivity11.class);
                startActivity(iPtnt);
            }
        });
    }
}