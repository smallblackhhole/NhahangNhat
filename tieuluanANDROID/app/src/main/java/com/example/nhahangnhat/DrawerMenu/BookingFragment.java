package com.example.nhahangnhat.DrawerMenu;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.nhahangnhat.R;
import com.example.nhahangnhat.booking.BOOKING;
import com.example.nhahangnhat.booking.BOOKING_ADAPTER;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.Calendar;


public class BookingFragment extends Fragment implements NavigationView.OnNavigationItemSelectedListener{
    RecyclerView rv_datban;
    Context context;
    ArrayList<BOOKING> databooking = new ArrayList<>();
    BOOKING_ADAPTER booking_adapter;
    private DrawerLayout drawerLayout;
    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_booking, container, false);
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
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        context = getContext();
        rv_datban = view.findViewById(R.id.rv_datban);
        databooking.add(new BOOKING(R.drawable.booking,"bàn 1 người","còn bàn"));
        databooking.add(new BOOKING(R.drawable.booking,"bàn 2 người","còn bàn"));
        databooking.add(new BOOKING(R.drawable.booking,"bàn 3 người","còn bàn"));
        databooking.add(new BOOKING(R.drawable.booking,"bàn 4 người","còn bàn"));
        databooking.add(new BOOKING(R.drawable.booking,"bàn 5 người","còn bàn"));
        databooking.add(new BOOKING(R.drawable.booking,"bàn 6 người","còn bàn"));
        databooking.add(new BOOKING(R.drawable.booking,"bàn 7 người","còn bàn"));
        databooking.add(new BOOKING(R.drawable.booking,"bàn 8 người","còn bàn"));
        databooking.add(new BOOKING(R.drawable.booking,"bàn 9 người","còn bàn"));
        databooking.add(new BOOKING(R.drawable.booking,"bàn 10 người","còn bàn"));
        databooking.add(new BOOKING(R.drawable.booking,"bàn 11 người","còn bàn"));
        databooking.add(new BOOKING(R.drawable.booking,"bàn 12 người","còn bàn"));


        booking_adapter = new BOOKING_ADAPTER(context,databooking);
        rv_datban.setAdapter(booking_adapter);
        rv_datban.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
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
        } else if (id == R.id.Booking) {
            Fragment fragment = new BookingFragment();
            FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
            transaction.replace(R.id.nav_frame_layout, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        } else if (id == R.id.Contact) {
            Fragment fragment = new ContactFragment();
            FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
            transaction.replace(R.id.nav_frame_layout, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        } else if (id == R.id.Hiring) {
            Fragment fragment = new HiringFragment();
            FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
            transaction.replace(R.id.nav_frame_layout, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
        return true;
    }
}