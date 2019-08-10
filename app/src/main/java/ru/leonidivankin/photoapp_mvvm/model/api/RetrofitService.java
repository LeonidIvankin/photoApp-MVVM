package ru.leonidivankin.photoapp_mvvm.model.api;

import androidx.lifecycle.LiveData;

import retrofit2.http.GET;
import retrofit2.http.Query;
import ru.leonidivankin.photoapp_mvvm.model.entity.Photo;

public interface RetrofitService {
    @GET("api")
    LiveData<Resource<Photo>> getPhoto(@Query("key") String key);

}
