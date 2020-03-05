package ru.zakazcoffee.shop.di.login.login_screen;

import dagger.Binds;
import dagger.Module;
import ru.zakazcoffee.shop.di.scopes.AppScope;
import ru.zakazcoffee.shop.domain.login.login_screen.LoginInteractor;
import ru.zakazcoffee.shop.domain.login.login_screen.LoginInteractorImpl;

@Module
public interface LoginModule {

    @Binds
    @AppScope
    LoginInteractor provideLoginInteractor(LoginInteractorImpl loginInteractor);
}
