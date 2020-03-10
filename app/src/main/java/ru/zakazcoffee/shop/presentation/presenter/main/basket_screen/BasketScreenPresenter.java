package ru.zakazcoffee.shop.presentation.presenter.main.basket_screen;

import javax.inject.Inject;

import io.reactivex.rxjava3.disposables.CompositeDisposable;
import moxy.MvpPresenter;
import ru.zakazcoffee.shop.App;
import ru.zakazcoffee.shop.domain.main.basket_screen.BasketScreenInteractor;
import ru.zakazcoffee.shop.presentation.view.main.main_screen.MainScreenView;

public class BasketScreenPresenter extends MvpPresenter<MainScreenView> {

    private final CompositeDisposable compositeDisposable;

    @Inject
    BasketScreenInteractor interactor;

    public BasketScreenPresenter() {
        compositeDisposable = new CompositeDisposable();
        App.getInstance().plusBasketScreenComponent().inject(this);
    }
}
