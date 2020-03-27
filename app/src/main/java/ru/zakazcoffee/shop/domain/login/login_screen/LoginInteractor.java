package ru.zakazcoffee.shop.domain.login.login_screen;

import com.jakewharton.rxbinding3.widget.TextViewTextChangeEvent;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.rxjava3.core.Maybe;
import retrofit2.Response;
import ru.zakazcoffee.shop.data.models.Code;
import ru.zakazcoffee.shop.data.models.TokenResponse;

public interface LoginInteractor {
    Single<Code> login(String email, String password);

    Single<TokenResponse> sendToken(String accessToken);

    Observable<Boolean> controlSendButton(Observable<TextViewTextChangeEvent> loginEditTextListener,
                                          Observable<TextViewTextChangeEvent> passwordEditTextListener);

    Completable saveToken(String accessToken);
}
