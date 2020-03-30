package ru.zakazcoffee.shop.presentation.view.main.left_menu.total_rules;

import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
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
import ru.zakazcoffee.shop.presentation.presenter.main.left_menu.total_rules.TotalRulesPresenter;

public class TotalRulesFragment extends MvpAppCompatFragment implements TotalRulesView {

    @BindView(R.id.headerTextView)
    TextView headerTextView;
    @BindView(R.id.rulesWebView)
    WebView rulesWebView;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    @InjectPresenter
    TotalRulesPresenter presenter;

    private Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_rules, container, false);

        initUi(view);

        return view;
    }

    private void initUi(View view) {
        unbinder = ButterKnife.bind(this, view);
        headerTextView.setText("Правила магазина и договор");
        presenter.showRules();
    }

    @Override
    public void showRules(String rules) {
        rulesWebView.loadDataWithBaseURL(null, Html.fromHtml(rules).toString(), "text/html", "utf-8", null);
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
