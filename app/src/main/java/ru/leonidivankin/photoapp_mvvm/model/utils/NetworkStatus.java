package ru.leonidivankin.photoapp_mvvm.model.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import javax.inject.Inject;

import toothpick.Toothpick;

public class NetworkStatus {

    private static final String TAG = "NetworkStatus";

    private final ConnectivityManager connectivityManager;
    private final NetworkRequest networkRequest;
    private boolean connected;

    @Inject
    public NetworkStatus(Context appContext) {
        Toothpick.inject(this, Toothpick.openScope(IConstant.TOOTH_PICK_SCOPE));
        connectivityManager = (ConnectivityManager) appContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        networkRequest = new NetworkRequest.Builder()
                .addTransportType(NetworkCapabilities.TRANSPORT_WIFI)
                .addTransportType(NetworkCapabilities.TRANSPORT_CELLULAR)
                .build();

        connectivityManager.registerNetworkCallback(networkRequest, new ConnectivityManager.NetworkCallback(){
            @Override
            public void onAvailable(@NonNull Network network) {
                connected = true;
                Log.d(TAG, "onAvailable: ");
            }

            @Override
            public void onLost(@NonNull Network network) {
                connected = false;
                Log.d(TAG, "onLost: ");
            }

        });
    }

    public boolean isConnected(){
        return connected;
    }

}
