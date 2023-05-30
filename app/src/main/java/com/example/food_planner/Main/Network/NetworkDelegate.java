package com.example.food_planner.Main.Network;

import com.example.food_planner.Main.HomePage.HomeRepo.AreaModel.AreaResponse;
import com.example.food_planner.Main.HomePage.HomeRepo.CategoryModel.CategoryResponse;
import com.example.food_planner.MealModel.MealModel;

public interface NetworkDelegate {
    void onAreaSuccessResult(AreaResponse response);
    void onCategorySuccessResult(CategoryResponse response);
    void onMealSuccessResult(MealModel meal);
    void onFailureResult(String error);
}
