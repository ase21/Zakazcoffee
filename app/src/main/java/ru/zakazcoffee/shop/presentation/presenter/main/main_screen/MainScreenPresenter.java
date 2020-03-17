package ru.zakazcoffee.shop.presentation.presenter.main.main_screen;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.rxjava3.disposables.CompositeDisposable;
import moxy.MvpPresenter;
import ru.zakazcoffee.shop.App;
import ru.zakazcoffee.shop.data.models.Coffee;
import ru.zakazcoffee.shop.data.models.CoffeeCategory;
import ru.zakazcoffee.shop.data.models.News;
import ru.zakazcoffee.shop.domain.main.main_screen.MainScreenInteractor;
import ru.zakazcoffee.shop.presentation.view.main.main_screen.MainScreenView;

public class MainScreenPresenter extends MvpPresenter<MainScreenView> {

    private final CompositeDisposable compositeDisposable;

    @Inject
    MainScreenInteractor interactor;

    public MainScreenPresenter() {
        compositeDisposable = new CompositeDisposable();
        App.getInstance().plusMainScreenComponent().inject(this);
    }

    public void getInformation() {
        CoffeeCategory coffeeCategory = new CoffeeCategory(12, "https://static-eu.insales.ru/images/products/1/5828/285783748/large_042.jpg", "Кофе в зернах");
        CoffeeCategory coffeeCategory1 = new CoffeeCategory(13, "https://static-eu.insales.ru/images/products/1/1784/149612280/large_syrius.jpg", "Кофе в капсулах");
        CoffeeCategory coffeeCategory2 = new CoffeeCategory(13, "https://static-eu.insales.ru/images/products/1/2238/176670910/large_kofe_250_general1.jpg", "Кофе Армия России");
        List<CoffeeCategory> coffeeCategories = new ArrayList<>();
        coffeeCategories.add(coffeeCategory1);
        coffeeCategories.add(coffeeCategory2);
        coffeeCategories.add(coffeeCategory);
        coffeeCategories.add(coffeeCategory1);
        coffeeCategories.add(coffeeCategory2);
        coffeeCategories.add(coffeeCategory);
        coffeeCategories.add(coffeeCategory1);
        coffeeCategories.add(coffeeCategory2);
        coffeeCategories.add(coffeeCategory);
        getViewState().setCoffeeCategories(coffeeCategories);

        Coffee topCoffee = new Coffee(1,
                "Кофе в зернах Армия России \"АРМЕЙСКИЙ\" 1 кг",
                "https://static-eu.insales.ru/r/1ExwsxUhNbw/fit/550/550/ce/1/plain/images/products/1/853/269108053/kofe_1000_army_2.jpg@webp",
                "60% Арабика, 40% Робуста",
                "Вес 1 кг", "980.00 руб");
        Coffee topCoffee2 = new Coffee(2,
                "Кофе в зернах Армия России \"ГЕНЕРАЛЬСКИЙ\" 1 кг",
                "https://static-eu.insales.ru/r/t9wOvZHvG7M/fit/550/550/ce/1/plain/images/products/1/5322/269112522/kofe_1000_general_2.jpg@webp",
                "Арабика 100%",
                "Вес 1 кг", "1280.00 руб");
        List<Coffee> topCoffees = new ArrayList<>();
        topCoffees.add(topCoffee2);
        topCoffees.add(topCoffee);
        getViewState().setTopCoffee(topCoffees);

        News news = new News(1,
                "В Ленобласти обещают морозы и метель",
                "На дорогах ожидается гололедица, пишет 47news. В региональном управлении МЧС также предупредили, что на дорогах области ожидается гололедица и порывы ветра до 15 метров секунду. 16 и 17 марта также может идти умеренный и мокрый снег, и дуть порывистый ветер.");
        News news2 = new News(2,
                "Минпросвещения рекомендовало школам дистанционное обучение",
                "Министерство просвещения РФ направило во все регионы страны рекомендации: при необходимости следует переводить образовательный процесс на дистанционную форму обучения.");
        News news3 = new News(1,
                "В Ленобласти обещают морозы и метель",
                "На дорогах ожидается гололедица, пишет 47news. В региональном управлении МЧС также предупредили, что на дорогах области ожидается гололедица и порывы ветра до 15 метров секунду. 16 и 17 марта также может идти умеренный и мокрый снег, и дуть порывистый ветер.");
        News news4 = new News(2,
                "Минпросвещения рекомендовало школам дистанционное обучение",
                "Министерство просвещения РФ направило во все регионы страны рекомендации: при необходимости следует переводить образовательный процесс на дистанционную форму обучения.");

        List<News> newsList = new ArrayList<>();
        newsList.add(news4);
        newsList.add(news3);
        newsList.add(news2);
        newsList.add(news);
        getViewState().setNews(newsList);

        List<Coffee> lastCoffees = new ArrayList<>();
        lastCoffees.add(topCoffee2);
        lastCoffees.add(topCoffee);
        getViewState().setRecentlyWatched(lastCoffees);
    }

    public void destroy() {
        compositeDisposable.clear();
        App.getInstance().clearMainScreenComponent();
    }
}
