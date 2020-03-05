package ru.zakazcoffee.shop.di.splash_screen;

import dagger.Binds;
import dagger.Module;
import ru.zakazcoffee.shop.di.scopes.AppScope;
import ru.zakazcoffee.shop.domain.splash_screen.SplashInteractor;
import ru.zakazcoffee.shop.domain.splash_screen.SplashInteractorImpl;

@Module
public interface SplashModule {

    @Binds
    @AppScope
    SplashInteractor provideSplashScreenInteractor(SplashInteractorImpl interactor);
}
