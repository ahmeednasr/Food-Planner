package com.example.food_planner.Authentication.SignUP.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.example.food_planner.Authentication.AuthModel.AuthModel;
import com.example.food_planner.Authentication.Login.View.LoginView;
import com.example.food_planner.Authentication.SignUP.Presenter.SignUpPresenter;
import com.example.food_planner.Main.MainNavigation;
import com.example.food_planner.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseUser;

public class SignUpView extends AppCompatActivity implements SignUPViewInterface {
    TextInputEditText userName, eMail, password, confirmPassword;
    AppCompatButton signUpBtn;
    LottieAnimationView animationView;
    SignUpPresenter signUpPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up_activity);
        initUI();
        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userNameValue = userName.getText().toString();
                String emailValue = eMail.getText().toString();
                String passwordValue = password.getText().toString();
                String confirmPasswordValue = confirmPassword.getText().toString();
                Boolean isValid = validateInputs(userNameValue, emailValue, passwordValue, confirmPasswordValue);
                if (isValid) {
                    animationView.setAnimation("loading.json");
                    animationView.resumeAnimation();
                    signUpPresenter=new SignUpPresenter(SignUpView.this, AuthModel.getInstance());
                    signUpPresenter.signUp(emailValue,userNameValue,passwordValue);
                }
            }
        });
    }

    public boolean validateInputs(String userNameValue, String emailValue, String passwordValue, String confirmPasswordValue) {
        boolean isValid = true;
        String errorMessage = "";

        if (userNameValue.trim().isEmpty()) {
            isValid = false;
            errorMessage = "Username is required";
        } else if (!emailValue.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")) {
            isValid = false;
            errorMessage = "Invalid email format";
        } else if (passwordValue.length() < 8) {
            isValid = false;
            errorMessage = "Password should be at least 8 characters long";
        } else if (!passwordValue.equals(confirmPasswordValue)) {
            isValid = false;
            errorMessage = "Passwords do not match";
        }
        if (!isValid) {
            Toast.makeText(SignUpView.this, errorMessage, Toast.LENGTH_SHORT).show();
        }
        return isValid;
    }

    void initUI() {
        animationView = findViewById(R.id.welcome_anim);
        userName = findViewById(R.id.userNameValue_id);
        eMail = findViewById(R.id.emailValue_id);
        password = findViewById(R.id.passwordValue_id);
        confirmPassword = findViewById(R.id.confirmPasswordValue_id);
        signUpBtn = findViewById(R.id.signUpBtn_id);

    }

    @Override
    public void signUpSuccess(FirebaseUser user) {
        String userId = user.getUid();
        Toast.makeText(SignUpView.this, "welcome " + user.getEmail(),
                Toast.LENGTH_SHORT).show();
        SharedPreferences sharedPreferences = getSharedPreferences("PREFS", 0);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("TOKEN", userId);
        editor.apply();
        Intent intent = new Intent(SignUpView.this, MainNavigation.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }

    @Override
    public void signUpFail(String msg) {
        animationView.setAnimation("error.json");
        animationView.resumeAnimation();
        Toast.makeText(SignUpView.this, msg,
                Toast.LENGTH_SHORT).show();
    }
}