package ru.zakazcoffee.shop.di.app;

import android.content.Context;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import ru.zakazcoffee.shop.App;
import ru.zakazcoffee.shop.di.login.login_screen.LoginComponent;
import ru.zakazcoffee.shop.di.login.new_acc.NewAccountComponent;
import ru.zakazcoffee.shop.di.main.basket_screen.BasketScreenComponent;
import ru.zakazcoffee.shop.di.main.left_menu.about.AboutUsComponent;
import ru.zakazcoffee.shop.di.main.left_menu.buyers_account.BuyersComponent;
import ru.zakazcoffee.shop.di.main.left_menu.delivery_rules.DeliveryRulesComponent;
import ru.zakazcoffee.shop.di.main.left_menu.history.HistoryComponent;
import ru.zakazcoffee.shop.di.main.left_menu.invite_friend.InviteFriendComponent;
import ru.zakazcoffee.shop.di.main.left_menu.points.PointsComponent;
import ru.zakazcoffee.shop.di.main.left_menu.total_rules.TotalRulesComponent;
import ru.zakazcoffee.shop.di.main.left_menu.wallet.WalletComponent;
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

    AboutUsComponent plusAboutUsComponent();

    HistoryComponent plusHistoryComponent();

    BuyersComponent plusBuyersComponent();

    DeliveryRulesComponent plusDeliveryRulesComponent();

    PointsComponent plusPointsComponent();

    InviteFriendComponent plusInviteFriendComponent();

    WalletComponent plusWalletComponent();

    TotalRulesComponent plusTotalRulesComponent();
}
