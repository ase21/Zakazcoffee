package ru.zakazcoffee.shop.domain.login.new_acc_screen;

import com.jakewharton.rxbinding3.widget.TextViewTextChangeEvent;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableTransformer;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.schedulers.Schedulers;
import retrofit2.Response;
import ru.zakazcoffee.shop.data.network.NetworkRepository;

public class NewAccountInteractorImpl implements NewAccountInteractor {

    private final NetworkRepository networkRepository;

    @Inject
    public NewAccountInteractorImpl(NetworkRepository networkRepository) {
        this.networkRepository = networkRepository;
    }

    @Override
    public Maybe<Response<Object>> createNewAccount(String fullname, String email, String password) {
        return networkRepository.createNewAccount(fullname)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<Boolean> controlSendButton(Observable<TextViewTextChangeEvent> fullNameEditTextListener, Observable<TextViewTextChangeEvent> emailEditTextListener, Observable<TextViewTextChangeEvent> passwordEditTextListener) {
        return Observable.combineLatest(fullNameEditTextListener.compose(getChangedTextTransformer()),
                emailEditTextListener.compose(getChangedTextTransformer()),
                passwordEditTextListener.compose(getChangedTextTransformer()), (fullname, email, password) -> !fullname.isEmpty() && !email.isEmpty() && !password.isEmpty());
    }

    private ObservableTransformer<TextViewTextChangeEvent, String> getChangedTextTransformer() {
        return upstream -> (upstream.map(textViewTextChangeEvent -> textViewTextChangeEvent.getText().toString())).startWith("");
    }
}
