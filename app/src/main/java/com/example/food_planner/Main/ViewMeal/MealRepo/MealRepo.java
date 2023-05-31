package com.example.food_planner.Main.ViewMeal.MealRepo;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.example.food_planner.DataBase.LocalSource;
import com.example.food_planner.MealModel.MealModel;
import com.example.food_planner.remoteFireBase.AysncListiner;
import com.example.food_planner.remoteFireBase.RemoteFireBaseInterFace;

import java.util.List;

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


}
