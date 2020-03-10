package ru.zakazcoffee.shop.di.app;

import android.content.Context;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import ru.zakazcoffee.shop.di.login.login_screen.LoginComponent;
import ru.zakazcoffee.shop.di.login.new_acc.NewAccountComponent;
import ru.zakazcoffee.shop.di.main.basket_screen.BasketScreenComponent;
import ru.zakazcoffee.shop.di.main.main_screen.MainScreenComponent;
import ru.zakazcoffee.shop.di.main.profile_screen.ProfileScreenComponent;
import ru.zakazcoffee.shop.di.splash_screen.SplashComponent;

@Singleton
@Component(modules = {NetworkModule.class, PrefsModule.class})
public interface AppComponent {

    @Component.Factory
    interface Factory{
        AppComponent create(@BindsInstance Context context);
    }

    SplashComponent plusSplashComponent();

    LoginComponent plusLoginComponent();

    NewAccountComponent plusNewAccountComponent();

    MainScreenComponent plusMainScreenComponent();

    BasketScreenComponent plusBasketScreenComponent();

    ProfileScreenComponent plusProfileScreenComponent();
}
