package ru.leonidivankin.photoapp_mvvm.model.api;

import androidx.lifecycle.LiveData;

import com.google.gson.Gson;

import javax.inject.Inject;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.leonidivankin.photoapp_mvvm.model.entity.Photo;
import ru.leonidivankin.photoapp_mvvm.model.utils.IConstant;
import toothpick.Toothpick;

public class RetrofitApi {

    private Gson gson;

    @Inject
    public RetrofitApi(Gson gson) {
        Toothpick.inject(this, Toothpick.openScope(IConstant.TOOTH_PICK_SCOPE));
        this.gson = gson;
    }

    public LiveData<Resource<Photo>> requestServer(String key) {

        RetrofitService api = new Retrofit.Builder()
                .baseUrl(IConstant.BASE_URL_PIXABAY)
                .addCallAdapterFactory(LiveDataCallAdapterFactory.create())
                .addConverterFactory(LiveDataResponseBodyConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
                .create(RetrofitService.class);

        return api.getPhoto(key);
    }
}
