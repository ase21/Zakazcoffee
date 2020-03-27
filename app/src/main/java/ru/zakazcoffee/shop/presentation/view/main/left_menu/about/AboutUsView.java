package ru.zakazcoffee.shop.presentation.view.main.left_menu.about;

import moxy.MvpView;

public interface AboutUsView extends MvpView {

    void showMessage(String messageText);

    void showProgressBar();

    void hideProgressBar();

    void showAboutUsInfo(String information);
}
