package ru.zakazcoffee.shop.presentation.presenter.main.left_menu.about;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import moxy.InjectViewState;
import moxy.MvpPresenter;
import ru.zakazcoffee.shop.App;
import ru.zakazcoffee.shop.domain.main.left_menu.about.AboutUsInteractor;
import ru.zakazcoffee.shop.presentation.view.main.left_menu.about.AboutUsView;

@InjectViewState
public class AboutUsPresenter extends MvpPresenter<AboutUsView> {

    private final CompositeDisposable compositeDisposable;

    @Inject
    AboutUsInteractor interactor;

    public AboutUsPresenter() {
        compositeDisposable = new CompositeDisposable();
        App.getInstance().plusAboutUsComponent().inject(this);
    }

    public void getInformation() {
//        compositeDisposable.add(interactor.getInformation()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .doOnSubscribe(disposable -> getViewState().showProgressBar())
//                .doAfterTerminate(() -> getViewState().hideProgressBar())
//                .subscribe(information ->  getViewState().showAboutUsInfo(information),
//                        throwable -> {}));
    }

    public void destroy() {
        compositeDisposable.clear();
        App.getInstance().clearMainScreenComponent();
    }
}
