package com.example.food_planner.network;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.bumptech.glide.manager.ConnectivityMonitor;

import java.util.ArrayList;
import java.util.List;

public class ConnectivityReceiver extends BroadcastReceiver {

    private static ConnectivityReceiver instance;
    private List<ConnectivityMonitor.ConnectivityListener> listeners = new ArrayList<>();
    private ConnectivityReceiver() {
        super();
    }
    public static ConnectivityReceiver getInstance() {
        if (instance == null) {
            instance = new ConnectivityReceiver();
        }
        return instance;
    }

    public void addListener(ConnectivityMonitor.ConnectivityListener listener) {
        listeners.add(listener);
    }

    public void removeListener(ConnectivityMonitor.ConnectivityListener listener) {
        listeners.remove(listener);
    }
    @Override
    public void onReceive(Context context, Intent intent) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        boolean isConnected = networkInfo != null && networkInfo.isConnected();
        for (ConnectivityMonitor.ConnectivityListener listener : listeners) {
            listener.onConnectivityChanged(isConnected);
        }
    }

}
