package ru.zakazcoffee.shop.presentation.view.main.left_menu.delivery_rules;

import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import moxy.MvpAppCompatFragment;
import ru.zakazcoffee.shop.R;

public class DeliveryRulesFragment extends MvpAppCompatFragment implements DeliveryRulesView {

    @BindView(R.id.headerTextView)
    TextView headerTextView;
    @BindView(R.id.rulesWebView)
    WebView rulesWebView;
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
        headerTextView.setText("Правила доставки");
        showRules("тут будут правила");
    }

    @Override
    public void showRules(String rules) {
        rulesWebView.loadDataWithBaseURL(null, Html.fromHtml(rules).toString(), "text/html", "utf-8", null);
    }

    @OnClick(R.id.backImageButton)
    void onViewClicked() {
        getActivity().onBackPressed();
    }
}
