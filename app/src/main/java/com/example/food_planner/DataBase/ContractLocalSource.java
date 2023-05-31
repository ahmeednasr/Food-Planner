package com.example.food_planner.DataBase;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.LiveData;

import com.example.food_planner.MealModel.MealModel;

import java.util.List;

public class ContractLocalSource implements LocalSource {
    private static String TAG = "TEST";
    private MealDao dao;
    private static ContractLocalSource localSource = null;
    private LiveData<List<MealModel>> storedMeals;

    private ContractLocalSource(Context context) {
        MyRoomDataBase db = MyRoomDataBase.getInstance(context.getApplicationContext());
        this.dao = db.mealDao();
        storedMeals = dao.gatAllMeals();
        Log.i(TAG, "getallstored in Constractor localsource");
    }

    public static ContractLocalSource getInstance(Context context) {
        if (localSource == null) {
            localSource = new ContractLocalSource(context);
        }
        return localSource;
    }

    @Override
    public void insertMeal(MealModel meal) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                dao.insertMeal(meal);
            }
        }).start();
    }

    @Override
    public void deleteMeal(MealModel meal) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                dao.deleteMeal(meal);
            }
        }).start();
    }

    @Override
    public LiveData<List<MealModel>> getAllStoredMeal() {
        return storedMeals;
    }

    @Override
    public MealModel getImageCached() {

        return null;
    }
}
