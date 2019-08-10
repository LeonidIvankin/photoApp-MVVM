package ru.leonidivankin.photoapp_mvvm.di;

import android.app.Application;

import ru.leonidivankin.photoapp_mvvm.model.utils.IConstant;
import toothpick.Scope;
import toothpick.Toothpick;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Scope appScope = Toothpick.openScope(IConstant.TOOTH_PICK_SCOPE);
        appScope.installModules(new AppModule(getApplicationContext()));
    }
}
