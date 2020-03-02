package ru.zakazcoffee.shop.presentation.view.login.new_acc_screen;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.textfield.TextInputEditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import moxy.MvpAppCompatFragment;
import moxy.presenter.InjectPresenter;
import ru.zakazcoffee.shop.R;
import ru.zakazcoffee.shop.presentation.presenter.login.new_acc_screen.NewAccountPresenter;

public class NewAccountFragment extends MvpAppCompatFragment implements NewAccountView {

    @BindView(R.id.fullNameEditText)
    TextInputEditText fullNameEditText;
    @BindView(R.id.emailEditText)
    TextInputEditText emailEditText;
    @BindView(R.id.passwordEditText)
    TextInputEditText passwordEditText;

    @InjectPresenter
    NewAccountPresenter presenter;

    private Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_new_account, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void showToast(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_LONG).show();
    }

    @OnClick(R.id.createButton)
    void onCreateButtonClicked() {
        presenter.createNewAccount(fullNameEditText.getText().toString(),
                emailEditText.getText().toString(),
                passwordEditText.getText().toString());
    }

    @Override
    public void onDestroy() {
        presenter.destroy();
        super.onDestroy();
    }

}
