package ru.zakazcoffee.shop.presentation.presenter.main.profile_screen;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import moxy.MvpPresenter;
import ru.zakazcoffee.shop.App;
import ru.zakazcoffee.shop.domain.main.profile_screen.ProfileScreenInteractor;
import ru.zakazcoffee.shop.presentation.view.main.profile_screen.ProfileScreenView;

public class ProfileScreenPresenter extends MvpPresenter<ProfileScreenView> {

    private final CompositeDisposable compositeDisposable;

    @Inject
    ProfileScreenInteractor interactor;

    public ProfileScreenPresenter() {
        compositeDisposable = new CompositeDisposable();
        App.getInstance().plusProfileScreenComponent().inject(this);
    }

    public void onExitButtonClicked() {
        compositeDisposable.add(interactor.clearInformation()
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> getViewState().exit(), throwable -> getViewState().showMessage(throwable.getMessage())));
    }

    public void destroy() {
        compositeDisposable.clear();
        App.getInstance().clearProfileScreenComponent();
    }

    public void getInformationAboutUser() {
        compositeDisposable.add(interactor.getInformation()
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(user -> getViewState().showInformationAboutUser(user), throwable -> getViewState().showMessage(throwable.getMessage())));
    }
}
