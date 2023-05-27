package com.example.food_planner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import com.example.food_planner.Main.MainNavigation;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
        getSupportActionBar().hide();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences sharedPreferences = getSharedPreferences("PREFS", 0);
                String token = sharedPreferences.getString("TOKEN", "");
                if(token.isEmpty()){
                    startActivity(new Intent(MainActivity.this, WelcomActivity.class));
                    finish();
                }else{
                    startActivity(new Intent(MainActivity.this, MainNavigation.class));
                    finish();
                }
            }
        },3000);
    }

}