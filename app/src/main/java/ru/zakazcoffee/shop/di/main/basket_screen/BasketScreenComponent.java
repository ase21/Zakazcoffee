package ru.zakazcoffee.shop.di.main.basket_screen;

import dagger.Subcomponent;
import ru.zakazcoffee.shop.di.scopes.AppScope;
import ru.zakazcoffee.shop.presentation.presenter.main.basket_screen.BasketScreenPresenter;

@AppScope
@Subcomponent(modules = BasketScreenModule.class)
public interface BasketScreenComponent {
    void inject(BasketScreenPresenter presenter);
}
