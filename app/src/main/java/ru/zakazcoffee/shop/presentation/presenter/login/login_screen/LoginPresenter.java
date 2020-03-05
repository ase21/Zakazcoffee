package ru.zakazcoffee.shop.presentation.presenter.login.login_screen;

import com.jakewharton.rxbinding3.widget.TextViewTextChangeEvent;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
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
                interactor
                        .login(email, password)
                        .subscribe(response -> {
                                    // TODO: 05.03.2020 do nothing
                                },
                                throwable -> showMessage(throwable.getMessage()),
                                () -> showMessage("Try to login later")
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
                .subscribe(getViewState()::setEnableSendButton, throwable -> {});
    }
}
