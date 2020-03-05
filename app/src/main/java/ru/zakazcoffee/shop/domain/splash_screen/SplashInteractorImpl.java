package ru.zakazcoffee.shop.domain.splash_screen;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Single;
import ru.zakazcoffee.shop.data.shared_prefs.PrefsHelper;

public class SplashInteractorImpl implements SplashInteractor{

    private final PrefsHelper prefsHelper;

    @Inject
    public SplashInteractorImpl(PrefsHelper prefsHelper) {
        this.prefsHelper = prefsHelper;
    }

    @Override
    public Single<Boolean> checkIfUserLoggedIn() {
        return Single.fromCallable(() -> prefsHelper.getToken().isEmpty());
    }
}
