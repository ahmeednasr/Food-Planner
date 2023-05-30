package com.example.food_planner.Main.Network;

import android.util.Log;

import com.example.food_planner.Main.HomePage.HomeRepo.AreaModel.AreaResponse;
import com.example.food_planner.Main.HomePage.HomeRepo.CategoryModel.CategoryResponse;
import com.example.food_planner.Main.ViewAllMeals.getMealsNetworkDelagate;
import com.example.food_planner.MealModel.MealResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient implements RemoteSource {

    ApiService apiService;
    private static final String BASE_URL = "https://www.themealdb.com/api/json/v1/1/";
    private static ApiClient apiClient = null;
    private static ApiService retrofit;

    private ApiClient() {
        Gson gson = new GsonBuilder().create();
        retrofit = new Retrofit
                .Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
                .create(ApiService.class);
    }

    public static ApiClient getInstance() {
        if (apiClient == null) {
            synchronized (ApiClient.class) {
                if (apiClient == null) {
                    apiClient = new ApiClient();
                }
            }
        }
        return apiClient;
    }

    @Override
    public void enqueueAreasCall(NetworkDelegate networkDelegate) {
        retrofit.getAreas().enqueue(new Callback<AreaResponse>() {
            @Override
            public void onResponse(Call<AreaResponse> call, Response<AreaResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Log.d("TAG", "enqueueAreasCall" + response.body().getMeals());
                    networkDelegate.onAreaSuccessResult(response.body());

                }
            }

            @Override
            public void onFailure(Call<AreaResponse> call, Throwable t) {
                networkDelegate.onFailureResult(t.getMessage());
            }
        });

    }

    @Override
    public void enqueueMealCall(NetworkDelegate networkDelegate) {
        retrofit.getMeal().enqueue(new Callback<MealResponse>() {
            @Override
            public void onResponse(Call<MealResponse> call, Response<MealResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Log.d("TAG", "enqueuemealCall" + response.body().getMeals().get(0).getStrMeal());
                    networkDelegate.onMealSuccessResult(response.body().getMeals().get(0));
                }
            }

            @Override
            public void onFailure(Call<MealResponse> call, Throwable t) {
                networkDelegate.onFailureResult(t.getMessage());
            }
        });
    }

    @Override
    public void enqueueCategorisCall(NetworkDelegate networkDelegate) {
        retrofit.getCategories().enqueue(new Callback<CategoryResponse>() {
            @Override
            public void onResponse(Call<CategoryResponse> call, Response<CategoryResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    //Log.d("TAG","enqueueAreasCall"+response.body().getCategory().get(0).getStrCategory());
                    networkDelegate.onCategorySuccessResult(response.body());

                } else {
                    networkDelegate.onFailureResult("Response failed with status code: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<CategoryResponse> call, Throwable t) {
                networkDelegate.onFailureResult(t.getMessage());
            }
        });
    }

    @Override
    public void enqueueMealsByArea(getMealsNetworkDelagate networkDelegate, String area) {
        retrofit.getMealByArea(area).enqueue(new Callback<MealResponse>() {
            @Override
            public void onResponse(Call<MealResponse> call, Response<MealResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    //Log.d("TAG","enqueueAreasCall"+response.body().getCategory().get(0).getStrCategory());
                    networkDelegate.onMealsByArea(response.body());

                } else {
                    networkDelegate.onFail("Response failed with status code: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<MealResponse> call, Throwable t) {
                networkDelegate.onFail(t.getMessage());
            }
        });
    }

    @Override
    public void enqueueMealsByCategory(getMealsNetworkDelagate networkDelegate,String category) {
        retrofit.getMealsByCategory(category).enqueue(new Callback<MealResponse>() {
            @Override
            public void onResponse(Call<MealResponse> call, Response<MealResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    //Log.d("TAG","enqueueAreasCall"+response.body().getCategory().get(0).getStrCategory());
                    networkDelegate.onMealsByCategory(response.body());

                } else {
                    networkDelegate.onFail("Response failed with status code: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<MealResponse> call, Throwable t) {
                networkDelegate.onFail(t.getMessage());
            }
        });
    }

    @Override
    public void enqueueMealsById(getMealsNetworkDelagate networkDelegate,String id) {
        retrofit.getMealById(id).enqueue(new Callback<MealResponse>() {
            @Override
            public void onResponse(Call<MealResponse> call, Response<MealResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    networkDelegate.onMealByIdSuccessResult(response.body());

                } else {
                    networkDelegate.onFail("Response failed with status code: " + response.code());
                }
            }
            @Override
            public void onFailure(Call<MealResponse> call, Throwable t) {
                networkDelegate.onFail(t.getMessage());
            }
        });
    }
}
