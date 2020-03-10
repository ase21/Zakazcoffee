package ru.zakazcoffee.shop.presentation.presenter.main.profile_screen;

import javax.inject.Inject;

import io.reactivex.rxjava3.disposables.CompositeDisposable;
import moxy.MvpPresenter;
import ru.zakazcoffee.shop.App;
import ru.zakazcoffee.shop.domain.main.profile_screen.ProfileScreenInteractor;
import ru.zakazcoffee.shop.presentation.view.main.main_screen.MainScreenView;

public class ProfileScreenPresenter extends MvpPresenter<MainScreenView> {

    private final CompositeDisposable compositeDisposable;

    @Inject
    ProfileScreenInteractor interactor;

    public ProfileScreenPresenter() {
        compositeDisposable = new CompositeDisposable();
        App.getInstance().plusProfileScreenComponent().inject(this);
    }
}
