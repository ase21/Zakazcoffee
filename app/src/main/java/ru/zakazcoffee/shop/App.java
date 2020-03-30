package ru.zakazcoffee.shop;

import android.app.Application;

import ru.zakazcoffee.shop.di.app.AppComponent;
import ru.zakazcoffee.shop.di.app.DaggerAppComponent;
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

public class App extends Application {

    private static App instance;

    private AppComponent appComponent;
    private SplashComponent splashComponent;
    private LoginComponent loginComponent;
    private NewAccountComponent newAccountComponent;
    private MainScreenComponent mainScreenComponent;
    private BasketScreenComponent basketScreenComponent;
    private ProfileScreenComponent profileScreenComponent;
    private AboutUsComponent aboutUsComponent;
    private HistoryComponent historyComponent;
    private BuyersComponent buyersComponent;
    private DeliveryRulesComponent deliveryRulesComponent;
    private PointsComponent pointsComponent;
    private InviteFriendComponent inviteFriendComponent;
    private WalletComponent walletComponent;
    private TotalRulesComponent totalRulesComponent;

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

    public AboutUsComponent plusAboutUsComponent() {
        if (aboutUsComponent == null)
            aboutUsComponent = appComponent.plusAboutUsComponent();
        return aboutUsComponent;
    }

    public void clearAboutUsComponent() {
        aboutUsComponent = null;
    }

    public HistoryComponent plusHistoryComponent() {
        if (historyComponent == null)
            historyComponent = appComponent.plusHistoryComponent();
        return historyComponent;
    }

    public void clearHistoryComponent() {
        historyComponent = null;
    }

    public BuyersComponent plusBuyersComponent() {
        if (buyersComponent == null)
            buyersComponent = appComponent.plusBuyersComponent();
        return buyersComponent;
    }

    public void clearBuyersComponent() {
        buyersComponent = null;
    }

    public PointsComponent plusPointsComponent() {
        if (pointsComponent == null)
            pointsComponent = appComponent.plusPointsComponent();
        return pointsComponent;
    }

    public void clearPointsComponent() {
        pointsComponent = null;
    }

    public InviteFriendComponent plusInviteFriendComponent() {
        if (inviteFriendComponent == null)
            inviteFriendComponent = appComponent.plusInviteFriendComponent();
        return inviteFriendComponent;
    }

    public void clearInviteFriendComponent() {
        inviteFriendComponent = null;
    }

    public WalletComponent plusWalletComponent() {
        if (walletComponent == null)
            walletComponent = appComponent.plusWalletComponent();
        return walletComponent;
    }

    public void clearWalletComponent() {
        walletComponent = null;
    }

    public DeliveryRulesComponent plusDeliveryRulesComponent() {
        if (deliveryRulesComponent == null)
            deliveryRulesComponent = appComponent.plusDeliveryRulesComponent();
        return deliveryRulesComponent;
    }

    public void clearDeliveryRulesComponent() {
        deliveryRulesComponent = null;
    }

    public TotalRulesComponent plusTotalRulesComponent() {
        if (totalRulesComponent == null)
            totalRulesComponent = appComponent.plusTotalRulesComponent();
        return totalRulesComponent;
    }

    public void clearTotalRulesComponent() {
        totalRulesComponent = null;
    }
}
