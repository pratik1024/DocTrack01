package com.example.project_test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.BlendMode;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.window.SplashScreen;

public class MainActivity7 extends AppCompatActivity {
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
        button = findViewById(R.id.done);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iPtnt = new Intent(getApplicationContext(), MainActivity5.class);
                startActivity(iPtnt);
            }
        });
    }
}