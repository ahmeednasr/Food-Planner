package com.example.food_planner.Authentication.AuthModel;

import com.example.food_planner.Authentication.AuthListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

public class AuthModel implements AuthModelInterFace {
    private static AuthModel model = null;
    private FirebaseAuth mAuth;
    FirebaseDatabase database = FirebaseDatabase.getInstance();

    private AuthModel(FirebaseAuth _auth) {
        mAuth = _auth;
    }

    public static AuthModel getInstance() {
        if (model == null) {
            model = new AuthModel(FirebaseAuth.getInstance());
        }
        return model;
    }

    @Override
    public void authUser(String email, String password, AuthListener listener) {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        FirebaseUser user = mAuth.getCurrentUser();
                        listener.onSuccessResult(user);
                    } else {
                        listener.onFail(task.getException().getMessage());
                    }
                });
    }

    @Override
    public void createUser(String email,String userName, String password, AuthListener listener) {

        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                FirebaseUser user = mAuth.getCurrentUser();
                listener.onSuccessResult(user);
            } else {
                listener.onFail(task.getException().getMessage());
            }

        });
    }

}
