package ru.zakazcoffee.shop.domain.login.login_screen;

import com.jakewharton.rxbinding3.widget.TextViewTextChangeEvent;

import io.reactivex.Observable;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Maybe;
import retrofit2.Response;

public interface LoginInteractor {
    Maybe<Response<Object>> login(String email, String password);

    Completable saveToken(String accessToken);

    Observable<Boolean> controlSendButton(Observable<TextViewTextChangeEvent> loginEditTextListener,
                                          Observable<TextViewTextChangeEvent> passwordEditTextListener);
}
