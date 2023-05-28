package com.example.food_planner.Authentication.Login.View;

import com.google.firebase.auth.FirebaseUser;

public interface LoginViewInterface {
    void loginSuccess( FirebaseUser user);
    void loginFail(String msg);
}
