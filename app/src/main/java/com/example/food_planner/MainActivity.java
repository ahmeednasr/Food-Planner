package com.example.food_planner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //real-->>> startActivity(new Intent(MainActivity.this, WelcomActivity.class));
                /*for Test-->>*/startActivity(new Intent(MainActivity.this, NavigationController.class));
                finish();
            }
        },2000);
    }
}