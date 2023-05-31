package com.example.food_planner.remoteFireBase;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.food_planner.DayDTO;
import com.example.food_planner.MealModel.MealModel;
import com.example.food_planner.UserDTO;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

public class RemoteFireBaes implements RemoteFireBaseInterFace {
    private static RemoteFireBaes model = null;
    private FirebaseAuth mAuth;
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference userRef;

    private RemoteFireBaes(FirebaseAuth auth, String userId) {
        mAuth = auth;
        userRef = database.getReference("users").child(userId);
    }

    public static RemoteFireBaes getInstance(String userId) {
        if (model == null) {
            model = new RemoteFireBaes(FirebaseAuth.getInstance(), userId);
        }
        return model;
    }

    @Override
    public void insertMealRemote( MealModel meal, AysncListiner listiner) {
        DatabaseReference mealRef = userRef.child("meals").push();
        mealRef.setValue(meal)
                .addOnSuccessListener(aVoid -> {
                    Log.d("TAG", "Meal data added successfully");
                    listiner.uploadMeal(meal);
                });
    }

    @Override
    public void insertWeekPlanRemote( List<DayDTO> weekDTO, AysncListiner listiner) {
        DatabaseReference mealRef = userRef.child("weekPlan").push();
        mealRef.setValue(weekDTO)
                .addOnSuccessListener(aVoid -> {
                    Log.d("TAG", "Meal data added successfully");
                    listiner.uploadWeekPlan(weekDTO);
                });
    }

    @Override
    public void getRemoteData(String userID, AysncListiner listiner) {
        userRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                UserDTO user=snapshot.getValue(UserDTO.class);
                listiner.getUserData(user);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                listiner.onFail(error.toString());
            }
        });
    }

    @Override
    public void failConnection(String msg, AysncListiner listiner) {
        listiner.onFail(msg);
    }
}
