package com.siiberad.miripgojek;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.ImageButton;

import com.siiberad.miripgojek.fragment.AccountFragment;
import com.siiberad.miripgojek.fragment.ChatFragment;
import com.siiberad.miripgojek.fragment.HomeFragment;
import com.siiberad.miripgojek.fragment.InboxFragment;
import com.siiberad.miripgojek.fragment.OrderFragment;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        setContentView(R.layout.activity_main);



        loadFragment(new HomeFragment());

        BottomNavigationView bottomNavigationView = findViewById(R.id.nav_view);

        bottomNavigationView.setOnNavigationItemSelectedListener(this);


    }


    private boolean loadFragment(Fragment fragment){
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.frame_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment;

        switch (item.getItemId()) {
            case R.id.navigation_home:
                fragment = new HomeFragment();
                loadFragment(fragment);
                return true;
            case R.id.navigation_orders:
                fragment = new OrderFragment();
                loadFragment(fragment);
                return true;
            case R.id.navigation_chat:
                fragment = new ChatFragment();
                loadFragment(fragment);
                return true;
            case R.id.navigation_inbox:
                fragment = new InboxFragment();
                loadFragment(fragment);
                return true;
            case R.id.navigation_account:
                fragment = new AccountFragment();
                loadFragment(fragment);
                return true;
        }
        return false;
    }



    public void onBackPressed()
    {
        FragmentManager fm = getSupportFragmentManager();
        fm.popBackStack();
    }
}