package com.example.food_planner.Authentication.Login.Presenter;

import com.example.food_planner.Authentication.AuthListener;
import com.example.food_planner.Authentication.AuthModel.LoginModelInterFace;
import com.example.food_planner.Authentication.Login.View.LoginViewInterface;
import com.google.firebase.auth.FirebaseUser;

public class AuthPresenter implements LoginPresenterInterFace, AuthListener {
    LoginViewInterface _view;
    LoginModelInterFace _model;

    public AuthPresenter(LoginViewInterface _view, LoginModelInterFace _model) {
        this._view = _view;
        this._model = _model;
    }
    @Override
    public void login(String email, String password) {
        _model.authUser(email,password,this);
    }

    @Override
    public void onSuccessResult( FirebaseUser user) {
        _view.loginSuccess(user);
    }

    @Override
    public void onFail(String msg) {
        _view.loginFail(msg);
    }
}
