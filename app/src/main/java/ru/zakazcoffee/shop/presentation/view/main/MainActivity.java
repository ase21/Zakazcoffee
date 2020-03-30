package ru.zakazcoffee.shop.presentation.view.main;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.zakazcoffee.shop.R;
import ru.zakazcoffee.shop.presentation.view.login.LoginActivity;
import ru.zakazcoffee.shop.presentation.view.main.basket_screen.BasketScreenFragment;
import ru.zakazcoffee.shop.presentation.view.main.left_menu.delivery_rules.DeliveryRulesFragment;
import ru.zakazcoffee.shop.presentation.view.main.left_menu.history.HistoryFragment;
import ru.zakazcoffee.shop.presentation.view.main.left_menu.total_rules.TotalRulesFragment;
import ru.zakazcoffee.shop.presentation.view.main.main_screen.MainScreenFragment;
import ru.zakazcoffee.shop.presentation.view.main.profile_screen.ProfileScreenFragment;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.bnvNavigation)
    BottomNavigationView bnvNavigation;
    @BindView(R.id.navigationView)
    NavigationView navigationView;
    @BindView(R.id.drawer)
    DrawerLayout drawer;

    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUI();
    }

    private void initUI() {
        ButterKnife.bind(this);
        fragmentManager = getSupportFragmentManager();
        bnvNavigation.setOnNavigationItemSelectedListener(menuItem -> {
//            if (selectedMenuId != menuItem.getItemId()) {
            switch (menuItem.getItemId()) {
                case R.id.mainScreen:
                    showBottomNavigationMenuFragment(new MainScreenFragment());
//                        selectedMenuId = menuItem.getItemId();
                    return true;
                case R.id.basketScreen:
                    showBottomNavigationMenuFragment(new BasketScreenFragment());
//                        selectedMenuId = menuItem.getItemId();
                    return true;
                case R.id.profileScreen:
                    showBottomNavigationMenuFragment(new ProfileScreenFragment());
//                        selectedMenuId = menuItem.getItemId();
                    return true;
                case R.id.showNavigationDrawer:
                    drawer.openDrawer(GravityCompat.END);
                    return true;
                default:
                    return false;
            }
//            }
//            return  false;
        });
        bnvNavigation.setSelectedItemId(R.id.mainScreen);

        navigationView.setNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.navigation_history:
                    showFragment(new HistoryFragment());
                    drawer.closeDrawers();
                    return true;
                case R.id.navigation_buyers_account:
                    drawer.closeDrawers();
                    return true;
                case R.id.navigation_delivery_rules:
                    showFragment(new DeliveryRulesFragment());
                    drawer.closeDrawers();
                    return true;
                case R.id.navigation_points:
                    drawer.closeDrawers();
                    return true;
                case R.id.navigation_invite_friend:
                    drawer.closeDrawers();
                    return true;
                case R.id.navigation_wallet:
                    drawer.closeDrawers();
                    return true;
                case R.id.navigation_total_rules:
                    showFragment(new TotalRulesFragment());
                    drawer.closeDrawers();
                    return true;
                default:
                    return false;
            }
        });
    }

    private void showBottomNavigationMenuFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        if (fragmentManager.findFragmentByTag("new") != null){
            fragmentTransaction.remove(fragmentManager.findFragmentByTag("new"));
        }
        fragmentTransaction.replace(R.id.container, fragment);
        fragmentTransaction.commit();
    }

    public void showFragment(Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        transaction.replace(R.id.container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public void showLoginScreen() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}
