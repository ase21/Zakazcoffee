package ru.zakazcoffee.shop.presentation.view.login.login_screen;

import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextWatcher;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import moxy.MvpAppCompatFragment;
import moxy.presenter.InjectPresenter;
import ru.zakazcoffee.shop.R;
import ru.zakazcoffee.shop.presentation.presenter.login.login_screen.LoginPresenter;
import ru.zakazcoffee.shop.presentation.view.login.LoginActivity;
import ru.zakazcoffee.shop.presentation.view.login.new_acc_screen.NewAccountFragment;

public class LoginScreenFragment extends MvpAppCompatFragment implements LoginScreenView {

    @BindView(R.id.loginEditText)
    EditText loginEditText;
    @BindView(R.id.passwordEditText)
    EditText passwordEditText;
    @BindView(R.id.newAccountTextView)
    TextView newAccountTextView;
    @InjectPresenter
    LoginPresenter presenter;

    private Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        unbinder = ButterKnife.bind(this, view);
        SpannableString s = new SpannableString(getResources().getString(R.string.new_here_create_an_account));
        s.setSpan(new StyleSpan(Typeface.BOLD), 10, s.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        s.setSpan(new UnderlineSpan(), 10, s.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        newAccountTextView.setText(s);
        loginEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.d("text", "isActivated: " + loginEditText.isActivated());
                Log.d("text", "isFocused: " + loginEditText.isFocused());
                Log.d("text", "isPressed: " + loginEditText.isPressed());
//                Log.d("text", "isActivated: " + loginEditText.isActivated());
//                Log.d("text", "isActivated: " + loginEditText.isActivated());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        return view;
    }

    @OnClick(R.id.loginButton)
    void onLoginButtonClicked() {
        presenter.login(loginEditText.getText().toString(), passwordEditText.getText().toString());
    }

    @OnClick(R.id.newAccountTextView)
    void onNewAccountTextViewClicked() {
        ((LoginActivity) getActivity()).showFragment(new NewAccountFragment());
    }

    @Override
    public void showToast(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showMainActivity() {
        ((LoginActivity) getActivity()).showMainScreen();
    }

    @Override
    public void onDestroy() {
        presenter.destroy();
        super.onDestroy();
    }
}
