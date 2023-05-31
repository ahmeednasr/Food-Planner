package com.example.food_planner.Main.Network;

import com.example.food_planner.Main.HomePage.HomeRepo.AreaModel.AreaResponse;
import com.example.food_planner.Main.HomePage.HomeRepo.CategoryModel.CategoryResponse;
import com.example.food_planner.Main.ViewAllMeals.AllMealModel.ResponseMealItemThumb;
import com.example.food_planner.MealModel.MealResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("list.php?a=list")
    Call<AreaResponse> getAreas();

    @GET("list.php?c=list")
    Call<CategoryResponse> getCategories();

    @GET("random.php")
    Call<MealResponse> getMeal();

    @GET("filter.php")
    Call<ResponseMealItemThumb> getMealsByCategory(@Query("c") String category);

    @GET("filter.php")
    Call<ResponseMealItemThumb> getMealByArea(@Query("a") String area);

    @GET("lookup.php")
    Call<MealResponse> getMealById(@Query("i") String id);

}
