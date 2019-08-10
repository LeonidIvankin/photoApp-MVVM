package ru.leonidivankin.photoapp_mvvm.model.api;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import ru.leonidivankin.photoapp_mvvm.model.utils.IConstant;

public class RetrofitApi {

    public Observable<String> requestServer() {

        ScalarsConverterFactory scalarsConverterFactory = ScalarsConverterFactory.create();

        RetrofitService api = new Retrofit.Builder()
                .baseUrl(IConstant.BASE_URL_GITHUB)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(scalarsConverterFactory)
                .build()
                .create(RetrofitService.class);

        return api.getUser().subscribeOn(Schedulers.io());
    }
}
