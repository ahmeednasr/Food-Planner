package com.example.food_planner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.food_planner.Navigation.HomeFragment;
import com.example.food_planner.Navigation.SavedMealsFragment;
import com.example.food_planner.Navigation.SearchFragment;
import com.example.food_planner.Navigation.WeekPlanFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainPage extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation_bar);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        loadFragment(new HomeFragment());
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;
        switch (item.getItemId()) {
            case R.id.homeinbar:
                fragment = new HomeFragment();
                break;
            case R.id.searchinbar:
                fragment = new SearchFragment();
                break;
            case R.id.mymealinbar:
                fragment = new SavedMealsFragment();
                break;
            case R.id.weekplaninbar:
                fragment = new WeekPlanFragment();
                break;
        }
        if (fragment != null) {
            loadFragment(fragment);
        }
        return true;
    }
    void loadFragment(Fragment fragment) {
        //to attach fragment
        getSupportFragmentManager().beginTransaction().replace(R.id.mainlayout, fragment).commit();
     }

}