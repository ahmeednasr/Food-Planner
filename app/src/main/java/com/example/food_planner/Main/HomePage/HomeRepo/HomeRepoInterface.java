package com.example.food_planner.Main.HomePage.HomeRepo;

import com.example.food_planner.Main.Network.NetworkDelegate;

public interface HomeRepoInterface {
    void getMeal(NetworkDelegate networkDelegate);
    void getCategories(NetworkDelegate networkDelegate);
    void getAreas(NetworkDelegate networkDelegate);
}
