package ru.zakazcoffee.shop.di.main.left_menu.wallet;

import dagger.Subcomponent;
import ru.zakazcoffee.shop.di.scopes.AppScope;
import ru.zakazcoffee.shop.presentation.presenter.main.left_menu.about.AboutUsPresenter;

@AppScope
@Subcomponent(modules = WalletModule.class)
public interface WalletComponent {
    void inject(AboutUsPresenter presenter);
}
