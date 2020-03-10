package ru.zakazcoffee.shop.di.main.basket_screen;

import dagger.Binds;
import dagger.Module;
import ru.zakazcoffee.shop.di.scopes.AppScope;
import ru.zakazcoffee.shop.domain.main.basket_screen.BasketScreenInteractor;
import ru.zakazcoffee.shop.domain.main.basket_screen.BasketScreenInteractorImpl;

@Module
public interface BasketScreenModule {

    @Binds
    @AppScope
    BasketScreenInteractor provideBasketScreenInteractor(BasketScreenInteractorImpl interactor);
}
