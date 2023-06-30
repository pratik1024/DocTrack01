package com.example.project_test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

public class splash_screen1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen1);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();}
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent iHome = new Intent(splash_screen1.this,MainActivity.class);
                startActivity(iHome);
            }
        },4000);
    }
}