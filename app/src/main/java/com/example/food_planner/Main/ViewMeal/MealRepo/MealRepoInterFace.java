package com.example.food_planner.Main.ViewMeal.MealRepo;

import androidx.lifecycle.LiveData;

import com.example.food_planner.MealModel.MealModel;
import com.example.food_planner.remoteFireBase.AysncListiner;

import java.util.List;

public interface MealRepoInterFace {
    void insertMeal(MealModel meal, AysncListiner listiner);
    void insertLocal(MealModel mealModel );
}
