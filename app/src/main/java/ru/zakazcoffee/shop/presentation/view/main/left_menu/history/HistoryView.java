package ru.zakazcoffee.shop.presentation.view.main.left_menu.history;

import java.util.List;

import moxy.MvpView;
import ru.zakazcoffee.shop.data.models.HistoricalCoffee;

public interface HistoryView extends MvpView {

    void showHistory(List<HistoricalCoffee> coffeeList);
}
