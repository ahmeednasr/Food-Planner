package com.example.food_planner.Authentication.AuthModel;

import com.example.food_planner.Authentication.AuthListener;

public interface LoginModelInterFace {
    void authUser(String email, String password, AuthListener listener);

}
