package com.example.food_planner.Main.SavedMeals.SavedMealsRepo;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.example.food_planner.DataBase.LocalSource;
import com.example.food_planner.MealModel.MealModel;

import java.util.List;

public class SavedMealsrepo implements SavedMealsRepoInterface{
    private Context context;
    LocalSource localSource;
    private static SavedMealsrepo repo = null;

    private SavedMealsrepo(LocalSource localSource, Context context) {
        this.context = context;
        this.localSource = localSource;
    }

    public static SavedMealsrepo getInstance(LocalSource localSource, Context context) {
        if (repo == null) {
            repo = new SavedMealsrepo(localSource, context);
        }
        return repo;
    }
    @Override
    public LiveData<List<MealModel>> getLocalMeals() {
        return localSource.getAllStoredMeal();
    }
    @Override
    public void removeMeal(MealModel meal) {
        localSource.deleteMeal(meal);
    }
}
