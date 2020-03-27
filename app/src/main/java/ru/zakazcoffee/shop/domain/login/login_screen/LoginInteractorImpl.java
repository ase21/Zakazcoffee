package ru.zakazcoffee.shop.domain.login.login_screen;

import com.jakewharton.rxbinding3.widget.TextViewTextChangeEvent;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.ObservableTransformer;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;
import ru.zakazcoffee.shop.data.models.Code;
import ru.zakazcoffee.shop.data.models.RequestToken;
import ru.zakazcoffee.shop.data.models.TokenResponse;
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
    public Single<Code> login(String email, String password) {
        return networkRepository.getKey("code","https://mobileapp.zakazcoffee.ru/server/blank.html","czZCatrRSa3F0Mzo3RmpmcDBaQnIxS3REUmJuZlZkbUl6", email, password, "xyz", "all");
    }

    @Override
    public Single<TokenResponse> sendToken(String accessToken) {
        RequestToken tokenResponse = new RequestToken("authorization_code", accessToken, "czZCatrRSa3F0Mzo3RmpmcDBaQnIxS3REUmJuZlZkbUl6", "v5ZCatrRSa3F0Mto3RppmcDBaQnIxS3REpomJuZlZkbUl6", "https://mobileapp.zakazcoffee.ru/server/blank.html");
        return networkRepository.sendToken(tokenResponse);
    }

    @Override
    public Observable<Boolean> controlSendButton(Observable<TextViewTextChangeEvent> loginEditTextListener, Observable<TextViewTextChangeEvent> passwordEditTextListener) {
        return Observable.combineLatest(loginEditTextListener.compose(getChangedTextTransformer()), passwordEditTextListener.compose(getChangedTextTransformer()), (login, password) -> !login.isEmpty() && !password.isEmpty());
    }

    @Override
    public Completable saveToken(String accessToken) {
        return Completable.fromAction(() -> prefsHelper.setToken(accessToken));
    }

    private ObservableTransformer<TextViewTextChangeEvent, String> getChangedTextTransformer() {
        return upstream -> (upstream.map(textViewTextChangeEvent -> textViewTextChangeEvent.getText().toString())).startWith("");
    }
}
