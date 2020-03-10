package ru.zakazcoffee.shop;

import android.app.Application;

import ru.zakazcoffee.shop.di.app.AppComponent;
import ru.zakazcoffee.shop.di.app.DaggerAppComponent;
import ru.zakazcoffee.shop.di.login.login_screen.LoginComponent;
import ru.zakazcoffee.shop.di.login.new_acc.NewAccountComponent;
import ru.zakazcoffee.shop.di.main.basket_screen.BasketScreenComponent;
import ru.zakazcoffee.shop.di.main.main_screen.MainScreenComponent;
import ru.zakazcoffee.shop.di.main.profile_screen.ProfileScreenComponent;
import ru.zakazcoffee.shop.di.splash_screen.SplashComponent;

public class App extends Application {

    private static App instance;

    private AppComponent appComponent;
    private SplashComponent splashComponent;
    private LoginComponent loginComponent;
    private NewAccountComponent newAccountComponent;
    private MainScreenComponent mainScreenComponent;
    private BasketScreenComponent basketScreenComponent;
    private ProfileScreenComponent profileScreenComponent;

    public static App getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        initDagger();
    }

    private void initDagger() {
        appComponent = DaggerAppComponent
                .factory()
                .create(this);
    }

    public SplashComponent plusSplashComponent() {
        if (splashComponent == null)
            splashComponent = appComponent.plusSplashComponent();
        return splashComponent;
    }

    public void clearSplashComponent() {
        splashComponent = null;
    }

    public LoginComponent plusLoginComponent() {
        if (loginComponent == null)
            loginComponent = appComponent.plusLoginComponent();
        return loginComponent;
    }

    public void clearLoginComponent() {
        loginComponent = null;
    }

    public NewAccountComponent plusNewAccountComponent() {
        if (newAccountComponent == null)
            newAccountComponent = appComponent.plusNewAccountComponent();
        return newAccountComponent;
    }

    public void clearNewAccountComponent() {
        newAccountComponent = null;
    }

    public MainScreenComponent plusMainScreenComponent() {
        if (mainScreenComponent == null)
            mainScreenComponent = appComponent.plusMainScreenComponent();
        return mainScreenComponent;
    }

    public void clearMainScreenComponent() {
        mainScreenComponent = null;
    }

    public BasketScreenComponent plusBasketScreenComponent() {
        if (basketScreenComponent == null)
            basketScreenComponent = appComponent.plusBasketScreenComponent();
        return basketScreenComponent;
    }

    public void clearBasketScreenComponent() {
        basketScreenComponent = null;
    }

    public ProfileScreenComponent plusProfileScreenComponent() {
        if (profileScreenComponent == null)
            profileScreenComponent = appComponent.plusProfileScreenComponent();
        return profileScreenComponent;
    }

    public void clearProfileScreenComponent() {
        profileScreenComponent = null;
    }
}
