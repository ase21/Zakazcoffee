package ru.zakazcoffee.shop.presentation.view.login.reg_confirmation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.chaos.view.PinView;
import com.jakewharton.rxbinding3.widget.RxTextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import moxy.MvpAppCompatFragment;
import moxy.presenter.InjectPresenter;
import ru.zakazcoffee.shop.R;
import ru.zakazcoffee.shop.presentation.presenter.login.reg_confirmation.RegConfirmationPresenter;

public class RegConfirmationFragment extends MvpAppCompatFragment implements RegConfirmationView {

    @BindView(R.id.headerTextView)
    TextView headerTextView;
    @BindView(R.id.pinView)
    PinView pinView;

    @InjectPresenter
    RegConfirmationPresenter presenter;

    private Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_reg_confirmation, container, false);
        unbinder = ButterKnife.bind(this, view);
        headerTextView.setText("Подтверждение");
        presenter.listenFields(RxTextView.textChangeEvents(pinView));
        return view;
    }

    @Override
    public void showToast(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_LONG).show();
    }

    @OnClick(R.id.completeButton)
    void onCompleteButtonClicked() {
//        presenter.createNewAccount(fullNameEditText.getText().toString(),
//                emailEditText.getText().toString(),
//                passwordEditText.getText().toString());
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
