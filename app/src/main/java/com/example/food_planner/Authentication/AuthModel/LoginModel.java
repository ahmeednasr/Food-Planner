package com.example.food_planner.Authentication.AuthModel;

import com.example.food_planner.Authentication.AuthListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginModel implements LoginModelInterFace {
    private static LoginModel model = null;
    private FirebaseAuth mAuth;
    private LoginModel(FirebaseAuth _auth) {
        mAuth = _auth;
    }
    public static LoginModel getInstance() {
        if (model == null) {
            model = new LoginModel(FirebaseAuth.getInstance());
        }
        return model;
    }

    @Override
    public void authUser(String email, String password, AuthListener listener) {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        FirebaseUser user = mAuth.getCurrentUser();
                        String userId = user.getUid();
                        listener.onSuccessResult(user);
                    } else {
                        listener.onFail(task.getException().getMessage());
                    }
                });
        }
}
