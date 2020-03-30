package ru.zakazcoffee.shop.di.main.left_menu.history;

import dagger.Binds;
import dagger.Module;
import ru.zakazcoffee.shop.di.scopes.AppScope;
import ru.zakazcoffee.shop.domain.main.left_menu.history.HistoryInteractor;
import ru.zakazcoffee.shop.domain.main.left_menu.history.HistoryInteractorImpl;

@Module
public interface HistoryModule {

    @Binds
    @AppScope
    HistoryInteractor provideHistoryInteractor(HistoryInteractorImpl interactor);
}
