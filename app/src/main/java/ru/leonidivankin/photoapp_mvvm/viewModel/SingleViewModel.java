package ru.leonidivankin.photoapp_mvvm.viewModel;

import android.util.Log;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import ru.leonidivankin.photoapp_mvvm.model.api.Resource;
import ru.leonidivankin.photoapp_mvvm.model.api.RetrofitApi;
import ru.leonidivankin.photoapp_mvvm.model.entity.Hit;
import ru.leonidivankin.photoapp_mvvm.model.entity.Photo;
import ru.leonidivankin.photoapp_mvvm.model.utils.IConstant;

public class SingleViewModel extends ViewModel {

    private static final String TAG = "SingleViewModel";

    private MutableLiveData<Integer> pictureIdLiveData = new MutableLiveData<>();

    public LiveData<Integer> getPhotoId() {
        return pictureIdLiveData;
    }

    public void setPhotoId(int photoId) {
        pictureIdLiveData.setValue(photoId);
    }

    public LiveData<List<Hit>> getPhoto() {

        //todo to toothpick
        RetrofitApi retrofitApi = new RetrofitApi();

        LiveData<Resource<Photo>> photoLiveData = retrofitApi.requestServer(IConstant.PIXABAY_KEY);

        LiveData<List<Hit>> listHitLiveData = Transformations.map(photoLiveData, resource -> {

            if(resource.isSuccess()){
                Photo photo = resource.getResource();
                if(photo != null){
                    return photo.hits;
                }
            } else {
                Log.e(TAG, "onCreateView: " + resource.getError());
            }

            return new ArrayList<Hit>();
        });

        return listHitLiveData;

    }


}
