package ru.zakazcoffee.shop.domain.login.new_acc_screen;

import com.jakewharton.rxbinding3.widget.TextViewTextChangeEvent;

import io.reactivex.Observable;
import io.reactivex.rxjava3.core.Maybe;
import retrofit2.Response;

public interface NewAccountInteractor {

    Maybe<Response<Object>> createNewAccount(String fullname, String email, String password);

    Observable<Boolean> controlSendButton(Observable<TextViewTextChangeEvent> fullNameEditTextListener,
                                          Observable<TextViewTextChangeEvent> emailEditTextListener,
                                          Observable<TextViewTextChangeEvent> passwordEditTextListener);
}