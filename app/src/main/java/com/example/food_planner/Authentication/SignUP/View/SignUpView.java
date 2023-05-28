package com.example.food_planner.Authentication.SignUP.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.food_planner.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignUpView extends AppCompatActivity {
    private FirebaseAuth mAuth=null;
    private static final String TAG = "EmailPassword";
    TextInputEditText userName,eMail,password,confirmPassword;
    AppCompatButton signUpBtn;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAuth = FirebaseAuth.getInstance();
        setContentView(R.layout.sign_up_activity);
        userName=findViewById(R.id.userNameValue_id);
        eMail=findViewById(R.id.emailValue_id);
        password=findViewById(R.id.passwordValue_id);
        confirmPassword=findViewById(R.id.confirmPasswordValue_id);
        signUpBtn=findViewById(R.id.signUpBtn_id);
        //getSupportActionBar().hide();
        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userNameValue = userName.getText().toString();
                String emailValue = eMail.getText().toString();
                String passwordValue = password.getText().toString();
                String confirmPasswordValue = confirmPassword.getText().toString();
                Boolean isValid=validateInputs(userNameValue,emailValue,passwordValue,confirmPasswordValue);
                if(isValid){
                    createAccount(emailValue,passwordValue);
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
    private void createAccount(String email, String password) {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Log.d(TAG, "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            Toast.makeText(SignUpView.this, "Sign up successful",
                                    Toast.LENGTH_SHORT).show();
                        } else {
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(SignUpView.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
    private void signIn(String email, String password) {
        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Log.d(TAG, "Sign Up Success");
                            FirebaseUser user = mAuth.getCurrentUser();
                        } else {
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(SignUpView.this, "Sign up failed.",
                                    Toast.LENGTH_SHORT).show();

                        }
                    }
                });
    }
        public boolean validateInputs(String userNameValue, String emailValue, String passwordValue, String confirmPasswordValue) {
            boolean isValid = true;
            if (userNameValue.trim().isEmpty()) {
                isValid = false;
                Toast.makeText(SignUpView.this, "Username is required",
                    Toast.LENGTH_SHORT).show();
            }
            if (!emailValue.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")) {
                isValid = false;
                Toast.makeText(SignUpView.this, "Invalid email format",
                    Toast.LENGTH_SHORT).show();
            }
            if (passwordValue.length() < 8) {
                isValid = false;
                Toast.makeText(SignUpView.this, "Password should be at least 8 characters long",
                    Toast.LENGTH_SHORT).show();
            }
            if (!passwordValue.equals(confirmPasswordValue)) {
                isValid = false;
                Toast.makeText(SignUpView.this, "Passwords do not match\"",
                    Toast.LENGTH_SHORT).show();
            }
            return isValid;
        }

}