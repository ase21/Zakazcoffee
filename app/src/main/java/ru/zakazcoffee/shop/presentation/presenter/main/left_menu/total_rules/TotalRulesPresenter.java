package ru.zakazcoffee.shop.presentation.presenter.main.left_menu.total_rules;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import moxy.MvpPresenter;
import ru.zakazcoffee.shop.App;
import ru.zakazcoffee.shop.domain.main.left_menu.total_rules.TotalRulesInteractor;
import ru.zakazcoffee.shop.presentation.view.main.left_menu.total_rules.TotalRulesView;

public class TotalRulesPresenter extends MvpPresenter<TotalRulesView> {

    private final CompositeDisposable compositeDisposable;

    @Inject
    TotalRulesInteractor interactor;

    public TotalRulesPresenter() {
        compositeDisposable = new CompositeDisposable();
        App.getInstance().plusTotalRulesComponent().inject(this);
    }

    public void showRules() {
        compositeDisposable.add(interactor.getTotalRules()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(disposable -> getViewState().showProgressBar())
                .doAfterTerminate(() -> getViewState().hideProgressBar())
                .subscribe(rules -> getViewState().showRules(rules.getMessage()),
                        throwable -> getViewState().showMessage(throwable.getMessage())));
    }

    public void destroy() {
        compositeDisposable.clear();
        App.getInstance().clearTotalRulesComponent();
    }
}
