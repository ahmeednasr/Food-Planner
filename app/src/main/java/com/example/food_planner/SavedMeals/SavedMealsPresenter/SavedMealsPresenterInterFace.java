package com.example.food_planner.SavedMeals.SavedMealsPresenter;

import androidx.lifecycle.LiveData;

import com.example.food_planner.MealModel.MealModel;

import java.util.List;

public interface SavedMealsPresenterInterFace {
     LiveData<List<MealModel>> getLocalSavedMeals();
    void getRemoteSavedMeals();
     void removeRemoteSavedMeal(MealModel meal);
}
