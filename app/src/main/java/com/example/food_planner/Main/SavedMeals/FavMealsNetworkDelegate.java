package com.example.food_planner.Main.SavedMeals;

import androidx.lifecycle.LiveData;

import com.example.food_planner.MealModel.MealModel;

import java.util.List;

public interface FavMealsNetworkDelegate {
   void onGetMealsSuccess(List<MealModel> mealModelList);
   void onRemoveMealSuccess(MealModel mealModel);

   void onFail(String msg);
}
