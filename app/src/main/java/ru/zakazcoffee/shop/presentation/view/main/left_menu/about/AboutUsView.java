package ru.zakazcoffee.shop.presentation.view.main.left_menu.about;

import moxy.MvpView;
import moxy.viewstate.strategy.AddToEndStrategy;
import moxy.viewstate.strategy.StateStrategyType;

@StateStrategyType(AddToEndStrategy.class)
public interface AboutUsView extends MvpView {

    void showMessage(String messageText);

    void showProgressBar();

    void hideProgressBar();

    void showAboutUsInfo(String information);
}
