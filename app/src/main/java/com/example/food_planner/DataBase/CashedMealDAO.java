package com.example.food_planner.DataBase;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;

import com.example.food_planner.MealModel.MealModel;

@Dao
public interface CashedMealDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertCasheMeal(MealModel meal);
}
