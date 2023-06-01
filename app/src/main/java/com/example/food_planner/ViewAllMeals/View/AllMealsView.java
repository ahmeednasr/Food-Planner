package com.example.food_planner.ViewAllMeals.View;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.food_planner.Network.ApiClient;
import com.example.food_planner.ViewAllMeals.AllMealModel.MealsItemThumb;
import com.example.food_planner.ViewAllMeals.AllMealsRepo.AllMealsRepo;
import com.example.food_planner.ViewAllMeals.Presenter.AllMealsViewPresenter;
import com.example.food_planner.MealModel.MealModel;
import com.example.food_planner.R;

import java.util.ArrayList;
import java.util.List;

public class AllMealsView extends Fragment implements AllMealsViewInterface,OnMealClickListener {
    String type,valueType;
    AllMealsViewPresenter presenter;
    RecyclerView mealsRecycler;
    AllMealsAdapter mealsAdapter;
    LinearLayoutManager layoutManager;
    private NavController controller;
    private ProgressDialog progressDialog;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.view_all_meals_fragment, container, false);

    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage("Loading...");
        progressDialog.setCancelable(false);
        progressDialog.show();
        valueType= AllMealsViewArgs.fromBundle(getArguments()).getValue();
        type= AllMealsViewArgs.fromBundle(getArguments()).getType();
        if(type=="AREA"){
            Toast.makeText(getContext(),type+valueType,Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(getContext(),type+valueType,Toast.LENGTH_SHORT).show();
        }
        InitUI(view);
        presenter=new AllMealsViewPresenter(this, AllMealsRepo.getInstance(ApiClient.getInstance()));
        presenter.getMeals(type,valueType);
    }
    @Override
    public void getAllMeals(List<MealsItemThumb> meals) {
        mealsAdapter.setList(meals);
        mealsAdapter.notifyDataSetChanged();
        dismissProgressDialog();
    }

    @Override
    public void getMeal(MealModel meal) {
       Log.i("TAG","OK meal name: "+meal.getStrMeal());
       controller.navigate(AllMealsViewDirections.actionViewAllMealsToViewMeal(meal,"ALLMEALS"));
    }
    @Override
    public void responseMsg(String msg) {

    }

    @Override
    public void onClick(String id) {
        presenter.getMealDetails(id);
    }
    private void dismissProgressDialog() {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }
    void InitUI(View view){
        controller= Navigation.findNavController(view);
        mealsRecycler =view.findViewById(R.id.mealsRecycleView);
        layoutManager=new LinearLayoutManager(getContext());
        mealsAdapter=new AllMealsAdapter(getContext(),new ArrayList<>(),this);
        mealsRecycler.setLayoutManager(layoutManager);
        mealsRecycler.setAdapter(mealsAdapter);
        mealsRecycler.setHasFixedSize(true);

    }
}