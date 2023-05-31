package com.example.food_planner.Main.ViewMeal.MealRepo;

import androidx.lifecycle.LiveData;

import com.example.food_planner.MealModel.MealModel;

import java.util.List;

public interface MealRepoInterFace {
    void insertMeal(MealModel meal);
}
