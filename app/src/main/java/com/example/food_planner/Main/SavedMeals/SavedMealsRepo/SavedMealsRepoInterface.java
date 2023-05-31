package com.example.food_planner.Main.SavedMeals.SavedMealsRepo;

import androidx.lifecycle.LiveData;

import com.example.food_planner.MealModel.MealModel;

import java.util.List;

public interface SavedMealsRepoInterface {
    public LiveData<List<MealModel>> getLocalMeals();
    void removeMeal(MealModel meal);
}
