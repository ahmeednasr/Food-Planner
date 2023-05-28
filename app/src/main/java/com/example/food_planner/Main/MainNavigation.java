package com.example.food_planner.Main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.Bundle;
import android.widget.Toast;
import com.bumptech.glide.manager.ConnectivityMonitor;
import com.example.food_planner.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainNavigation extends AppCompatActivity {
    NavController navController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_page);
        NavHostFragment navHostFragment= (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.navHostFragment);
        navController = navHostFragment.getNavController();
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation_bar);
        NavigationUI.setupWithNavController(bottomNavigationView, navController);
    }
}