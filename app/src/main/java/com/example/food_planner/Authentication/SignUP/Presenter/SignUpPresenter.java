package com.example.food_planner.Authentication.SignUP.Presenter;

import com.example.food_planner.Authentication.AuthListener;
import com.example.food_planner.Authentication.AuthModel.AuthModelInterFace;
import com.example.food_planner.Authentication.SignUP.View.SignUPViewInterface;
import com.google.firebase.auth.FirebaseUser;

public class SignUpPresenter implements SignUpPresenterInterface, AuthListener {
    SignUPViewInterface _view;
    AuthModelInterFace _model;

    public SignUpPresenter(SignUPViewInterface _view, AuthModelInterFace _model) {
        this._view = _view;
        this._model = _model;
    }

    @Override
    public void signUp(String email,String userName, String password) {
        _model.createUser(email,userName,password,this);
    }

    @Override
    public void onSuccessResult( FirebaseUser user) {
        _view.signUpSuccess(user);
    }

    @Override
    public void onFail(String msg) {
        _view.signUpFail(msg);
    }


}
