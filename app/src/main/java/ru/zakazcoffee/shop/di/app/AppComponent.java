package ru.zakazcoffee.shop.di.app;

import android.content.Context;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;

@Singleton
@Component(modules = {NetworkModule.class, PrefsModule.class})
public interface AppComponent {

    @Component.Factory
    interface Factory{
        AppComponent create(@BindsInstance Context context);
    }
}
