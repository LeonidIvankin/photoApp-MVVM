package ru.leonidivankin.photoapp_mvvm.model.api;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface RetrofitService {
	@GET("/users/JakeWharton")
    Observable<String> getUser();

}
