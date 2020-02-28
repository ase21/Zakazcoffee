package ru.zakazcoffee.shop.presentation.view.login.login_screen;

import moxy.MvpView;
import moxy.viewstate.strategy.AddToEndSingleStrategy;
import moxy.viewstate.strategy.StateStrategyType;

@StateStrategyType(AddToEndSingleStrategy.class)
public interface LoginScreenView extends MvpView {

    void showToast(String message);

    void showMainActivity();

    void setTimer(String expiresIn);
}
