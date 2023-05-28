package com.example.food_planner.Authentication;

import com.google.firebase.auth.FirebaseUser;

public interface AuthListener {
     void onSuccessResult(FirebaseUser user);
     void onFail(String msg);
}
