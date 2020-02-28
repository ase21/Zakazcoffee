package ru.zakazcoffee.shop.presentation.view.splash_screen;

import moxy.MvpView;
import moxy.viewstate.strategy.AddToEndSingleStrategy;
import moxy.viewstate.strategy.StateStrategyType;

@StateStrategyType(AddToEndSingleStrategy.class)
public interface SplashScreenView extends MvpView {
    void showMainScreen();

    void showLoginScreen();
}
