package ru.zakazcoffee.shop.presentation.view.main.basket_screen;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import moxy.MvpAppCompatFragment;
import ru.zakazcoffee.shop.R;

public class BasketScreenFragment extends MvpAppCompatFragment {

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
    }
}
