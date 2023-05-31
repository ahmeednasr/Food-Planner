package com.example.food_planner.Main.SavedMeals.SavedMealsView;

import androidx.lifecycle.LiveData;

import com.example.food_planner.MealModel.MealModel;

import java.util.List;

public interface SavedMealsViewInterFace {
    void showMeals(List<MealModel> meals);
}
