package com.example.food_planner.HomePage.HomeView;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.food_planner.HomePage.HomePresenter.HomePresenter;
import com.example.food_planner.HomePage.HomePresenter.HomePresenterInterface;
import com.example.food_planner.HomePage.HomeRepo.AreaModel.AreaItem;
import com.example.food_planner.HomePage.HomeRepo.CategoryModel.CategoryItem;
import com.example.food_planner.HomePage.HomeRepo.HomeRepo;
import com.example.food_planner.Network.ApiClient;
import com.example.food_planner.MealModel.MealModel;
import com.example.food_planner.R;

import java.util.ArrayList;
import java.util.List;

public class HomeView extends Fragment implements HomeViewInterface, OnAreaClickListener, OnCategoryClickListner {
    private ProgressDialog progressDialog;
    NetworkInfo networkInfo;
    ConnectivityManager connMgr;
    CardView mealOfDay;
    ImageView imageMeal;
    TextView mealName,mealOfday,area,category;
    HomePresenterInterface presenterInterface;
    RecyclerView areaRecycleView, categoryRecycleView;
    AreaAdabter areaAdapter;
    CategoryAdabter categoryAdapter;
    LinearLayoutManager areaLayoutManager, categoryLayoutManager;
    MealModel meal = null;
    private NavController controller;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.home_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
         connMgr = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
         networkInfo = connMgr.getActiveNetworkInfo();
        controller = Navigation.findNavController(view);
        InitUI(view);

        if (networkInfo != null && networkInfo.isConnected()) {
            progressDialog = new ProgressDialog(getContext());
            progressDialog.setMessage("Loading...");
            progressDialog.setCancelable(false);
            progressDialog.show();
            presenterInterface = new HomePresenter(this,
                    HomeRepo.getInstance(ApiClient.getInstance()));
            new Thread(() -> {
                presenterInterface.getMealOfDay();
                presenterInterface.getArea();
                presenterInterface.getCategory();
            }).start();
        } else {
            Toast.makeText(getContext(), "No connection", Toast.LENGTH_SHORT).show();
            mealOfDay.setEnabled(false);
        }



        mealOfDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (meal != null) {
                    Log.d("Tag", "onclick " + meal.getStrMeal());
                   // controller.navigate(HomeViewDirections.actionHomeFragmentToViewMeal(meal, "HOME"));
                    controller.navigate(HomeViewDirections.actionHomeFragmentToViewMeal(meal,"HOME"));
                }
            }
        });
    }

    void InitUI(View view) {
        mealOfday=view.findViewById(R.id.mealOfDay);
        area=view.findViewById(R.id.area);
        category=view.findViewById(R.id.category);
        mealOfDay = view.findViewById(R.id.mealCard);
        imageMeal = view.findViewById(R.id.mealImage_id);
        mealName = view.findViewById(R.id.mealNameCard);
        areaRecycleView = view.findViewById(R.id.areaRecyclerView);
        categoryRecycleView = view.findViewById(R.id.CategoryRecyclerView);
        areaLayoutManager = new LinearLayoutManager(getContext());
        areaAdapter = new AreaAdabter(getContext(), new ArrayList<>(), this);
        areaRecycleView.setLayoutManager(areaLayoutManager);
        areaRecycleView.setAdapter(areaAdapter);
        areaLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        categoryLayoutManager = new LinearLayoutManager(getContext());
        categoryAdapter = new CategoryAdabter(getContext(), new ArrayList<>(), this);
        categoryRecycleView.setLayoutManager(categoryLayoutManager);
        categoryRecycleView.setAdapter(categoryAdapter);
        categoryLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        areaRecycleView.setHasFixedSize(true);
        categoryRecycleView.setHasFixedSize(true);
        areaRecycleView.setVisibility(View.GONE);
        categoryRecycleView.setVisibility(View.GONE);
        imageMeal.setVisibility(View.GONE);
        mealName.setVisibility(View.GONE);

    }
    @Override
    public void getMealOfDay(MealModel model) {
        getActivity().runOnUiThread(() -> {
            mealName.setText(model.getStrMeal());
            Glide.with(getContext()).load(model.getStrMealThumb())
                    .apply(new RequestOptions().override(400, 300))
                    .placeholder(R.drawable.ic_launcher_foreground)
                    .error(R.drawable.ic_launcher_background).into(imageMeal);
            meal = model;
            imageMeal.setVisibility(View.VISIBLE);
            mealName.setVisibility(View.VISIBLE);
        });
    }

    @Override
    public void showArea(List<AreaItem> areaList) {
        areaAdapter.setList(areaList);
        areaAdapter.notifyDataSetChanged();
        dismissProgressDialog();
        areaRecycleView.setVisibility(View.VISIBLE);
    }

    @Override
    public void showCategory(List<CategoryItem> categoryList) {
        categoryAdapter.setList(categoryList);
        categoryAdapter.notifyDataSetChanged();
        dismissProgressDialog();
        categoryRecycleView.setVisibility(View.VISIBLE);
    }

    @Override
    public void responseMsg(String msg) {
        dismissProgressDialog();
    }

    @Override
    public void onAreaClick(String areaItem, String type) {
        controller.navigate(HomeViewDirections.actionHomeFragmentToViewAllMeals(type, areaItem));
    }

    private void dismissProgressDialog() {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }

    @Override
    public void onCategoryClick(String categoryItem, String type) {
        controller.navigate(HomeViewDirections.actionHomeFragmentToViewAllMeals(type, categoryItem));
    }
}