package com.example.food_planner.Main.HomePage.HomeView;

import android.app.ProgressDialog;
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

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.food_planner.Main.HomePage.HomePresenter.HomePresenter;
import com.example.food_planner.Main.HomePage.HomePresenter.HomePresenterInterface;
import com.example.food_planner.Main.HomePage.HomeRepo.AreaModel.AreaItem;
import com.example.food_planner.Main.HomePage.HomeRepo.CategoryModel.CategoryItem;
import com.example.food_planner.Main.HomePage.HomeRepo.HomeRepo;
import com.example.food_planner.Main.Network.ApiClient;
import com.example.food_planner.MealModel.MealModel;
import com.example.food_planner.R;

import java.util.ArrayList;
import java.util.List;

public class HomeView extends Fragment implements HomeViewInterface, OnAreaClickListener,OnCategoryClickListner {
    private ProgressDialog progressDialog;

    CardView mealOfDay;
    ImageView imageMeal;
    TextView mealName;
    HomePresenterInterface presenterInterface;
    RecyclerView areaRecycleView,categoryRecycleView;
    AreaAdabter areaAdapter;
    CategoryAdabter categoryAdapter;
    LinearLayoutManager areaLayoutManager,categoryLayoutManager;
    MealModel meal;
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
        progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage("Loading...");
        progressDialog.setCancelable(false);
        progressDialog.show();

        controller=Navigation.findNavController(view);
        InitUI(view);
        presenterInterface=new HomePresenter(this,
                HomeRepo.getInstance(ApiClient.getInstance()));

        presenterInterface.getMealOfDay();
        presenterInterface.getArea();
        presenterInterface.getCategory();
        mealOfDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Tag","onclick "+meal.getStrMeal());
                controller.navigate(HomeViewDirections.actionHomeFragmentToViewMeal(meal));
            }
        });
    }

    void InitUI(View view){
        mealOfDay=view.findViewById(R.id.mealCard);
        imageMeal=view.findViewById(R.id.mealImage_id);
        mealName=view.findViewById(R.id.mealNameCard);
        areaRecycleView =view.findViewById(R.id.areaRecyclerView);
        categoryRecycleView=view.findViewById(R.id.CategoryRecyclerView);

        areaLayoutManager=new LinearLayoutManager(getContext());
        areaAdapter=new AreaAdabter(getContext(),new ArrayList<>(),this);
        areaRecycleView.setLayoutManager(areaLayoutManager);
        areaRecycleView.setAdapter(areaAdapter);
        areaLayoutManager.setOrientation(RecyclerView.HORIZONTAL);

        categoryLayoutManager=new LinearLayoutManager(getContext());
        categoryAdapter=new CategoryAdabter(getContext(),new ArrayList<>(),this);
        categoryRecycleView.setLayoutManager(categoryLayoutManager);
        categoryRecycleView.setAdapter(categoryAdapter);
        categoryLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        areaRecycleView.setHasFixedSize(true);
        categoryRecycleView.setHasFixedSize(true);
    }

    @Override
    public void getMealOfDay(MealModel model) {
        mealName.setText(model.getStrMeal());
        Glide.with(getContext()).load(model.getStrMealThumb())
                .apply(new RequestOptions().override(400,300))
                .placeholder(R.drawable.ic_launcher_foreground)
                .error(R.drawable.ic_launcher_background).into(imageMeal);
        meal=model;
    }

    @Override
    public void showArea(List<AreaItem> areaList) {
        areaAdapter.setList(areaList);
        areaAdapter.notifyDataSetChanged();
        dismissProgressDialog();
    }

    @Override
    public void showCategory(List<CategoryItem> categoryList) {

        categoryAdapter.setList(categoryList);
        categoryAdapter.notifyDataSetChanged();
        dismissProgressDialog();
    }

    @Override
    public void responseMsg(String msg) {
        dismissProgressDialog();
    }

    @Override
    public void onAreaClick(String areaItem,String type) {
        controller.navigate(HomeViewDirections.actionHomeFragmentToViewAllMeals(areaItem,type));
    }
    private void dismissProgressDialog() {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }

    @Override
    public void onCategoryClick(String categoryItem,String type) {
        controller.navigate(HomeViewDirections.actionHomeFragmentToViewAllMeals(categoryItem,type));
    }
}