package ru.zakazcoffee.shop.presentation.presenter.login.login_screen;

import com.jakewharton.rxbinding3.widget.TextViewTextChangeEvent;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import moxy.InjectViewState;
import moxy.MvpPresenter;
import ru.zakazcoffee.shop.App;
import ru.zakazcoffee.shop.domain.login.login_screen.LoginInteractor;
import ru.zakazcoffee.shop.presentation.view.login.login_screen.LoginScreenView;

@InjectViewState
public class LoginPresenter extends MvpPresenter<LoginScreenView> {

    private final CompositeDisposable compositeDisposable;

    @Inject
    LoginInteractor interactor;

    public LoginPresenter() {
        compositeDisposable = new CompositeDisposable();
        App.getInstance().plusLoginComponent().inject(this);
    }

    public void login(String email, String password){
        compositeDisposable.add(
                interactor.login(email, password)
                        .flatMap(code -> interactor.sendToken(code.getCode()))
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .doOnSuccess(tokenResponse -> saveToken(tokenResponse.getAccessToken()))
                        .subscribe(
                                tokenResponse -> getViewState().showMainActivity(),
                                throwable -> showMessage(throwable.getMessage())
                        )
        );
    }

    private void saveToken(String accessToken) {
        compositeDisposable.add(interactor.saveToken(accessToken).subscribe(() -> {}, throwable -> {}));
    }

    private void showMessage(String message) {
        getViewState().showToast(message);
    }

    public void destroy() {
        compositeDisposable.clear();
        App.getInstance().clearLoginComponent();
    }

    public void listenFields(Observable<TextViewTextChangeEvent> loginEditTextListener, Observable<TextViewTextChangeEvent> passwordEditTextListener) {
        interactor.controlSendButton(loginEditTextListener, passwordEditTextListener)
                .subscribe(getViewState()::setEnableSendButton, throwable -> showMessage(throwable.getMessage()));
    }
}
