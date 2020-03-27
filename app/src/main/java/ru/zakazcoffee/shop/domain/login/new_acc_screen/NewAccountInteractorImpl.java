package ru.zakazcoffee.shop.domain.login.new_acc_screen;

import com.jakewharton.rxbinding3.widget.TextViewTextChangeEvent;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableTransformer;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;
import ru.zakazcoffee.shop.data.network.NetworkRepository;

public class NewAccountInteractorImpl implements NewAccountInteractor {

    private final NetworkRepository networkRepository;

    @Inject
    NewAccountInteractorImpl(NetworkRepository networkRepository) {
        this.networkRepository = networkRepository;
    }

    @Override
    public Single<Response<Void>> createNewAccount(String fullname, String email, String password) {
        return networkRepository.createNewAccount("register", fullname, email, password, "all")
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
