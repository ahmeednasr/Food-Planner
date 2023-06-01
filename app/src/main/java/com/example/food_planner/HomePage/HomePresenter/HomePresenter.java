package com.example.food_planner.HomePage.HomePresenter;

import android.util.Log;

import com.example.food_planner.HomePage.HomeView.HomeViewInterface;
import com.example.food_planner.HomePage.HomeRepo.AreaModel.AreaResponse;
import com.example.food_planner.HomePage.HomeRepo.CategoryModel.CategoryResponse;
import com.example.food_planner.HomePage.HomeRepo.HomeRepoInterface;
import com.example.food_planner.Network.NetworkDelegate;
import com.example.food_planner.MealModel.MealModel;

public class HomePresenter implements HomePresenterInterface, NetworkDelegate {
    HomeViewInterface _view;
    HomeRepoInterface _repo;

    public HomePresenter(HomeViewInterface _view, HomeRepoInterface _repo) {
        this._view = _view;
        this._repo = _repo;
    }

    @Override
    public void getMealOfDay() {
        Log.d("TAG","meal prsenter");
        _repo.getMeal(this);
    }

    @Override
    public void getArea() {
        Log.d("TAG","area prsenter");
        _repo.getAreas(this);
    }

    @Override
    public void getCategory() {
        Log.d("TAG","area prsenter");
        _repo.getCategories(this);
    }

    @Override
    public void onAreaSuccessResult(AreaResponse response) {
        Log.d("TAG","get area prsenter");
        _view.showArea(response.getMeals());
    }

    @Override
    public void onCategorySuccessResult(CategoryResponse response) {
        Log.d("TAG","get cate prsenter");
        _view.showCategory(response.getMeals());
    }

    @Override
    public void onMealSuccessResult(MealModel meal) {
        Log.d("TAG","get meal prsenter");
        _view.getMealOfDay(meal);
    }

    @Override
    public void onFailureResult(String error) {
        Log.d("TAG","mget comp faild prsenter"+error);
        _view.responseMsg(error);
    }
}
