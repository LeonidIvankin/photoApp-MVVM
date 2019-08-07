package ru.leonidivankin.photoapp_mvvm.viewModel;

import android.util.Log;

public class MainViewModel {

    private static final String TAG = "MainViewModel";

    public void showDetailFragment(int photoId){
        Log.d(TAG, "showDetailFragment: " + photoId);
    }
}
