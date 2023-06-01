package com.example.food_planner.DataBase.remoteFireBase;

import com.example.food_planner.DTO.DayDTO;
import com.example.food_planner.MealModel.MealModel;
import com.example.food_planner.DTO.UserDTO;

import java.util.List;

public interface AysncListiner {
    void uploadWeekPlan(List<DayDTO> week);
    void uploadMeal(MealModel meal);
    void getUserData(UserDTO user);
    void onFail(String msg);
}
