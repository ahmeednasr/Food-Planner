package com.example.food_planner.Main.ViewMeal.MealPresenter;

import com.example.food_planner.DayDTO;
import com.example.food_planner.Main.ViewMeal.MealRepo.MealRepoInterFace;
import com.example.food_planner.Main.ViewMeal.MealView.MealViewInterface;
import com.example.food_planner.MealModel.MealModel;
import com.example.food_planner.UserDTO;
import com.example.food_planner.remoteFireBase.AysncListiner;

import java.util.List;


public class MealPresenter implements MealPresenterInterface, AysncListiner {
    private MealViewInterface _view;
    private MealRepoInterFace _repo;

    public MealPresenter(MealViewInterface _view, MealRepoInterFace _repo) {
        this._view = _view;
        this._repo = _repo;
    }

    @Override
    public void addToFav(MealModel meal) {
        _repo.insertMeal(meal,this);
    }

    @Override
    public void uploadWeekPlan(List<DayDTO> week) {

    }

    @Override
    public void uploadMeal(MealModel meal) {
        _repo.insertLocal(meal);
    }

    @Override
    public void getUserData(UserDTO user) {

    }

    @Override
    public void onFail(String msg) {

    }
}
