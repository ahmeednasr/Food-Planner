package com.example.food_planner.Main.Network;

import com.example.food_planner.Main.ViewAllMeals.AllMealModel.MealsItemThumb;
import com.example.food_planner.MealModel.MealModel;
import com.example.food_planner.MealModel.MealResponse;

import java.util.List;

public interface getMealsNetworkDelagate {
    void onMealByIdSuccess(MealModel meal);
    void getMealsSucces(List<MealsItemThumb> meals);
    void onFail(String msg);
}
