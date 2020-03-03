package ru.zakazcoffee.shop.presentation.view.login.reg_confirmation;

import moxy.MvpView;
import moxy.viewstate.strategy.AddToEndSingleStrategy;
import moxy.viewstate.strategy.StateStrategyType;

public interface RegConfirmationView extends MvpView {

    @StateStrategyType(AddToEndSingleStrategy.class)
    void showToast(String message);
}
