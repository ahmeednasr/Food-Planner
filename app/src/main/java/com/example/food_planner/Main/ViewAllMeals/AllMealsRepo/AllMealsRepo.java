package com.example.food_planner.Main.ViewAllMeals.AllMealsRepo;

import com.example.food_planner.Main.Network.RemoteSource;
import com.example.food_planner.Main.Network.getMealsNetworkDelagate;

public class AllMealsRepo implements AllMealsRepoInterface{
    RemoteSource remoteSource;
    private static AllMealsRepo repo=null;

    private AllMealsRepo(RemoteSource remoteSource) {
        this.remoteSource = remoteSource;
    }
    public static AllMealsRepo getInstance(RemoteSource remoteSource){
        if(repo==null){
            repo=new AllMealsRepo(remoteSource);
        }
        return repo;
    }

    @Override
    public void getMealsByCategory(String category, getMealsNetworkDelagate delagate) {
        remoteSource.enqueueMealsByCategory(category,delagate);
    }

    @Override
    public void getMealsByArea(String area, getMealsNetworkDelagate delagate) {
        remoteSource.enqueueMealsByArea(area,delagate);
    }

    @Override
    public void getMeal(String id, getMealsNetworkDelagate delagate) {
        remoteSource.enqueueMealsById(id,delagate);
    }

}
