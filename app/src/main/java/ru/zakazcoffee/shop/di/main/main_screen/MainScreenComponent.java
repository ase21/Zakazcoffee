package ru.zakazcoffee.shop.di.main.main_screen;

import dagger.Subcomponent;
import ru.zakazcoffee.shop.di.scopes.AppScope;
import ru.zakazcoffee.shop.presentation.presenter.main.main_screen.MainScreenPresenter;

@AppScope
@Subcomponent(modules = MainScreenModule.class)
public interface MainScreenComponent {
    void inject(MainScreenPresenter presenter);
}
