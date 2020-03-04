package ru.zakazcoffee.shop.presentation.presenter.login.reg_confirmation;

import io.reactivex.rxjava3.disposables.CompositeDisposable;
import moxy.MvpPresenter;
import ru.zakazcoffee.shop.presentation.view.login.reg_confirmation.RegConfirmationView;

public class RegConfirmationPresenter extends MvpPresenter<RegConfirmationView> {

    private final CompositeDisposable compositeDisposable;

    public RegConfirmationPresenter() {
        compositeDisposable = new CompositeDisposable();
//        App.getInstance().plusNewAccountComponent().inject(this);
    }

    public void destroy() {
        compositeDisposable.clear();
//        App.getInstance().clearNewAccountComponent();
    }
}
