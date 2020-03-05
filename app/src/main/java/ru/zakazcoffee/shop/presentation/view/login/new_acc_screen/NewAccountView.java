package ru.zakazcoffee.shop.presentation.view.login.new_acc_screen;

import moxy.MvpView;
import moxy.viewstate.strategy.AddToEndSingleStrategy;
import moxy.viewstate.strategy.StateStrategyType;

@StateStrategyType(AddToEndSingleStrategy.class)
public interface NewAccountView extends MvpView {

    void showToast(String message);

    void setEnableSendButton(Boolean isUnable);
}
