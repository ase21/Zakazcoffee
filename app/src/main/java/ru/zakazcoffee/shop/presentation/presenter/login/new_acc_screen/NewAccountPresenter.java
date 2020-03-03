package ru.zakazcoffee.shop.presentation.presenter.login.new_acc_screen;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.disposables.CompositeDisposable;
import moxy.InjectViewState;
import moxy.MvpPresenter;
import ru.zakazcoffee.shop.presentation.view.login.new_acc_screen.NewAccountView;

@InjectViewState
public class NewAccountPresenter extends MvpPresenter<NewAccountView> {

    private final CompositeDisposable compositeDisposable;

//    @Inject
//    NewAccountInteractor interactor;

    public NewAccountPresenter() {
        compositeDisposable = new CompositeDisposable();
//        App.getInstance().plusNewAccountComponent().inject(this);
    }

    public void createNewAccount(String fullname, String email, String password) {
//        compositeDisposable.add(interactor.createNewAccount(fullname, email, password)
//                        .subscribe(response -> {
//                                    switch (response.code()) {
//                                        case 400: {
//                                            ResponseBody responseBody = response.errorBody();
//                                            findErrors(responseBody.string());
//
////                                    DetailMessageErrorResponse errorResponse = new Gson().fromJson(responseBody.string(), DetailMessageErrorResponse.class);
//                                            break;
//                                        }
//                                        case 200: {
//                                            NewAccountSuccessResponse successResponse = (NewAccountSuccessResponse) response.body();
//                                            break;
//                                        }
//                                        default: {
//                                            NewAccountPresenter.this.showMessage(response.message());
//                                        }
//                                    }
//                                },
//                                throwable -> showMessage(throwable.getMessage()),
//                                () -> NewAccountPresenter.this.showMessage("Try to create account later"))
//        );
    }

    private void findErrors(String string) {
        String nahcalnayaStroka = string.replaceAll("\"", "");

        List<String> errorStringList = new ArrayList<>();

        if (nahcalnayaStroka.contains("email")) {
            int beginIndex = nahcalnayaStroka.indexOf("email");
            String substring = nahcalnayaStroka.substring(beginIndex);
            beginIndex = substring.indexOf("[");
            int lastIndex = substring.indexOf("]");
            errorStringList.add(substring.substring(beginIndex + 1, lastIndex));
        }

        if (nahcalnayaStroka.contains("password")) {
            int beginIndex = nahcalnayaStroka.indexOf("password");
            String substring = nahcalnayaStroka.substring(beginIndex);
            beginIndex = substring.indexOf("[");
            int lastIndex = substring.indexOf("]");
            errorStringList.add(substring.substring(beginIndex + 1, lastIndex));
        }

        if (nahcalnayaStroka.contains("sponsor_id")) {
            int beginIndex = nahcalnayaStroka.indexOf("sponsor_id");
            String substring = nahcalnayaStroka.substring(beginIndex);
            beginIndex = substring.indexOf("[");
            int lastIndex = substring.indexOf("]");
            errorStringList.add(substring.substring(beginIndex + 1, lastIndex));
        }

        StringBuilder resultErrorString = new StringBuilder();
        for (int i = 0; i < errorStringList.size(); i++) {
            if (i!=0){
                resultErrorString.append("\n");
            }
            resultErrorString.append(errorStringList.get(i));
        }
        showMessage(resultErrorString.toString());
    }

    private void showMessage(String message) {
        getViewState().showToast(message);
    }

    public void destroy() {
        compositeDisposable.clear();
//        App.getInstance().clearNewAccountComponent();
    }
}
