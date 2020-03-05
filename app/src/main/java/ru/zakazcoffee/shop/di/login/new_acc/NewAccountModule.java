package ru.zakazcoffee.shop.di.login.new_acc;

import dagger.Binds;
import dagger.Module;
import ru.zakazcoffee.shop.di.scopes.AppScope;
import ru.zakazcoffee.shop.domain.login.new_acc_screen.NewAccountInteractor;
import ru.zakazcoffee.shop.domain.login.new_acc_screen.NewAccountInteractorImpl;

@Module
interface NewAccountModule {

    @Binds
    @AppScope
    NewAccountInteractor provideLoginInteractor(NewAccountInteractorImpl loginInteractor);
}
