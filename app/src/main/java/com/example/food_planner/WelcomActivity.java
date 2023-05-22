package com.example.food_planner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.food_planner.Login.Login;

public class WelcomActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcom);
    }

    public void myOnClickMethod(View view) {
        Intent intent = new Intent(WelcomActivity.this, Login.class);
        // Add the FLAG_ACTIVITY_CLEAR_TOP and FLAG_ACTIVITY_NEW_TASK flags to the Intent
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        // Start the target activity
        startActivity(intent);
    }
}