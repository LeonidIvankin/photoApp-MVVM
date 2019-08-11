package ru.leonidivankin.photoapp_mvvm.viewModel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import ru.leonidivankin.photoapp_mvvm.idlingResource.EspressoIdlingResource;
import ru.leonidivankin.photoapp_mvvm.model.api.Resource;
import ru.leonidivankin.photoapp_mvvm.model.api.RetrofitApi;
import ru.leonidivankin.photoapp_mvvm.model.entity.Hit;
import ru.leonidivankin.photoapp_mvvm.model.entity.Photo;
import ru.leonidivankin.photoapp_mvvm.model.utils.IConstant;
import ru.leonidivankin.photoapp_mvvm.model.utils.NetworkStatus;
import ru.leonidivankin.photoapp_mvvm.view.EMessage;
import toothpick.Toothpick;

public class SingleViewModel extends ViewModel {

    private static final String TAG = "SingleViewModel";

    @Inject
    RetrofitApi retrofitApi;
    @Inject
    NetworkStatus networkStatus;

    public SingleViewModel() {
        Toothpick.inject(this, Toothpick.openScope(IConstant.TOOTH_PICK_SCOPE));
    }

    private SingleLiveEvent<Integer> hitIdLiveData = new SingleLiveEvent<>();
    private SingleLiveEvent<Integer> eMessageLiveData = new SingleLiveEvent<>();
    private MutableLiveData<List<Hit>> hitListLiveData = new MutableLiveData<>();


    public LiveData<Integer> getHitId() {
        return hitIdLiveData;
    }

    public SingleLiveEvent<Integer> getEMessageLiveData() {
        return eMessageLiveData;
    }

    public void setHitId(int hitId) {
        hitIdLiveData.setValue(hitId);
    }

    public LiveData<Map<Integer, Hit>> getHitList() {
        EspressoIdlingResource.increment();
        return Transformations.map(hitListLiveData, hitList -> {
            EspressoIdlingResource.decrement();
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
        EspressoIdlingResource.increment();
        LiveData<Resource<Photo>> photoLiveData = retrofitApi.requestServer(IConstant.PIXABAY_KEY);

        return Transformations.map(photoLiveData, resource -> {
            EspressoIdlingResource.decrement();
            if (resource.isSuccess()) {
                Photo photo = resource.getResource();
                if (photo != null) {
                    setHitList(photo.hits);
                    return photo.hits;
                }
            } else {
                Log.e(TAG, "getPhoto: " + resource.getError());
                if (!networkStatus.isConnected()) {
                    eMessageLiveData.setValue(EMessage.NETWORK_IS_NOT_AVAILABLE);
                }
            }

            return new ArrayList<>();
        });

    }


}
