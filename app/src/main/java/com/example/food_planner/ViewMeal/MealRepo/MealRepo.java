package com.example.food_planner.ViewMeal.MealRepo;

import android.content.Context;

import com.example.food_planner.DataBase.LocalSource;
import com.example.food_planner.SavedMeals.FavMealsNetworkDelegate;
import com.example.food_planner.MealModel.MealModel;
import com.example.food_planner.DataBase.remoteFireBase.AysncListiner;
import com.example.food_planner.DataBase.remoteFireBase.RemoteFireBaseInterFace;

public class MealRepo implements MealRepoInterFace {
    private Context context;
    LocalSource localSource;
    RemoteFireBaseInterFace remoteFireBase;
    private static MealRepo repo = null;

    public MealRepo(Context context, LocalSource localSource, RemoteFireBaseInterFace remoteFireBase) {
        this.context = context;
        this.localSource = localSource;
        this.remoteFireBase = remoteFireBase;
    }
    public static MealRepo getInstance(Context context,LocalSource localSource,RemoteFireBaseInterFace remoteFireBase ) {
        if (repo == null) {
            repo = new MealRepo(context,localSource,remoteFireBase);
        }
        return repo;
    }
    @Override
    public void insertMeal(MealModel meal, AysncListiner listiner) {
        remoteFireBase.insertMealRemote(meal,listiner);
    }
    @Override
    public void insertLocal(MealModel mealModel) {
        localSource.insertMeal(mealModel);
    }

    @Override
    public void removeMeal(MealModel meal, FavMealsNetworkDelegate listiner) {
        remoteFireBase.removeMeal(meal,listiner);
    }

    @Override
    public void getSavedMeals( FavMealsNetworkDelegate listiner) {
        remoteFireBase.getUserMeals(listiner);
    }
}
