package com.example.food_planner.Network;

import com.example.food_planner.ViewAllMeals.AllMealModel.MealsItemThumb;
import com.example.food_planner.MealModel.MealModel;

import java.util.List;

public interface getMealsNetworkDelagate {
    void onMealByIdSuccess(MealModel meal);
    void getMealsSucces(List<MealsItemThumb> meals);
    void onFail(String msg);
}
