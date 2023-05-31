package com.example.food_planner.DataBase;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.food_planner.MealModel.MealModel;

import java.util.List;

@Dao
public interface MealDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertMeal(MealModel meal);
    @Delete
    void deleteMeal(MealModel meal);

    @Query("SELECT * From mealmodel")
    LiveData<List<MealModel>> gatAllMeals();
}
