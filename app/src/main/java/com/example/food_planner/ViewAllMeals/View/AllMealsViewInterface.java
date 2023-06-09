package com.example.food_planner.ViewAllMeals.View;

import com.example.food_planner.ViewAllMeals.AllMealModel.MealsItemThumb;
import com.example.food_planner.MealModel.MealModel;

import java.util.List;

public interface AllMealsViewInterface {
    void getAllMeals(List<MealsItemThumb> meals);
    void getMeal(MealModel meal);
    void responseMsg(String msg);

}
