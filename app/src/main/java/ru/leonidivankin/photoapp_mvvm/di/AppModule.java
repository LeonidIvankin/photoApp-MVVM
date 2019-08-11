package ru.leonidivankin.photoapp_mvvm.di;

import android.content.Context;

import com.google.gson.Gson;

import ru.leonidivankin.photoapp_mvvm.model.api.RetrofitApi;
import ru.leonidivankin.photoapp_mvvm.model.utils.NetworkStatus;
import toothpick.config.Module;

public class AppModule extends Module {

    public AppModule(Context appContext) {
        bind(RetrofitApi.class).toInstance(new RetrofitApi(new Gson()));
        bind(NetworkStatus.class).toInstance(new NetworkStatus(appContext));
    }
}
