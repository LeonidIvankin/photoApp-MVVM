package ru.leonidivankin.photoapp_mvvm.model.api;

import androidx.lifecycle.LiveData;

import io.reactivex.Observable;
import retrofit2.http.GET;
import ru.leonidivankin.photoapp_mvvm.model.entity.User;

public interface RetrofitService {
	@GET("/users/LeonidIvankin")
    LiveData<Resource<User>> getUser();

}
