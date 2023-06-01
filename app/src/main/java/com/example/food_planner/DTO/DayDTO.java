package com.example.food_planner.DTO;

import com.example.food_planner.MealModel.MealModel;

import java.io.Serializable;

public class DayDTO  implements Serializable {
    private String name;
    private MealModel breakfast;
    private MealModel lunch;
    private MealModel dinner;

    public DayDTO(String name, MealModel breakfast, MealModel lunch, MealModel dinner) {
        this.name = name;
        this.breakfast = breakfast;
        this.lunch = lunch;
        this.dinner = dinner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MealModel getBreakfast() {
        return breakfast;
    }

    public void setBreakfast(MealModel breakfast) {
        this.breakfast = breakfast;
    }

    public MealModel getLunch() {
        return lunch;
    }

    public void setLunch(MealModel lunch) {
        this.lunch = lunch;
    }

    public MealModel getDinner() {
        return dinner;
    }

    public void setDinner(MealModel dinner) {
        this.dinner = dinner;
    }
}
