package ru.leonidivankin.photoapp_mvvm.viewModel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import ru.leonidivankin.photoapp_mvvm.model.api.Resource;
import ru.leonidivankin.photoapp_mvvm.model.api.RetrofitApi;

public class SingleViewModel extends ViewModel {

    private static final String TAG = "SingleViewModel";

    private MutableLiveData<Integer> pictureIdLiveData = new MutableLiveData<>();

    public LiveData<Integer> getPhotoId() {
        return pictureIdLiveData;
    }

    public void setPhotoId(int photoId) {
        pictureIdLiveData.setValue(photoId);
    }

    public LiveData<Resource<String>>  showPhoto() {

        //todo to toothpick
        RetrofitApi retrofitApi = new RetrofitApi();

        return retrofitApi.requestServer();


    }

}
