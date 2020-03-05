package ru.zakazcoffee.shop.domain.login.login_screen;

import com.jakewharton.rxbinding3.widget.TextViewTextChangeEvent;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableTransformer;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Maybe;
import retrofit2.Response;
import ru.zakazcoffee.shop.data.network.NetworkRepository;
import ru.zakazcoffee.shop.data.shared_prefs.PrefsHelper;

public class LoginInteractorImpl implements LoginInteractor {

    private final NetworkRepository networkRepository;
    private final PrefsHelper prefsHelper;

    @Inject
    LoginInteractorImpl(NetworkRepository networkRepository, PrefsHelper prefsHelper) {
        this.networkRepository = networkRepository;
        this.prefsHelper = prefsHelper;
    }
    @Override
    public Maybe<Response<Object>> login(String email, String password) {
        return null;
    }

    @Override
    public Completable saveToken(String accessToken) {
        return null;
    }

    @Override
    public Observable<Boolean> controlSendButton(Observable<TextViewTextChangeEvent> loginEditTextListener, Observable<TextViewTextChangeEvent> passwordEditTextListener) {
        return Observable.combineLatest(loginEditTextListener.compose(getChangedTextTransformer()), passwordEditTextListener.compose(getChangedTextTransformer()), (login, password) -> !login.isEmpty() && !password.isEmpty());
    }

    private ObservableTransformer<TextViewTextChangeEvent, String> getChangedTextTransformer() {
        return upstream -> (upstream.map(textViewTextChangeEvent -> textViewTextChangeEvent.getText().toString())).startWith("");
    }
}
