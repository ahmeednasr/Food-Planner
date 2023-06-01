package com.example.food_planner;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.food_planner.Authentication.Login.View.LoginView;
import com.example.food_planner.Authentication.SignUP.View.SignUpView;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;

public class WelcomActivity extends AppCompatActivity {
    ImageButton signUpGoogle;
    AppCompatButton signUpEmailBtn,loginBtn;
    GoogleSignInOptions gso;
    GoogleSignInClient gsc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_page);
        getSupportActionBar().hide();
        signUpGoogle=findViewById(R.id.signUpGoogle_id);
        signUpEmailBtn=findViewById(R.id.signUpEmailBtn);
        loginBtn=findViewById(R.id.loginBtn_id);
        gso=new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        gsc= GoogleSignIn.getClient(this,gso);
        signUpGoogle.setOnClickListener((view)->{
            signIn();

        });
        signUpEmailBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WelcomActivity.this, SignUpView.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WelcomActivity.this, LoginView.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });

    }

    private void signIn() {
        Intent intent = gsc.getSignInIntent();
        startActivityForResult(intent,100);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==100){
            Task<GoogleSignInAccount> task=GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                GoogleSignInAccount account = task.getResult(ApiException.class);
                // Get the Google ID token
                String idToken = account.getIdToken();
                SharedPreferences sharedPreferences = getSharedPreferences("PREFS", 0);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("TOKEN",idToken);
                editor.apply();
                mainNavigetion();
            } catch (ApiException e) {
                Toast.makeText(this,"Error",Toast.LENGTH_SHORT).show();
                e.printStackTrace();
            }
        }
    }

    private void mainNavigetion() {
        finish();
        Intent intent=new Intent(getApplicationContext(), MainNavigation.class);
        startActivity(intent);
    }
}