package com.example.food_planner.Main.Network;

public interface RemoteSource {
    void enqueueAreasCall(NetworkDelegate networkDelegate);
    void enqueueMealCall(NetworkDelegate networkDelegate);
    void enqueueCategorisCall(NetworkDelegate networkDelegate);
    void enqueueMealsByArea(String area,getMealsNetworkDelagate mealsNetworkDelagate);
    void enqueueMealsByCategory(String category,getMealsNetworkDelagate mealsNetworkDelagate);
    void enqueueMealsById(String id,getMealsNetworkDelagate mealsNetworkDelagate);

}
