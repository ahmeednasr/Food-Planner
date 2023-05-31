package com.example.food_planner.Main.SavedMeals.SavedMealsView;

import com.example.food_planner.MealModel.MealModel;

public interface onSavedMealsClickListener {
    void onclick(MealModel meal);
    void onRemove(MealModel meal);
}
