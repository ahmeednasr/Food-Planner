package com.example.food_planner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;

import com.example.food_planner.Main.MainNavigation;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
        getSupportActionBar().hide();

        SharedPreferences sharedPreferences = getSharedPreferences("PREFS", 0);
        String token = sharedPreferences.getString("TOKEN", "");
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (!token.isEmpty()) {
                    startActivity(new Intent(MainActivity.this, MainNavigation.class));
                    finish();
                } else {
                    startActivity(new Intent(MainActivity.this, WelcomActivity.class));
                    finish();
                }
            }
        }, 3000);
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

}