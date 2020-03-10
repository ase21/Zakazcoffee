package ru.zakazcoffee.shop.presentation.presenter.main.main_screen;

import javax.inject.Inject;

import io.reactivex.rxjava3.disposables.CompositeDisposable;
import moxy.MvpPresenter;
import ru.zakazcoffee.shop.App;
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
}
