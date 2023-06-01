package com.example.food_planner.Network;

import com.example.food_planner.HomePage.HomeRepo.AreaModel.AreaResponse;
import com.example.food_planner.HomePage.HomeRepo.CategoryModel.CategoryResponse;
import com.example.food_planner.ViewAllMeals.AllMealModel.ResponseMealItemThumb;
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

    @GET("filter.php")
    Call<ResponseMealItemThumb> getMealByIngredient(@Query("i") String ingredient);

    @GET("lookup.php")
    Call<MealResponse> getMealById(@Query("i") String id);

}
