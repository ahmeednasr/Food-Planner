package com.example.food_planner.Main.SavedMeals.SavedMealsPresenter;

import androidx.lifecycle.LiveData;

import com.example.food_planner.MealModel.MealModel;

import java.util.List;

public interface SavedMealsPresenterInterFace {
    public LiveData<List<MealModel>> getSavedMeals();
    public void removeFromFav(MealModel product);
}
