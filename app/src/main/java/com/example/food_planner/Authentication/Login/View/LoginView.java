package com.example.food_planner.Authentication.Login.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.example.food_planner.Authentication.AuthModel.LoginModel;
import com.example.food_planner.Authentication.Login.Presenter.AuthPresenter;
import com.example.food_planner.Main.MainNavigation;
import com.example.food_planner.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseUser;

public class LoginView extends AppCompatActivity implements LoginViewInterface {
    AppCompatButton loginBtn;
    TextInputEditText eMail, password;
    LottieAnimationView animationView;
    AuthPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        initUI();
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String eMailValue = eMail.getText().toString();
                String passwordValue = password.getText().toString();
               boolean isValid= validateInputs(eMail, password);
                if (isValid) {
                    animationView.setAnimation("loading.json");
                    animationView.resumeAnimation();
                    presenter = new AuthPresenter(LoginView.this, LoginModel.getInstance());
                    presenter.login(eMailValue, passwordValue);
                }
            }
        });

    }
    public boolean validateInputs( TextInputEditText eMail, TextInputEditText password) {
        String emailValue = eMail.getText().toString();
        String passwordValue = password.getText().toString();
        boolean isValid = true;
        if (emailValue.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(emailValue).matches()) {
            eMail.setError("Please enter a valid email address");

            eMail.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.red)));
            isValid = false;
        }else {
            eMail.setError(null);
            eMail.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.lightgreen)));
        }
        if (passwordValue.isEmpty() || passwordValue.length() < 8) {
            password.setError("Password should be at least 8 characters long");
            password.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.red)));
            isValid = false;
        } else {
            password.setError(null);
            password.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.lightgreen)));
        }
        return isValid;
    }

    void initUI() {
        loginBtn = findViewById(R.id.loginBtn_id);
        eMail = findViewById(R.id.emailValue_id);
        password = findViewById(R.id.PasswordValue_id);
        animationView = findViewById(R.id.welcome_anim);
    }

    @Override
    public void loginSuccess(FirebaseUser user) {
        String userId = user.getUid();
        Toast.makeText(LoginView.this, "welcome " + user.getEmail(),
                Toast.LENGTH_SHORT).show();
        SharedPreferences sharedPreferences = getSharedPreferences("PREFS", 0);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("TOKEN", userId);
        editor.apply();
        Intent intent = new Intent(LoginView.this, MainNavigation.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }

    @Override
    public void loginFail(String msg) {
        animationView.setAnimation("error.json");
        animationView.resumeAnimation();
        Toast.makeText(LoginView.this, msg,
                Toast.LENGTH_SHORT).show();
    }
}