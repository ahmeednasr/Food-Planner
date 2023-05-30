package com.example.food_planner.Main.HomePage.HomeView;
import com.example.food_planner.Main.HomePage.HomeRepo.AreaModel.AreaItem;
import com.example.food_planner.Main.HomePage.HomeRepo.CategoryModel.CategoryItem;
import com.example.food_planner.MealModel.MealModel;

import java.util.List;

public interface HomeViewInterface {
    void getMealOfDay(MealModel model);
    void showArea(List<AreaItem> area);
    void showCategory(List<CategoryItem> category);
    void responseMsg(String msg);
}
