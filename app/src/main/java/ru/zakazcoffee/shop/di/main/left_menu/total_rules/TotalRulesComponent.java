package ru.zakazcoffee.shop.di.main.left_menu.total_rules;

import dagger.Subcomponent;
import ru.zakazcoffee.shop.di.scopes.AppScope;
import ru.zakazcoffee.shop.presentation.presenter.main.left_menu.total_rules.TotalRulesPresenter;

@AppScope
@Subcomponent(modules = TotalRulesModule.class)
public interface TotalRulesComponent {
    void inject(TotalRulesPresenter presenter);
}
