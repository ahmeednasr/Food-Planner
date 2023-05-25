package com.example.food_planner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.food_planner.Authentication.Login.Login;
import com.example.food_planner.Authentication.SignUP.SignUpActivity;

public class WelcomActivity extends AppCompatActivity {
    ImageButton signUpGoogle;
    Button SignUpEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcom);
        signUpGoogle=findViewById(R.id.signUpGoogle_id);
        SignUpEmail=findViewById(R.id.signUpEmailBtn);

        signUpGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        SignUpEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WelcomActivity.this, SignUpActivity.class);
                // Add the FLAG_ACTIVITY_CLEAR_TOP and FLAG_ACTIVITY_NEW_TASK flags to the Intent
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                // Start the target activity
                startActivity(intent);
            }
        });

    }

    public void myOnClickMethod(View view) {
        Intent intent = new Intent(WelcomActivity.this, Login.class);
        // Add the FLAG_ACTIVITY_CLEAR_TOP and FLAG_ACTIVITY_NEW_TASK flags to the Intent
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        // Start the target activity
        startActivity(intent);
    }
}