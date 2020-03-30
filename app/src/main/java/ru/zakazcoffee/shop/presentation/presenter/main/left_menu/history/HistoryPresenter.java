package ru.zakazcoffee.shop.presentation.presenter.main.left_menu.history;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import moxy.MvpPresenter;
import ru.zakazcoffee.shop.App;
import ru.zakazcoffee.shop.domain.main.left_menu.history.HistoryInteractor;
import ru.zakazcoffee.shop.presentation.view.main.left_menu.history.HistoryView;

public class HistoryPresenter extends MvpPresenter<HistoryView> {

    private final CompositeDisposable compositeDisposable;

    @Inject
    HistoryInteractor interactor;

    public HistoryPresenter() {
        compositeDisposable = new CompositeDisposable();
        App.getInstance().plusHistoryComponent().inject(this);
    }

    public void getHistory() {
        compositeDisposable.add(interactor.getHistory()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(disposable -> getViewState().showProgressBar())
                .doAfterTerminate(() -> getViewState().hideProgressBar())
                .subscribe(aVoid -> {},
                        throwable -> getViewState().showMessage(throwable.getMessage())));
    }

    public void destroy() {
        compositeDisposable.clear();
        App.getInstance().clearHistoryComponent();
    }
}
