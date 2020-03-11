package ru.zakazcoffee.shop.presentation.view.main.main_screen;

import java.util.List;

import moxy.MvpView;
import moxy.viewstate.strategy.AddToEndStrategy;
import moxy.viewstate.strategy.StateStrategyType;
import ru.zakazcoffee.shop.data.models.*;

@StateStrategyType(AddToEndStrategy.class)
public interface MainScreenView extends MvpView {

    void showMessage(String messageText);

    void showProgressBar();

    void hideProgressBar();

    void setBanners(List<Banner> banners);

    void setCoffeeCategories(List<CoffeeCategory> categories);

    void setTopCoffee(List<Coffee> topCoffees);

    void setNews(List<News> news);

    void setRecentlyWatched(List<Coffee> recentlyWatchedCoffees);
}
