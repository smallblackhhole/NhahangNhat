package com.example.nhahangnhat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.nhahangnhat.Notification.Notification;
import com.example.nhahangnhat.cart.FragmentCart;
import com.example.nhahangnhat.discount.FragmentDiscount;
import com.example.nhahangnhat.home.FragmentHome;
import com.example.nhahangnhat.home.FragmentHomeAfterLogin;
import com.example.nhahangnhat.profile.FragmentProfile;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity  {
    Toolbar toolbar;
    DrawerLayout drawerLayout;

    Fragment fragment;

    FragmentTransaction transaction;
    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhxa();

        bottomNavigationView.setOnItemSelectedListener(new BottomNavigationView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        fragment = new FragmentHomeAfterLogin();
                        break;
                    case R.id.navigation_discount:
                        fragment = new FragmentDiscount();
                        break;
                    case R.id.navigation_notify:
                        fragment = new Notification();
                        break;
                    case R.id.navigation_profile:
                        fragment = new FragmentProfile();
                        break;
                }
                OpenFragment(fragment);
                return true;
            }
        });
        OpenFragment(new FragmentHome());
}
    void OpenFragment(Fragment f){
        transaction = getSupportFragmentManager().beginTransaction();
        transaction = transaction.replace(R.id.nav_frame_layout,f);
        transaction.commit();
    }

    void anhxa(){
        toolbar = findViewById(R.id.ToolBar);
        drawerLayout = findViewById(R.id.DrawerLayout);
        bottomNavigationView = findViewById(R.id.bottom_view);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }
}
