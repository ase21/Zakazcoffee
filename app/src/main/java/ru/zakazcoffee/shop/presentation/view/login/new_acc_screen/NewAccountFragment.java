package ru.zakazcoffee.shop.presentation.view.login.new_acc_screen;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.jakewharton.rxbinding3.widget.RxTextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import moxy.MvpAppCompatFragment;
import moxy.presenter.InjectPresenter;
import ru.zakazcoffee.shop.R;
import ru.zakazcoffee.shop.presentation.presenter.login.new_acc_screen.NewAccountPresenter;
import ru.zakazcoffee.shop.presentation.view.login.LoginActivity;
import ru.zakazcoffee.shop.presentation.view.login.reg_confirmation.RegConfirmationFragment;

public class NewAccountFragment extends MvpAppCompatFragment implements NewAccountView {

    @BindView(R.id.headerTextView)
    TextView headerTextView;
    @BindView(R.id.fullNameEditText)
    EditText fullNameEditText;
    @BindView(R.id.emailEditText)
    EditText emailEditText;
    @BindView(R.id.passwordEditText)
    EditText passwordEditText;
    @BindView(R.id.createButton)
    Button createButton;

    @InjectPresenter
    NewAccountPresenter presenter;

    private Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_new_account, container, false);
        unbinder = ButterKnife.bind(this, view);
        headerTextView.setText("Регистрация");
        presenter.listenFields(RxTextView.textChangeEvents(fullNameEditText), RxTextView.textChangeEvents(emailEditText), RxTextView.textChangeEvents(passwordEditText));
        return view;
    }

    @Override
    public void showToast(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void setEnableSendButton(Boolean isUnable) {
        createButton.setEnabled(isUnable);
    }

    @OnClick(R.id.createButton)
    void onCreateButtonClicked() {
//        presenter.createNewAccount(fullNameEditText.getText().toString(),
//                emailEditText.getText().toString(),
//                passwordEditText.getText().toString());
        ((LoginActivity) getActivity()).showFragment(new RegConfirmationFragment());
    }

    @OnClick(R.id.backImageButton)
    void onBackImageViewClicked() {
        getActivity().onBackPressed();
    }

    @Override
    public void onDestroy() {
        presenter.destroy();
        super.onDestroy();
    }

}
