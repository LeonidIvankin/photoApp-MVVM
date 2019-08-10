package ru.leonidivankin.photoapp_mvvm.viewModel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SingleViewModel extends ViewModel {

    private static final String TAG = "SingleViewModel";

    private MutableLiveData<Integer> pictureIdLiveData = new MutableLiveData<>();

    public LiveData<Integer> getPhotoId(){
        return pictureIdLiveData;
    }

    public void setPhotoId(int photoId){
        Log.d(TAG, "setPhotoId: " + photoId);
        pictureIdLiveData.setValue(photoId);
    }
}
