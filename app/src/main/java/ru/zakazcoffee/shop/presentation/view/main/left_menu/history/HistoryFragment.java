package ru.zakazcoffee.shop.presentation.view.main.left_menu.history;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import moxy.MvpAppCompatFragment;
import ru.zakazcoffee.shop.R;
import ru.zakazcoffee.shop.data.models.HistoricalCoffee;

public class HistoryFragment extends MvpAppCompatFragment implements HistoryView {

    @BindView(R.id.backImageButton)
    ImageButton backImageButton;
    @BindView(R.id.headerTextView)
    TextView headerTextView;
    @BindView(R.id.historyRecyclerView)
    RecyclerView historyRecyclerView;
    private Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_history, container, false);

        initUi(view);

        return view;
    }

    private void initUi(View view) {
        unbinder = ButterKnife.bind(this, view);
        headerTextView.setText("История заказов");
    }

    @Override
    public void showHistory(List<HistoricalCoffee> coffeeList) {
    }

    @OnClick(R.id.backImageButton)
    void onViewClicked() {
        getActivity().onBackPressed();
    }
}
