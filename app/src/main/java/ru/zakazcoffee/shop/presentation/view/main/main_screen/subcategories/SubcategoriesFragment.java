package ru.zakazcoffee.shop.presentation.view.main.main_screen.subcategories;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import moxy.MvpAppCompatFragment;
import moxy.presenter.InjectPresenter;
import ru.zakazcoffee.shop.R;
import ru.zakazcoffee.shop.data.models.MainInformation;
import ru.zakazcoffee.shop.presentation.presenter.main.main_screen.subcategories.SubcategoriesPresenter;

public class SubcategoriesFragment extends MvpAppCompatFragment implements SubcategoriesView {

    private static final String ID = "id";
    private static final String NAME = "name";

    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @BindView(R.id.headerTextView)
    TextView headerTextView;
    @BindView(R.id.subcategoriesRecyclerView)
    RecyclerView subcategoriesRecyclerView;

    @InjectPresenter
    SubcategoriesPresenter presenter;

    private Unbinder unbinder;

    private int id;
    private String name;

    public static Fragment newInstance(String name, int id) {
        SubcategoriesFragment fragment = new SubcategoriesFragment();
        Bundle args = new Bundle();
        args.putInt(ID, id);
        args.putString(NAME, name);
        fragment.setArguments(args);
        return  fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            id = getArguments().getInt(ID);
            name = getArguments().getString(NAME, "Категории");
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_subcategories, container, false);
        presenter.showCategoreis(id);
        initUi(view);
        return view;
    }

    private void initUi(View view) {
        unbinder = ButterKnife.bind(this, view);
        headerTextView.setText(name);
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
    public void setSubcategories(MainInformation information) {

    }
}
