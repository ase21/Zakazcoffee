package ru.zakazcoffee.shop.di.login.new_acc;

import dagger.Subcomponent;
import ru.zakazcoffee.shop.di.scopes.AppScope;
import ru.zakazcoffee.shop.presentation.presenter.login.new_acc_screen.NewAccountPresenter;

@AppScope
@Subcomponent(modules = NewAccountModule.class)
public interface NewAccountComponent {
    void inject(NewAccountPresenter newAccountPresenter);
}