package ru.zakazcoffee.shop.presentation.presenter.main.main_screen;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
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

    public void getInformation() {
        compositeDisposable.add(interactor.getInformation()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(disposable -> getViewState().showProgressBar())
                .doAfterTerminate(() -> getViewState().hideProgressBar())
                .subscribe(mainInformation ->  getViewState().setInformation(mainInformation),
                        throwable -> {}));
    }

    public void destroy() {
        compositeDisposable.clear();
        App.getInstance().clearMainScreenComponent();
    }
}
