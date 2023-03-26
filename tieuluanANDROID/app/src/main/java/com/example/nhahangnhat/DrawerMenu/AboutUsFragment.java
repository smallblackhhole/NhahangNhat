package com.example.nhahangnhat.DrawerMenu;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.nhahangnhat.R;
import com.google.android.material.navigation.NavigationView;


public class AboutUsFragment extends Fragment implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawerLayout;
    @SuppressLint("MissingInflatedId")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_about_us,container,false);
        Button btnOpenDrawer = view.findViewById(R.id.btnOpenDrawer);
        drawerLayout = view.findViewById(R.id.DrawerLayout);
        NavigationView navigationView = view.findViewById(R.id.NavigationView);
        navigationView.setNavigationItemSelectedListener(this);
        btnOpenDrawer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
        return view;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.AboutUs) {
            Fragment fragment = new AboutUsFragment();
            FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
            transaction.replace(R.id.nav_frame_layout, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        } else if (id == R.id.Menu) {
            Fragment fragment = new MenuFragment();
            FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
            transaction.replace(R.id.nav_frame_layout, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }else if (id == R.id.Booking) {
            Fragment fragment = new BookingFragment();
            FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
            transaction.replace(R.id.nav_frame_layout, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }else if (id == R.id.Contact) {
            Fragment fragment = new ContactFragment();
            FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
            transaction.replace(R.id.nav_frame_layout, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }else if (id == R.id.Hiring) {
            Fragment fragment = new HiringFragment();
            FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
            transaction.replace(R.id.nav_frame_layout, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
        return true;
    }
    }
