package ru.zakazcoffee.shop.presentation.view.main.main_screen.subcategories;

import moxy.MvpView;
import moxy.viewstate.strategy.AddToEndStrategy;
import moxy.viewstate.strategy.StateStrategyType;
import ru.zakazcoffee.shop.data.models.MainInformation;

@StateStrategyType(AddToEndStrategy.class)
public interface SubcategoriesView extends MvpView {

    void showMessage(String messageText);

    void showProgressBar();

    void hideProgressBar();

    void setSubcategories(MainInformation information);
}