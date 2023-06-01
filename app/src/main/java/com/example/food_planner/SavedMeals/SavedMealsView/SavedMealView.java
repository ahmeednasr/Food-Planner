package com.example.food_planner.SavedMeals.SavedMealsView;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.food_planner.DataBase.ContractLocalSource;
import com.example.food_planner.DataBase.remoteFireBase.RemoteFireBaes;
import com.example.food_planner.SavedMeals.SavedMealsPresenter.SavedMealsPresenter;
import com.example.food_planner.SavedMeals.SavedMealsPresenter.SavedMealsPresenterInterFace;
import com.example.food_planner.SavedMeals.SavedMealsRepo.SavedMealsRepo;
import com.example.food_planner.MealModel.MealModel;
import com.example.food_planner.R;

import java.util.ArrayList;
import java.util.List;


public class SavedMealView extends Fragment implements onSavedMealsClickListener,SavedMealsViewInterFace{
    SavedMealsPresenterInterFace presenter;
    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    SavedMealsAdapter adapter;
    private NavController controller;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.saved_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ConnectivityManager connMgr = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
       boolean connection=(networkInfo != null && networkInfo.isConnected());
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("PREFS", 0);
        String token = sharedPreferences.getString("TOKEN", "");
        initUI(view,connection);
        presenter= new SavedMealsPresenter(this,SavedMealsRepo.getInstance(getContext(), ContractLocalSource.getInstance(getContext()), RemoteFireBaes.getInstance(token),connection));
        Log.i("TAG","status connection " +connection);
        if(connection){
            Log.i("TAG","reqist persenter in veiw");
            presenter.getRemoteSavedMeals();
            presenter.getLocalSavedMeals().observe(getViewLifecycleOwner(), new Observer<List<MealModel>>() {
                @Override
                public void onChanged(List<MealModel> products) {
                    showMeals(products);
                }
            });
        }else{
            Log.i("TAG","reqist persenter in local view");
            presenter.getLocalSavedMeals().observe(getViewLifecycleOwner(), new Observer<List<MealModel>>() {
                @Override
                public void onChanged(List<MealModel> products) {
                    showMeals(products);
                }
            });
        }
    }
    private void initUI(View view,boolean connection) {
        controller= Navigation.findNavController(view);
        recyclerView = view.findViewById(R.id.savedMealsRecycler);
        layoutManager = new LinearLayoutManager(getContext());
        adapter = new SavedMealsAdapter(getContext(), new ArrayList<>(), this,connection);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
    @Override
    public void onclick(MealModel meal) {
        controller.navigate(SavedMealViewDirections.actionSavedFragmentToViewMeal(meal,"ROOM"));
    }

    @Override
    public void onRemove(MealModel meal) {
        presenter.removeRemoteSavedMeal(meal);
    }

    @Override
    public void showMeals(List<MealModel> meals) {
        Log.i("TAG","showMeals in vew");
        adapter.setList(meals);
       adapter.notifyDataSetChanged();
    }
}