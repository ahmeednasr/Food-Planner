package com.example.food_planner.DataBase.remoteFireBase;

import com.example.food_planner.DTO.DayDTO;
import com.example.food_planner.SavedMeals.FavMealsNetworkDelegate;
import com.example.food_planner.WeekPlan.WeekPlanDelegate;
import com.example.food_planner.MealModel.MealModel;

import java.util.List;

public interface RemoteFireBaseInterFace {
    void insertMealRemote(MealModel meal, AysncListiner listiner);
    void getUserMeals( FavMealsNetworkDelegate listiner);
    void insertWeekPlanRemote(List<DayDTO> weekDTO, AysncListiner listiner);
    void getUserPlan(WeekPlanDelegate delegate);
    void getRemoteData(FavMealsNetworkDelegate listiner);

    void removeMeal(MealModel mealModel, FavMealsNetworkDelegate listiner);
    void failConnection(String msg, AysncListiner listiner);
}
