package ru.leonidivankin.photoapp_mvvm.model.api;

import androidx.lifecycle.LiveData;

import com.google.gson.Gson;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import ru.leonidivankin.photoapp_mvvm.model.entity.Photo;
import ru.leonidivankin.photoapp_mvvm.model.entity.User;
import ru.leonidivankin.photoapp_mvvm.model.utils.IConstant;

public class RetrofitApi {

    public LiveData<Resource<Photo>> requestServer(String key) {

        //todo to toothpick
        ScalarsConverterFactory scalarsConverterFactory = ScalarsConverterFactory.create();

        Gson gson = new Gson();
        GsonConverterFactory gsonConverterFactory = GsonConverterFactory.create(gson);

        RetrofitService api = new Retrofit.Builder()
                .baseUrl(IConstant.BASE_URL_PIXABAY)
                .addCallAdapterFactory(LiveDataCallAdapterFactory.create())
                .addConverterFactory(LiveDataResponseBodyConverterFactory.create())
                .addConverterFactory(gsonConverterFactory)
                .build()
                .create(RetrofitService.class);

        return api.getPhoto(key);
    }
}
