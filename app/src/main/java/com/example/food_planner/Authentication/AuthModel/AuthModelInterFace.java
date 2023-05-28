package com.example.food_planner.Authentication.AuthModel;

import com.example.food_planner.Authentication.AuthListener;

public interface AuthModelInterFace {
    void authUser(String email, String password, AuthListener listener);
    void createUser(String email,String userName, String password, AuthListener listener);
}
