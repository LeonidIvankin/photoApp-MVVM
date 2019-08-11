package ru.leonidivankin.photoapp_mvvm.di;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

import retrofit2.converter.scalars.ScalarsConverterFactory;
import ru.leonidivankin.photoapp_mvvm.model.api.LiveDataCallAdapterFactory;
import ru.leonidivankin.photoapp_mvvm.model.api.RetrofitApi;
import ru.leonidivankin.photoapp_mvvm.model.utils.NetworkStatus;
import toothpick.config.Module;

import static android.content.Context.MODE_PRIVATE;

public class AppModule extends Module {

    public AppModule(Context appContext) {
        bind(RetrofitApi.class).toInstance(new RetrofitApi(new Gson()));
        bind(NetworkStatus.class).toInstance(new NetworkStatus(appContext));
    }
}
