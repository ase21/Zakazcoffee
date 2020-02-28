package ru.zakazcoffee.shop.presentation.presenter.splash_screen;

import javax.inject.Inject;

import io.reactivex.rxjava3.disposables.CompositeDisposable;
import moxy.InjectViewState;
import moxy.MvpPresenter;
import ru.zakazcoffee.shop.presentation.view.splash_screen.SplashScreenView;

@InjectViewState
public class SplashScreenPresenter extends MvpPresenter<SplashScreenView> {

    private final CompositeDisposable compositeDisposable;

    @Inject
    SplashInteractor interactor;

    public SplashScreenPresenter() {
        compositeDisposable = new CompositeDisposable();
        App.getInstance().plusSplashComponent().inject(this);
    }

    public void checkIsUserLoggedIn() {
        compositeDisposable.add(
                interactor
                        .checkIfUserLoggedIn()
                        .subscribe(aBoolean -> {
                                    if(aBoolean){
                                        getViewState().showLoginScreen();
                                    }else {
                                        getViewState().showMainScreen();
                                    }
                                },
                                throwable -> getViewState().showLoginScreen()));

    }
}
