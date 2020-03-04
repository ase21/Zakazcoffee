package ru.zakazcoffee.shop;

import android.app.Application;

import ru.zakazcoffee.shop.di.app.AppComponent;

public class App extends Application {

    private static App instance;

    private AppComponent appComponent;

    public static App getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        initDagger();
    }

    private void initDagger() {
        appComponent = DaggerAppComponent
                .factory()
                .create(this);
    }
}
