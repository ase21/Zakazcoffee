package ru.zakazcoffee.shop.di.main.main_screen;

import dagger.Binds;
import dagger.Module;
import ru.zakazcoffee.shop.di.scopes.AppScope;
import ru.zakazcoffee.shop.domain.main.main_screen.MainScreenInteractor;
import ru.zakazcoffee.shop.domain.main.main_screen.MainScreenInteractorImpl;

@Module
public interface MainScreenModule {

    @Binds
    @AppScope
    MainScreenInteractor provideMainScreenInteractor(MainScreenInteractorImpl interactor);
}
