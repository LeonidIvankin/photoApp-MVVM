package ru.leonidivankin.photoapp_mvvm.viewModel;

import android.util.Log;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ru.leonidivankin.photoapp_mvvm.model.api.Resource;
import ru.leonidivankin.photoapp_mvvm.model.api.RetrofitApi;
import ru.leonidivankin.photoapp_mvvm.model.entity.Hit;
import ru.leonidivankin.photoapp_mvvm.model.entity.Photo;
import ru.leonidivankin.photoapp_mvvm.model.utils.IConstant;

public class SingleViewModel extends ViewModel {

    private static final String TAG = "SingleViewModel";

    private SingleLiveEvent<Integer> hitIdLiveData = new SingleLiveEvent<>();
    private MutableLiveData<List<Hit>> hitListLiveData = new MutableLiveData<>();

    public LiveData<Integer> getHitId() {
        return hitIdLiveData;
    }

    public void setHitId(int hitId) {
        hitIdLiveData.setValue(hitId);
    }

    public LiveData<Map<Integer, Hit>> getHitList() {
        return Transformations.map(hitListLiveData, hitList -> {
            Map<Integer, Hit> hitMap = new HashMap<>();
            for (Hit hit : hitList) {
                hitMap.put(hit.id, hit);
            }
            return hitMap;
        });
    }

    public void setHitList(List<Hit> hitList) {
        hitListLiveData.setValue(hitList);
    }

    public LiveData<List<Hit>> getPhoto() {

        //todo to toothpick
        RetrofitApi retrofitApi = new RetrofitApi();

        LiveData<Resource<Photo>> photoLiveData = retrofitApi.requestServer(IConstant.PIXABAY_KEY);

        return Transformations.map(photoLiveData, resource -> {

            if (resource.isSuccess()) {
                Photo photo = resource.getResource();
                if (photo != null) {
                    setHitList(photo.hits);
                    return photo.hits;
                }
            } else {
                Log.e(TAG, "getPhoto: " + resource.getError());
            }

            return new ArrayList<Hit>();
        });

    }


}
