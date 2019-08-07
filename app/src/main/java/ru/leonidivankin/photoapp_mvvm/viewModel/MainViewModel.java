package ru.leonidivankin.photoapp_mvvm.viewModel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class MainViewModel {

    private static final String TAG = "MainViewModel";

    private MutableLiveData<Integer> pictureIdLiveData = new MutableLiveData<>();

    public LiveData<Integer> getPhotoId(){
        return pictureIdLiveData;
    }

    public void setPhotoId(int photoId){
        pictureIdLiveData.setValue(photoId);
    }
}
