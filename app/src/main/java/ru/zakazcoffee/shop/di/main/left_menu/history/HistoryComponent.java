package ru.zakazcoffee.shop.di.main.left_menu.history;

import dagger.Subcomponent;
import ru.zakazcoffee.shop.di.scopes.AppScope;
import ru.zakazcoffee.shop.presentation.presenter.main.left_menu.about.AboutUsPresenter;

@AppScope
@Subcomponent(modules = HistoryModule.class)
public interface HistoryComponent {
    void inject(AboutUsPresenter presenter);
}
