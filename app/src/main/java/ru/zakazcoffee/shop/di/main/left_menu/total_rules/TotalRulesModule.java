package ru.zakazcoffee.shop.di.main.left_menu.total_rules;

import dagger.Binds;
import dagger.Module;
import ru.zakazcoffee.shop.di.scopes.AppScope;
import ru.zakazcoffee.shop.domain.main.left_menu.about.AboutUsInteractor;
import ru.zakazcoffee.shop.domain.main.left_menu.about.AboutUsInteractorImpl;

@Module
public interface TotalRulesModule {

    @Binds
    @AppScope
    AboutUsInteractor provideAboutUsInteractor(AboutUsInteractorImpl interactor);
}
