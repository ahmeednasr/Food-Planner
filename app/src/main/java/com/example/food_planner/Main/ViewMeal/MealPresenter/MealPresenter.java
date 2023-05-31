package com.example.food_planner.Main.ViewMeal.MealPresenter;

import com.example.food_planner.Main.ViewMeal.MealRepo.MealRepoInterFace;
import com.example.food_planner.Main.ViewMeal.MealView.MealViewInterface;
import com.example.food_planner.MealModel.MealModel;


public class MealPresenter implements MealPresenterInterface{
    private MealViewInterface _view;
    private MealRepoInterFace _repo;

    public MealPresenter(MealViewInterface _view, MealRepoInterFace _repo) {
        this._view = _view;
        this._repo = _repo;
    }

    @Override
    public void addToFav(MealModel meal) {
        _repo.insertMeal(meal);
    }

}
