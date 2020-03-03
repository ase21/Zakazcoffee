package ru.zakazcoffee.shop.presentation.view.splash_screen;

import android.content.Intent;
import android.os.Bundle;

import moxy.MvpAppCompatActivity;
import moxy.presenter.InjectPresenter;
import ru.zakazcoffee.shop.MainActivity;
import ru.zakazcoffee.shop.R;
import ru.zakazcoffee.shop.presentation.presenter.splash_screen.SplashScreenPresenter;
import ru.zakazcoffee.shop.presentation.view.login.LoginActivity;

public class SplashScreenActivity extends MvpAppCompatActivity implements SplashScreenView{

    @InjectPresenter
    SplashScreenPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        presenter.checkIsUserLoggedIn();
        showLoginScreen();
    }

    @Override
    public void showMainScreen() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void showLoginScreen() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}
