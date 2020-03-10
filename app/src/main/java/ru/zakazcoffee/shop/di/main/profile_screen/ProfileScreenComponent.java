package ru.zakazcoffee.shop.di.main.profile_screen;

import dagger.Subcomponent;
import ru.zakazcoffee.shop.di.scopes.AppScope;
import ru.zakazcoffee.shop.presentation.presenter.main.profile_screen.ProfileScreenPresenter;

@AppScope
@Subcomponent(modules = ProfileScreenModule.class)
public interface ProfileScreenComponent {
    void inject(ProfileScreenPresenter presenter);
}
