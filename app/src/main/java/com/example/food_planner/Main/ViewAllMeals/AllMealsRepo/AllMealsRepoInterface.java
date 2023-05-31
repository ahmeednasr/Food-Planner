package com.example.food_planner.Main.ViewAllMeals.AllMealsRepo;

import com.example.food_planner.Main.Network.getMealsNetworkDelagate;

public interface AllMealsRepoInterface {
    void getMealsByCategory(String category, getMealsNetworkDelagate delagate);
    void getMealsByArea(String area,getMealsNetworkDelagate delagate);
    void getMeal(String id,getMealsNetworkDelagate delagate);
}
