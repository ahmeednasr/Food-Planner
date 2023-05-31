package com.example.food_planner.Main.ViewMeal.MealRepo;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.example.food_planner.DataBase.LocalSource;
import com.example.food_planner.MealModel.MealModel;

import java.util.List;

public class MealRepo implements MealRepoInterFace {
    private Context context;
    LocalSource localSource;
    private static MealRepo repo = null;

    private MealRepo(LocalSource localSource, Context context) {
        this.context = context;
        this.localSource = localSource;
    }

    public static MealRepo getInstance(LocalSource localSource, Context context) {
        if (repo == null) {
            repo = new MealRepo(localSource, context);
        }
        return repo;
    }

    @Override
    public void insertMeal(MealModel meal) {
        localSource.insertMeal(meal);
    }


}
