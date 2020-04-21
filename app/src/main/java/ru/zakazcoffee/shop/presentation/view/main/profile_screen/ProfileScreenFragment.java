package ru.zakazcoffee.shop.presentation.view.main.profile_screen;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
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
import ru.zakazcoffee.shop.data.models.User;
import ru.zakazcoffee.shop.presentation.presenter.main.profile_screen.ProfileScreenPresenter;
import ru.zakazcoffee.shop.presentation.view.main.MainActivity;
import ru.zakazcoffee.shop.presentation.view.main.left_menu.history.HistoryFragment;

public class ProfileScreenFragment extends MvpAppCompatFragment implements ProfileScreenView {

    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @BindView(R.id.headerTextView)
    TextView headerTextView;

    @InjectPresenter
    ProfileScreenPresenter presenter;

    private Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile_screen, container, false);
        initUi(view);

        return view;
    }

    private void initUi(View view) {
        unbinder = ButterKnife.bind(this, view);
        headerTextView.setText("Профиль");
        presenter.getInformationAboutUser();
    }


    @OnClick(R.id.historyTextView)
    void onHistoryTextViewClicked() {
        ((MainActivity) getActivity()).showFragment(new HistoryFragment());
    }

    @OnClick(R.id.exitButton)
    void onExitButtonClicked() {
        presenter.onExitButtonClicked();
    }

    @Override
    public void exit() {
        ((MainActivity) getActivity()).showLoginScreen();
    }

    @Override
    public void showMessage(String messageText) {
        Toast.makeText(getContext(), messageText, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showInformationAboutUser(User user) {

    }

    @Override
    public void onDestroy() {
        presenter.destroy();
        super.onDestroy();
    }
}
