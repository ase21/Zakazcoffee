package ru.zakazcoffee.shop.di.main.left_menu.about;

import dagger.Subcomponent;
import ru.zakazcoffee.shop.di.scopes.AppScope;
import ru.zakazcoffee.shop.presentation.presenter.main.left_menu.about.AboutUsPresenter;

@AppScope
@Subcomponent(modules = AboutUsModule.class)
public interface AboutUsComponent {
    void inject(AboutUsPresenter presenter);
}
