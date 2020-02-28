package ru.zakazcoffee.shop.presentation.view.login;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import ru.zakazcoffee.shop.MainActivity;
import ru.zakazcoffee.shop.R;
import ru.zakazcoffee.shop.presentation.view.login.login_screen.LoginScreenFragment;

public class LoginActivity extends AppCompatActivity {

    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        fragmentManager = getSupportFragmentManager();
        showFragment(new LoginScreenFragment());
    }

    @Override
    public void onBackPressed() {
        if (fragmentManager.getBackStackEntryCount() > 1 ){
            fragmentManager.popBackStack();
        } else {
            finish();
        }
    }

    public void showFragment(Fragment fragment) {
        fragmentManager.beginTransaction()
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .addToBackStack("old")
                .replace(R.id.container, fragment)
                .commit();
    }

    public void showMainScreen() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
