package ru.zakazcoffee.shop.presentation.view.main.left_menu.history;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import moxy.MvpAppCompatFragment;
import moxy.presenter.InjectPresenter;
import ru.zakazcoffee.shop.R;
import ru.zakazcoffee.shop.data.models.HistoricalCoffee;
import ru.zakazcoffee.shop.presentation.presenter.main.left_menu.history.HistoryPresenter;

public class HistoryFragment extends MvpAppCompatFragment implements HistoryView {

    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @BindView(R.id.headerTextView)
    TextView headerTextView;
    @BindView(R.id.historyRecyclerView)
    RecyclerView historyRecyclerView;

    @InjectPresenter
    HistoryPresenter presenter;
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
        presenter.getHistory();
    }

    @Override
    public void showHistory(List<HistoricalCoffee> coffeeList) {
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

    @OnClick(R.id.backImageButton)
    void onViewClicked() {
        getActivity().onBackPressed();
    }
}
