package ru.zakazcoffee.shop.presentation.view.main.left_menu.total_rules;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import moxy.MvpAppCompatFragment;
import ru.zakazcoffee.shop.R;

public class TotalRulesFragment extends MvpAppCompatFragment implements TotalRulesView {

    @BindView(R.id.headerTextView)
    TextView headerTextView;
    @BindView(R.id.rulesTextView)
    TextView rulesTextView;
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
        showRules("тут будут правила");
    }

    @Override
    public void showRules(String rules) {
        rulesTextView.setText(rules);
    }

    @OnClick(R.id.backImageButton)
    void onViewClicked() {
        getActivity().onBackPressed();
    }
}
