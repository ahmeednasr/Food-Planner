package com.example.food_planner.Main.SavedMeals.SavedMealsRepo;

import androidx.lifecycle.LiveData;

import com.example.food_planner.Main.SavedMeals.FavMealsNetworkDelegate;
import com.example.food_planner.MealModel.MealModel;

import java.util.List;

public interface SavedMealsRepoInterface {
    void getRemoteMeals(FavMealsNetworkDelegate delagate);
    public LiveData<List<MealModel>> getLocalSavedMeals();
    void removeRemoteMeal(MealModel meal, FavMealsNetworkDelegate delegate);
    void removeLocalMeal(MealModel mealModel);
    void asyncRoom(List<MealModel> meals);

}
