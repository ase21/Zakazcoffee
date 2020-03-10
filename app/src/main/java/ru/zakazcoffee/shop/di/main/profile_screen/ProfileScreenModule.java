package ru.zakazcoffee.shop.di.main.profile_screen;

import dagger.Binds;
import dagger.Module;
import ru.zakazcoffee.shop.di.scopes.AppScope;
import ru.zakazcoffee.shop.domain.main.profile_screen.ProfileScreenInteractor;
import ru.zakazcoffee.shop.domain.main.profile_screen.ProfileScreenInteractorImpl;

@Module
public interface ProfileScreenModule {

    @Binds
    @AppScope
    ProfileScreenInteractor provideProfileScreenInteractor(ProfileScreenInteractorImpl interactor);
}
