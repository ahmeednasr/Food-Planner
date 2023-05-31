package com.example.food_planner.Main.SavedMeals.SavedMealsView;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.food_planner.DataBase.ContractLocalSource;
import com.example.food_planner.Main.HomePage.HomeView.HomeViewDirections;
import com.example.food_planner.Main.SavedMeals.SavedMealsPresenter.SavedMealsPresenter;
import com.example.food_planner.Main.SavedMeals.SavedMealsRepo.SavedMealsrepo;
import com.example.food_planner.MealModel.MealModel;
import com.example.food_planner.R;

import java.util.ArrayList;
import java.util.List;


public class SavedMealView extends Fragment implements onSavedMealsClickListener,SavedMealsViewInterFace{
    SavedMealsPresenter presenter;
    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    SavedMealsAdapter adapter;
    private NavController controller;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.saved_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initUI(view);
        presenter=new SavedMealsPresenter(this, SavedMealsrepo.getInstance(ContractLocalSource.getInstance(getContext()),getContext()));
        presenter.getSavedMeals().observe(getViewLifecycleOwner(), new Observer<List<MealModel>>() {
            @Override
            public void onChanged(List<MealModel> products) {
                // Update the data in the adapter
                showMeals(products);
            }
        });
    }
    private void initUI(View view) {
        controller= Navigation.findNavController(view);
        recyclerView = view.findViewById(R.id.savedMealsRecycler);
        layoutManager = new LinearLayoutManager(getContext());
        adapter = new SavedMealsAdapter(getContext(), new ArrayList<>(), this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onclick(MealModel meal) {
        controller.navigate(SavedMealViewDirections.actionSavedFragmentToViewMeal(meal));

    }

    @Override
    public void onRemove(MealModel meal) {
        presenter.removeFromFav(meal);
    }

    @Override
    public void showMeals(List<MealModel> meals) {
        adapter.setList(meals);
        adapter.notifyDataSetChanged();
    }
}