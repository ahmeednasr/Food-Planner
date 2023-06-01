package com.example.food_planner.Main.SavedMeals.SavedMealsPresenter;

import android.util.Log;

import androidx.lifecycle.LiveData;

import com.example.food_planner.Main.SavedMeals.FavMealsNetworkDelegate;
import com.example.food_planner.Main.SavedMeals.SavedMealsRepo.SavedMealsRepoInterface;
import com.example.food_planner.Main.SavedMeals.SavedMealsView.SavedMealsViewInterFace;
import com.example.food_planner.MealModel.MealModel;

import java.util.List;

public class SavedMealsPresenter implements SavedMealsPresenterInterFace , FavMealsNetworkDelegate {
    private SavedMealsViewInterFace _view;
    private SavedMealsRepoInterface _repo;

    public SavedMealsPresenter(SavedMealsViewInterFace _view, SavedMealsRepoInterface _repo) {
        this._view = _view;
        this._repo = _repo;
    }

    @Override
    public LiveData<List<MealModel>> getLocalSavedMeals() {
        return _repo.getLocalSavedMeals();
    }

    @Override
    public void getRemoteSavedMeals() {
        Log.i("TAG","reqist getRemoteSavedMeals in presenter");
        _repo.getRemoteMeals(this);
    }

    @Override
    public void removeRemoteSavedMeal(MealModel meal) {
        _repo.removeRemoteMeal(meal,this);
    }

    @Override
    public void onGetMealsSuccess(List<MealModel> mealModelList) {
        Log.i("TAG","reqist onGetMealsSuccess in presenter");
        _repo.asyncRoom(mealModelList);
        //_view.showMeals(mealModelList);
    }
    @Override
    public void onRemoveMealSuccess(MealModel mealModel) {
        _repo.removeLocalMeal(mealModel);
    }
    @Override
    public void onFail(String msg) {

    }
}
