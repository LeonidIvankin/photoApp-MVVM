package ru.leonidivankin.photoapp_mvvm.viewModel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import ru.leonidivankin.photoapp_mvvm.model.api.RetrofitApi;

public class SingleViewModel extends ViewModel {

    private static final String TAG = "SingleViewModel";

    private MutableLiveData<Integer> pictureIdLiveData = new MutableLiveData<>();

    public LiveData<Integer> getPhotoId(){
        return pictureIdLiveData;
    }

    public void setPhotoId(int photoId){
        pictureIdLiveData.setValue(photoId);
    }

    public void showPhoto(){

        //todo to toothpick
        RetrofitApi retrofitApi = new RetrofitApi();

        Observable<String> single = retrofitApi.requestServer();

        Disposable disposable = single.observeOn(AndroidSchedulers.mainThread()).subscribe(str -> {
            Log.d(TAG, "onNext: " + str);
        }, throwable -> {
            Log.e(TAG, "onError" + throwable);
        });
    }

}
