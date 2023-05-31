package com.example.food_planner;

import com.example.food_planner.MealModel.MealModel;

import java.io.Serializable;
import java.util.List;

public class UserDTO implements Serializable {
    String userName;
    String email;
    List<MealModel> meals;
     List<DayDTO> weekPlan;

    public UserDTO(String userName, String email, List<MealModel> meals, List<DayDTO> weekPlan) {
        this.userName = userName;
        this.email = email;
        this.meals = meals;
        this.weekPlan = weekPlan;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<MealModel> getMeals() {
        return meals;
    }

    public void setMeals(List<MealModel> meals) {
        this.meals = meals;
    }

    public List<DayDTO> getWeekPlan() {
        return weekPlan;
    }

    public void setWeekPlan(List<DayDTO> weekPlan) {
        this.weekPlan = weekPlan;
    }
}
