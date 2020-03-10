package ru.zakazcoffee.shop.presentation.view.main;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.zakazcoffee.shop.R;
import ru.zakazcoffee.shop.presentation.view.main.basket_screen.BasketScreenFragment;
import ru.zakazcoffee.shop.presentation.view.main.main_screen.MainScreenFragment;
import ru.zakazcoffee.shop.presentation.view.main.profile_screen.ProfileScreenFragment;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.bnvNavigation)
    BottomNavigationView bnvNavigation;

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

//                        selectedMenuId = menuItem.getItemId();
                    return true;
                default:
                    return false;
            }
//            }
//            return  false;
        });
        bnvNavigation.setSelectedItemId(R.id.mainScreen);
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
}
