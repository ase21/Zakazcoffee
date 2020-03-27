package ru.zakazcoffee.shop.presentation.presenter.login.new_acc_screen;

import com.jakewharton.rxbinding3.widget.TextViewTextChangeEvent;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import moxy.InjectViewState;
import moxy.MvpPresenter;
import ru.zakazcoffee.shop.App;
import ru.zakazcoffee.shop.domain.login.new_acc_screen.NewAccountInteractor;
import ru.zakazcoffee.shop.presentation.view.login.new_acc_screen.NewAccountView;

@InjectViewState
public class NewAccountPresenter extends MvpPresenter<NewAccountView> {

    private final CompositeDisposable compositeDisposable;

    @Inject
    NewAccountInteractor interactor;

    public NewAccountPresenter() {
        compositeDisposable = new CompositeDisposable();
        App.getInstance().plusNewAccountComponent().inject(this);
    }

    public void createNewAccount(String fullname, String email, String password) {
        compositeDisposable.add(interactor.createNewAccount(fullname, email, password)
                        .subscribe(response -> getViewState().showRegConfirmationFragment(),
                                throwable -> showMessage(throwable.getMessage()))
        );
    }

    private void showMessage(String message) {
        getViewState().showToast(message);
    }

    public void destroy() {
        compositeDisposable.clear();
        App.getInstance().clearNewAccountComponent();
    }

    public void listenFields(Observable<TextViewTextChangeEvent> fullNameEditTextListener,
                             Observable<TextViewTextChangeEvent> emailEditTextListener,
                             Observable<TextViewTextChangeEvent> passwordEditTextListener) {
        interactor.controlSendButton(fullNameEditTextListener, emailEditTextListener, passwordEditTextListener)
                .subscribe(getViewState()::setEnableSendButton, throwable -> {});
    }
}
