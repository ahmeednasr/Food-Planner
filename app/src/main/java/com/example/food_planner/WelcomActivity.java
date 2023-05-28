package com.example.food_planner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.food_planner.Authentication.Login.View.LoginView;
import com.example.food_planner.Authentication.SignUP.View.SignUpView;

public class WelcomActivity extends AppCompatActivity {
    ImageButton signUpGoogle;
    AppCompatButton signUpEmailBtn,loginBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_page);
        signUpGoogle=findViewById(R.id.signUpGoogle_id);
        signUpEmailBtn=findViewById(R.id.signUpEmailBtn);
        loginBtn=findViewById(R.id.loginBtn_id);
        signUpGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        signUpEmailBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WelcomActivity.this, SignUpView.class);
                // Add the FLAG_ACTIVITY_CLEAR_TOP and FLAG_ACTIVITY_NEW_TASK flags to the Intent
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                // Start the target activity
                startActivity(intent);
            }
        });
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WelcomActivity.this, LoginView.class);
                // Add the FLAG_ACTIVITY_CLEAR_TOP and FLAG_ACTIVITY_NEW_TASK flags to the Intent
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                // Start the target activity
                startActivity(intent);
            }
        });

    }
}