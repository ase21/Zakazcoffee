package ru.zakazcoffee.shop.presentation.view.main.profile_screen;

import moxy.MvpView;
import moxy.viewstate.strategy.AddToEndSingleStrategy;
import moxy.viewstate.strategy.StateStrategyType;
import ru.zakazcoffee.shop.data.models.User;

@StateStrategyType(AddToEndSingleStrategy.class)
public interface ProfileScreenView extends MvpView {

    void exit();

    void showMessage(String messageText);

    void showProgressBar();

    void hideProgressBar();

    void showInformationAboutUser(User user);
}
