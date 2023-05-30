package com.example.food_planner.Main.ViewAllMeals;

import com.example.food_planner.MealModel.MealModel;
import com.example.food_planner.MealModel.MealResponse;

public interface getMealsNetworkDelagate {
    void onMealByIdSuccessResult(MealResponse meal);
    void onMealsByCategory(MealResponse response);
    void onMealsByArea(MealResponse response);
    void onFail(String msg);
}
