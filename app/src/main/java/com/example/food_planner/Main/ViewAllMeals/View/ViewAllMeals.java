package com.example.food_planner.Main.ViewAllMeals.View;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.food_planner.Main.ViewMeal.ViewMealArgs;
import com.example.food_planner.R;

public class ViewAllMeals extends Fragment {
    String type;
    String valueType;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.view_all_meals_fragment, container, false);

    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        type= ViewAllMealsArgs.fromBundle(getArguments()).getType();
        valueType=ViewAllMealsArgs.fromBundle(getArguments()).getValue();
        if(type=="AREA"){
            Toast.makeText(getContext(),type+valueType,Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(getContext(),type+valueType,Toast.LENGTH_SHORT).show();
        }
    }
}