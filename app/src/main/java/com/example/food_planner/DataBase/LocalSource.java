package com.example.food_planner.DataBase;

import androidx.lifecycle.LiveData;

import com.example.food_planner.MealModel.MealModel;

import java.util.List;

public interface LocalSource {
    void insertMeal(MealModel meal);
    void deleteMeal(MealModel meal);
    LiveData<List<MealModel>> getAllStoredMeal();
    MealModel getImageCached();
}
