package com.example.food_planner.ViewAllMeals.Presenter;

import com.example.food_planner.Network.getMealsNetworkDelagate;
import com.example.food_planner.ViewAllMeals.AllMealModel.MealsItemThumb;
import com.example.food_planner.ViewAllMeals.AllMealsRepo.AllMealsRepoInterface;
import com.example.food_planner.ViewAllMeals.View.AllMealsViewInterface;
import com.example.food_planner.MealModel.MealModel;

import java.util.List;

public class AllMealsViewPresenter implements AllMealsPresenterInterface, getMealsNetworkDelagate {
    AllMealsViewInterface _view;
    AllMealsRepoInterface _repo;

    public AllMealsViewPresenter(AllMealsViewInterface _view, AllMealsRepoInterface _repo) {
        this._view = _view;
        this._repo = _repo;
    }
    @Override
    public void getMeals(String type, String value) {
        if(type=="AREA"){
            _repo.getMealsByArea(value,this);
        }else {
            _repo.getMealsByCategory(value,this);
        }
    }

    @Override
    public void getMealDetails(String id) {
        _repo.getMeal(id,this);
    }
    @Override
    public void onMealByIdSuccess(MealModel meal) {
        _view.getMeal(meal);
    }
    @Override
    public void getMealsSucces(List<MealsItemThumb> meals) {
        _view.getAllMeals(meals);
    }
    @Override
    public void onFail(String msg) {
        _view.responseMsg(msg);
    }
}
