package com.example.food_planner.DataBase;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.example.food_planner.MealModel.MealModel;

@Database(entities = {MealModel.class},version = 1)
public abstract class MyRoomDataBase extends RoomDatabase {
    private static MyRoomDataBase instance=null;
    public abstract MealDao mealDao();
    public static synchronized MyRoomDataBase getInstance(Context context){
        if(instance==null){
            instance= Room.databaseBuilder(context.getApplicationContext()
                            ,MyRoomDataBase.class,"meals Database")
                    .build();
        }
        return instance;
    }
}
