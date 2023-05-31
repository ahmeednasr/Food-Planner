package com.example.food_planner.Main.SavedMeals.SavedMealsPresenter;

import androidx.lifecycle.LiveData;

import com.example.food_planner.Main.SavedMeals.SavedMealsRepo.SavedMealsRepoInterface;
import com.example.food_planner.Main.SavedMeals.SavedMealsView.SavedMealsViewInterFace;
import com.example.food_planner.MealModel.MealModel;

import java.util.List;

public class SavedMealsPresenter implements SavedMealsPresenterInterFace {
    private SavedMealsViewInterFace _view;
    private SavedMealsRepoInterface _repo;

    public SavedMealsPresenter(SavedMealsViewInterFace _view, SavedMealsRepoInterface _repo) {
        this._view = _view;
        this._repo = _repo;
    }

    @Override
    public LiveData<List<MealModel>> getSavedMeals() {
        return _repo.getLocalMeals();
    }
    @Override
    public void removeFromFav(MealModel meal) {
        _repo.removeMeal(meal);
    }
}
