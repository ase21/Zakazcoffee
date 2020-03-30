package ru.zakazcoffee.shop.presentation.view.main.left_menu.history;

import java.util.List;

import moxy.MvpView;
import moxy.viewstate.strategy.AddToEndStrategy;
import moxy.viewstate.strategy.StateStrategyType;
import ru.zakazcoffee.shop.data.models.HistoricalCoffee;

@StateStrategyType(AddToEndStrategy.class)
public interface HistoryView extends MvpView {

    void showHistory(List<HistoricalCoffee> coffeeList);

    void showMessage(String messageText);

    void showProgressBar();

    void hideProgressBar();
}
