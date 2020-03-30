package ru.zakazcoffee.shop.di.main.left_menu.history;

import dagger.Subcomponent;
import ru.zakazcoffee.shop.di.scopes.AppScope;
import ru.zakazcoffee.shop.presentation.presenter.main.left_menu.about.AboutUsPresenter;
import ru.zakazcoffee.shop.presentation.presenter.main.left_menu.history.HistoryPresenter;

@AppScope
@Subcomponent(modules = HistoryModule.class)
public interface HistoryComponent {
    void inject(HistoryPresenter presenter);
}
