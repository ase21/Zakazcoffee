package ru.zakazcoffee.shop.di.login.login_screen;

import dagger.Subcomponent;
import ru.zakazcoffee.shop.di.scopes.AppScope;
import ru.zakazcoffee.shop.presentation.presenter.login.login_screen.LoginPresenter;

@AppScope
@Subcomponent(modules = LoginModule.class)
public interface LoginComponent {
    void inject(LoginPresenter loginPresenter);
}
