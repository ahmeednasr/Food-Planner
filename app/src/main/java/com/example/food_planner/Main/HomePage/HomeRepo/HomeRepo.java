package com.example.food_planner.Main.HomePage.HomeRepo;

import com.example.food_planner.Main.Network.NetworkDelegate;
import com.example.food_planner.Main.Network.RemoteSource;

public class HomeRepo implements HomeRepoInterface{
    RemoteSource _remoteSource;
    private static HomeRepo repo=null;

    private HomeRepo( RemoteSource _remoteSource) {
        this._remoteSource = _remoteSource;
    }

    public static HomeRepo getInstance(RemoteSource remoteSource){
        if(repo==null){
            repo=new HomeRepo(remoteSource);
        }
        return repo;
    }

    @Override
    public void getMeal(NetworkDelegate networkDelegate) {
        _remoteSource.enqueueMealCall(networkDelegate);
    }

    @Override
    public void getCategories(NetworkDelegate networkDelegate) {
        _remoteSource.enqueueCategorisCall(networkDelegate);
    }

    @Override
    public void getAreas(NetworkDelegate networkDelegate) {
        _remoteSource.enqueueAreasCall(networkDelegate);
    }
}
