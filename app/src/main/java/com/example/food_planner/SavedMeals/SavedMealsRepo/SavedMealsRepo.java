package com.example.food_planner.SavedMeals.SavedMealsRepo;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.LiveData;

import com.example.food_planner.DataBase.LocalSource;
import com.example.food_planner.DataBase.remoteFireBase.RemoteFireBaseInterFace;
import com.example.food_planner.SavedMeals.FavMealsNetworkDelegate;
import com.example.food_planner.MealModel.MealModel;

import java.util.List;

public class SavedMealsRepo implements SavedMealsRepoInterface{
    private Context context;
    LocalSource localSource;
    RemoteFireBaseInterFace remote;
    boolean connection;
    private static SavedMealsRepo repo = null;

    private SavedMealsRepo(Context context,LocalSource localSource,RemoteFireBaseInterFace remote,boolean connection) {
        this.context = context;
        this.localSource = localSource;
        this.connection=connection;
        this.remote=remote;
    }

    public static SavedMealsRepo getInstance(Context context,LocalSource localSource,RemoteFireBaseInterFace remote,  boolean connection) {
        if (repo == null) {
            repo = new SavedMealsRepo(context,localSource, remote,connection);
        }
        return repo;
    }

    @Override
    public void getRemoteMeals(FavMealsNetworkDelegate delagate) {
        Log.i("TAG","reqist getRemoteMeals in repo");
        localSource.resetRoom();
        remote.getUserMeals(delagate);
    }

    @Override
    public LiveData<List<MealModel>> getLocalSavedMeals() {
        return localSource.getAllStoredMeal();
    }

    @Override
    public void removeRemoteMeal(MealModel meal, FavMealsNetworkDelegate delegate) {
        remote.removeMeal(meal,delegate);
    }
    @Override
    public void removeLocalMeal(MealModel mealModel) {
        localSource.deleteMeal(mealModel);
    }
    @Override
    public void asyncRoom(List<MealModel> meals) {
        localSource.insertRoom(meals);
    }
}
