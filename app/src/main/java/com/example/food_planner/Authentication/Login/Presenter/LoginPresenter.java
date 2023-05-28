package com.example.food_planner.Authentication.Login.Presenter;

import com.example.food_planner.Authentication.AuthListener;
import com.example.food_planner.Authentication.AuthModel.AuthModelInterFace;
import com.example.food_planner.Authentication.Login.View.LoginViewInterface;
import com.google.firebase.auth.FirebaseUser;

public class LoginPresenter implements LoginPresenterInterFace, AuthListener {
    LoginViewInterface _view;
    AuthModelInterFace _model;

    public LoginPresenter(LoginViewInterface _view, AuthModelInterFace _model) {
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
