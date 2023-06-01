package com.example.food_planner.DataBase.remoteFireBase;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.food_planner.DayDTO;
import com.example.food_planner.Main.SavedMeals.FavMealsNetworkDelegate;
import com.example.food_planner.Main.WeekPlan.WeekPlanDelegate;
import com.example.food_planner.MealModel.MealModel;
import com.example.food_planner.UserDTO;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class RemoteFireBaes implements RemoteFireBaseInterFace {
    private static RemoteFireBaes model = null;
    private FirebaseAuth mAuth;
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference userRef;
    String userId;
    private RemoteFireBaes(FirebaseAuth auth, String userId) {
        mAuth = auth;
        this.userId=userId;
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
        DatabaseReference mealsRef = FirebaseDatabase.getInstance().getReference().child("users").child(userId).child("meals");
        Query query = mealsRef.orderByChild("idMeal").equalTo(meal.getIdMeal());
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    // Meal with the same idMeal already exists, handle the error
                    listiner.onFail("Meal with the same ID already exists");
                } else {
                    // Meal does not exist, add it to the database
                    DatabaseReference mealRef = userRef.child("meals").push();
                    mealRef.setValue(meal)
                            .addOnSuccessListener(aVoid -> {
                                Log.d("TAG", "Meal data added successfully");
                                listiner.uploadMeal(meal);
                            })
                            .addOnFailureListener(e -> {
                                Log.e("TAG", "Error adding meal data: " + e.getMessage());
                                listiner.onFail("Error adding meal data");
                            });
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    @Override
    public void getUserMeals(FavMealsNetworkDelegate listiner) {
        DatabaseReference mealsRef = userRef.child("meals");
        Log.i("TAG","reqist getUserMeals in remotefirebase before");

        mealsRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Log.i("TAG","reqist getUserMeals in remotefirebase medil");

                List<MealModel> meals = new ArrayList<>();
                for (DataSnapshot mealSnapshot : snapshot.getChildren()) {
                    MealModel meal = mealSnapshot.getValue(MealModel.class);
                    meals.add(meal);
                    Log.i("TAG","reqist getUserMeals in remotefirebase before");
                }
                listiner.onGetMealsSuccess(meals);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                listiner.onFail(error.toString());
            }
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
    public void getUserPlan(WeekPlanDelegate delegate) {

    }


    @Override
    public void getRemoteData( FavMealsNetworkDelegate listiner) {
        userRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                listiner.onFail(error.toString());
            }
        });
    }

    @Override
    public void removeMeal(MealModel meal, FavMealsNetworkDelegate listiner) {
        DatabaseReference mealsRef = FirebaseDatabase.getInstance().getReference().child("users").child(userId).child("meals");
        Query query = mealsRef.orderByChild("idMeal").equalTo(meal.getIdMeal());
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot childSnapshot : snapshot.getChildren()) {
                    childSnapshot.getRef().removeValue();
                    listiner.onRemoveMealSuccess(meal);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                System.out.println("Error deleting meal: " + error.getMessage());
            }
        });
    }

    @Override
    public void failConnection(String msg, AysncListiner listiner) {
        listiner.onFail(msg);
    }
}
