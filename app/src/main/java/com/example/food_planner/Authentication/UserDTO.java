package com.example.food_planner.Authentication;

import com.example.food_planner.MealModel.MealModel;

import java.io.Serializable;
import java.util.List;

public class UserDTO implements Serializable {
    String userName;
    String email;
    List<MealModel> meals;

    public UserDTO(String userName, String email, List<MealModel> meals) {
        this.userName = userName;
        this.email = email;
        this.meals = meals;
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
}
