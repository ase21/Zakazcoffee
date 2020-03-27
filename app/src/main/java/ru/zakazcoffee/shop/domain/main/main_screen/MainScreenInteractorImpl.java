package ru.zakazcoffee.shop.domain.main.main_screen;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;
import ru.zakazcoffee.shop.data.models.Banner;
import ru.zakazcoffee.shop.data.models.Coffee;
import ru.zakazcoffee.shop.data.models.CoffeeCategory;
import ru.zakazcoffee.shop.data.models.MainInformation;
import ru.zakazcoffee.shop.data.models.News;
import ru.zakazcoffee.shop.data.network.NetworkRepository;
import ru.zakazcoffee.shop.data.shared_prefs.PrefsHelper;

public class MainScreenInteractorImpl implements MainScreenInteractor {

    private final NetworkRepository networkRepository;
    private final PrefsHelper prefsHelper;

    @Inject
    MainScreenInteractorImpl(NetworkRepository networkRepository, PrefsHelper prefsHelper) {
        this.networkRepository = networkRepository;
        this.prefsHelper = prefsHelper;
    }

    @Override
    public Single<MainInformation> getInformation() {
        return Single.zip(getBanner(), getCategoriesList(), getTopCoffee(), getNews(), getLastSeenCoffee(), this::zipAll);
    }

    private MainInformation zipAll(List<Banner> banners,
                     List<CoffeeCategory> coffeeCategories,
                     List<Coffee> topCoffees, List<News> news, List<Coffee> lastSeenCoffees) {
        return new MainInformation(banners, coffeeCategories, topCoffees, news, lastSeenCoffees);
    }

    private Single<List<Banner>> getBanner(){

        return Single.fromCallable(ArrayList::new);
//        return networkRepository.sendRequest("home.get", prefsHelper.getToken(), "v5ZCatrRSa3F0Mto3RppmcDBaQnIxS3REpomJuZlZkbUl6", "czZCatrRSa3F0Mzo3RmpmcDBaQnIxS3REUmJuZlZkbUl6");
    }

    private Single<List<CoffeeCategory>> getCategoriesList(){
        return networkRepository.sendCategoryRequest("category.get", prefsHelper.getToken(), "v5ZCatrRSa3F0Mto3RppmcDBaQnIxS3REpomJuZlZkbUl6", "czZCatrRSa3F0Mzo3RmpmcDBaQnIxS3REUmJuZlZkbUl6");
    }

    private Single<List<Coffee>> getTopCoffee(){
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
        return Single.fromCallable(() -> topCoffees);
//        return networkRepository.sendRequest("home.get", prefsHelper.getToken(), "v5ZCatrRSa3F0Mto3RppmcDBaQnIxS3REpomJuZlZkbUl6", "czZCatrRSa3F0Mzo3RmpmcDBaQnIxS3REUmJuZlZkbUl6");
    }

    private Single<List<News>> getNews(){
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
        return Single.fromCallable(() -> newsList);
//        return networkRepository.sendRequest("home.get", prefsHelper.getToken(), "v5ZCatrRSa3F0Mto3RppmcDBaQnIxS3REpomJuZlZkbUl6", "czZCatrRSa3F0Mzo3RmpmcDBaQnIxS3REUmJuZlZkbUl6");
    }

    private Single<List<Coffee>> getLastSeenCoffee(){
        List<Coffee> lastCoffees = new ArrayList<>();
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
        lastCoffees.add(topCoffee2);
        lastCoffees.add(topCoffee);
        return Single.fromCallable(() -> lastCoffees);
//        return networkRepository.sendRequest("home.get", prefsHelper.getToken(), "v5ZCatrRSa3F0Mto3RppmcDBaQnIxS3REpomJuZlZkbUl6", "czZCatrRSa3F0Mzo3RmpmcDBaQnIxS3REUmJuZlZkbUl6");
    }


}
