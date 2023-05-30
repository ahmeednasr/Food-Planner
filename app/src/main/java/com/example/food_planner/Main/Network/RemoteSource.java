package com.example.food_planner.Main.Network;

import com.example.food_planner.Main.ViewAllMeals.getMealsNetworkDelagate;

public interface RemoteSource {
    void enqueueAreasCall(NetworkDelegate networkDelegate);
    void enqueueMealCall(NetworkDelegate networkDelegate);
    void enqueueCategorisCall(NetworkDelegate networkDelegate);
    void enqueueMealsByArea(getMealsNetworkDelagate mealsNetworkDelagate, String area);
    void enqueueMealsByCategory(getMealsNetworkDelagate mealsNetworkDelagate,String category);
    void enqueueMealsById(getMealsNetworkDelagate mealsNetworkDelagate,String id);

}
