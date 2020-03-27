package ru.zakazcoffee.shop.presentation.view.main.left_menu.about;

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
import ru.zakazcoffee.shop.presentation.presenter.main.left_menu.about.AboutUsPresenter;

public class AboutUsFragment extends MvpAppCompatFragment implements AboutUsView {

    @BindView(R.id.headerTextView)
    TextView headerTextView;
    @BindView(R.id.aboutUsTextView)
    TextView rulesTextView;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    @InjectPresenter
    AboutUsPresenter presenter;

    private Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_about_us, container, false);

        initUi(view);

        return view;
    }

    private void initUi(View view) {
        unbinder = ButterKnife.bind(this, view);
        headerTextView.setText("О нас");
    }

    @Override
    public void onStart() {
        super.onStart();
        presenter.getAboutUsInfo();
    }

    @Override
    public void showAboutUsInfo(String rules) {
        rulesTextView.setText(rules);
    }

    @OnClick(R.id.backImageButton)
    void onViewClicked() {
        getActivity().onBackPressed();
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
    public void onDestroy() {
        presenter.destroy();
        super.onDestroy();
    }
}
