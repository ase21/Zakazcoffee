package ru.zakazcoffee.shop.di.app;

import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ru.zakazcoffee.shop.data.shared_prefs.PrefsHelper;

@Module
public class PrefsModule {

    private final String PREF_NAME = "prefs";

    @Provides
    @Singleton
    SharedPreferences provideSharedPreferences(Context context){
        return context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    @Provides
    @Singleton
    PrefsHelper providePrefsHelper(SharedPreferences sharedPreferences){
        return new PrefsHelper(sharedPreferences);
    }
}
