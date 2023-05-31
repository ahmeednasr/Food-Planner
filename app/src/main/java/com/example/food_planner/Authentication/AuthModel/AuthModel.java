package com.example.food_planner.Authentication.AuthModel;

import android.util.Log;

import com.example.food_planner.Authentication.AuthListener;
import com.example.food_planner.Authentication.UserDTO;
import com.example.food_planner.MealModel.MealModel;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AuthModel implements AuthModelInterFace {
    private static AuthModel model = null;
    private FirebaseAuth mAuth;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    //DatabaseReference myRef = db.getReference("MyDB");

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
                        UserDTO userDTO=new UserDTO("name",email,new ArrayList<MealModel>());
                        Map<String, Object> newUser = new HashMap<>();
                        newUser.put("userData", userDTO);
                        database.getReference("users").child(user.getUid()).setValue(userDTO)
                                .addOnSuccessListener(aVoid -> {
                                    Log.d("TAG", "New user data saved to database");
                                })
                                .addOnFailureListener(e -> {
                                    Log.w("TAG", "Error saving new user data to database", e);
                                });
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
                UserDTO userDTO=new UserDTO(userName,email,new ArrayList<MealModel>());
                Map<String, Object> newUser = new HashMap<>();
                newUser.put("userData", userDTO);
                database.getReference("users").child(user.getUid()).setValue(userDTO)
                        .addOnSuccessListener(aVoid -> {
                            Log.d("TAG", "New user data saved to database");
                        })
                        .addOnFailureListener(e -> {
                            Log.w("TAG", "Error saving new user data to database", e);
                        });
                listener.onSuccessResult(user);
            } else {
                listener.onFail(task.getException().getMessage());
            }

        });
    }

}
