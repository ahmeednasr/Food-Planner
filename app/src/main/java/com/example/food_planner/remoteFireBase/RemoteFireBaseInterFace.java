package com.example.food_planner.remoteFireBase;

import com.example.food_planner.DayDTO;
import com.example.food_planner.MealModel.MealModel;

import java.util.List;

public interface RemoteFireBaseInterFace {
    void insertMealRemote(MealModel meal, AysncListiner listiner);
    void insertWeekPlanRemote(List<DayDTO> weekDTO, AysncListiner listiner);
    void getRemoteData(String userID, AysncListiner listiner);
    void failConnection(String msg, AysncListiner listiner);
}
