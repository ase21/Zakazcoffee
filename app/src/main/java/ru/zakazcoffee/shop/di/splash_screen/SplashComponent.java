package ru.zakazcoffee.shop.di.splash_screen;

import dagger.Subcomponent;
import ru.zakazcoffee.shop.di.scopes.AppScope;
import ru.zakazcoffee.shop.presentation.presenter.splash_screen.SplashScreenPresenter;

@AppScope
@Subcomponent(modules = SplashModule.class)
public interface SplashComponent {
    void inject(SplashScreenPresenter splashScreenPresenter);
}
