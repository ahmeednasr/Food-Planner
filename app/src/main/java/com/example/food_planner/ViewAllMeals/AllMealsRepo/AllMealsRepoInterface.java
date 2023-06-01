package com.example.food_planner.ViewAllMeals.AllMealsRepo;

import com.example.food_planner.Network.getMealsNetworkDelagate;

public interface AllMealsRepoInterface {
    void getMealsByCategory(String category, getMealsNetworkDelagate delagate);
    void getMealsByArea(String area,getMealsNetworkDelagate delagate);
    void getMeal(String id,getMealsNetworkDelagate delagate);
}
