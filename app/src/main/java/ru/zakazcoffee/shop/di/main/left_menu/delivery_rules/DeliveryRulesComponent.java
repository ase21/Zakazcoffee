package ru.zakazcoffee.shop.di.main.left_menu.delivery_rules;

import dagger.Subcomponent;
import ru.zakazcoffee.shop.di.scopes.AppScope;
import ru.zakazcoffee.shop.presentation.presenter.main.left_menu.about.AboutUsPresenter;

@AppScope
@Subcomponent(modules = DeliveryRulesModule.class)
public interface DeliveryRulesComponent {
    void inject(AboutUsPresenter presenter);
}
