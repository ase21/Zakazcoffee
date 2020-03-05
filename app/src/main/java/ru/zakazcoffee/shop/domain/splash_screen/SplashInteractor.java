package ru.zakazcoffee.shop.domain.splash_screen;

import io.reactivex.rxjava3.core.Single;

public interface SplashInteractor {
    Single<Boolean> checkIfUserLoggedIn();
}
