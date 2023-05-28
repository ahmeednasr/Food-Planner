package com.example.food_planner.Authentication.SignUP.View;

import com.google.firebase.auth.FirebaseUser;

public interface SignUPViewInterface {
    void signUpSuccess( FirebaseUser user);
    void signUpFail(String msg);
}
