package ru.leonidivankin.photoapp.viewModel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel  extends ViewModel {

    private static final String TAG = "MainViewModel";

    private MutableLiveData<Integer> pictureIdLiveData = new MutableLiveData<>();

    public LiveData<Integer> getPhotoId(){
        return pictureIdLiveData;
    }

    public void setPhotoId(int photoId){
        Log.d(TAG, "setPhotoId: " + photoId);
        pictureIdLiveData.setValue(photoId);
    }
}
