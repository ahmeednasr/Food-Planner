package com.example.food_planner.Authentication.Login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.example.food_planner.Authentication.SignUP.SignUpActivity;
import com.example.food_planner.Main.MainNavigation;
import com.example.food_planner.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {
    AppCompatButton loginBtn;
    TextInputEditText eMail,password;
    LottieAnimationView animationView;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.login);
        loginBtn=findViewById(R.id.loginBtn_id);
        eMail=findViewById(R.id.emailValue_id);
        password=findViewById(R.id.PasswordValue_id);
        animationView=findViewById(R.id.welcome_anim);
        mAuth = FirebaseAuth.getInstance();
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animationView.setAnimation("loading.json");
                animationView.resumeAnimation();
                String eMailValue=eMail.getText().toString();
                String passwordValue=password.getText().toString();
                Boolean isValid=validateInputs(eMailValue,passwordValue);
                if(isValid){
                    signIn(eMailValue,passwordValue);
                }

            }
        });

    }
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
        }
    }
    private void signIn(String email, String password) {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            animationView.setAnimation("successful.json");
                            animationView.resumeAnimation();
                            FirebaseUser user = mAuth.getCurrentUser();
                            String userId=user.getUid();
                            Toast.makeText(Login.this, "welcome "+user.getEmail(),
                                    Toast.LENGTH_SHORT).show();
                            SharedPreferences sharedPreferences=getSharedPreferences("PREFS",0);
                            SharedPreferences.Editor editor = sharedPreferences.edit();
                            editor.putString("TOKEN", userId);
                            editor.apply();
                            Intent intent = new Intent(Login.this, MainNavigation.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            startActivity(intent);
                            finish();
                        } else {
                            animationView.setAnimation("error.json");
                            animationView.resumeAnimation();
                            Toast.makeText(Login.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });

    }
    public boolean validateInputs(String emailValue, String passwordValue) {
        boolean isValid = true;
        if (emailValue.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(emailValue).matches()) {
            isValid = false;
            Toast.makeText(Login.this, "Please enter a valid email address",
                    Toast.LENGTH_SHORT).show();
            System.out.println();
        }
        if (passwordValue.isEmpty() || passwordValue.length() < 8) {
            isValid = false;
            Toast.makeText(Login.this, "Password should be at least 8 characters long",
                    Toast.LENGTH_SHORT).show();
        }
        return isValid;
    }
}