package com.example.food_planner.ViewMeal.MealRepo;

import com.example.food_planner.SavedMeals.FavMealsNetworkDelegate;
import com.example.food_planner.MealModel.MealModel;
import com.example.food_planner.DataBase.remoteFireBase.AysncListiner;

public interface MealRepoInterFace {
    void insertMeal(MealModel meal, AysncListiner listiner);
    void insertLocal(MealModel mealModel );
    void removeMeal(MealModel meal, FavMealsNetworkDelegate listiner);
    void getSavedMeals( FavMealsNetworkDelegate listiner );
}
