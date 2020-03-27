package ru.zakazcoffee.shop.di.main.left_menu.buyers_account;

import dagger.Subcomponent;
import ru.zakazcoffee.shop.di.scopes.AppScope;
import ru.zakazcoffee.shop.presentation.presenter.main.left_menu.about.AboutUsPresenter;

@AppScope
@Subcomponent(modules = BuyersModule.class)
public interface BuyersComponent {
    void inject(AboutUsPresenter presenter);
}
