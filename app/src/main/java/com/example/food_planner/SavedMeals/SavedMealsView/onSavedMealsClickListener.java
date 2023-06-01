package com.example.food_planner.SavedMeals.SavedMealsView;

import com.example.food_planner.MealModel.MealModel;

public interface onSavedMealsClickListener {
    void onclick(MealModel meal);
    void onRemove(MealModel meal);
}
