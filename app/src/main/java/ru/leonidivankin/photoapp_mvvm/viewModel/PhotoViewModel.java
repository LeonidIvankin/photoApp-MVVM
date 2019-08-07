package ru.leonidivankin.photoapp_mvvm.viewModel;

import android.util.Log;

public class PhotoViewModel {

    private static final String TAG = "PhotoViewModel";

    public void showDetailFragment(int photoId){
        Log.d(TAG, "showDetailFragment: " + photoId);
    }
}
