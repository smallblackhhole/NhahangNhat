package com.example.nhahangnhat.DrawerMenu;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.nhahangnhat.R;
import com.google.android.material.navigation.NavigationView;


public class HiringFragment extends Fragment implements NavigationView.OnNavigationItemSelectedListener{
    Button btndktueyndung;
    Spinner spinner;
    EditText edtten,edtemail,edtsdt,edtdiachi;
    ArrayAdapter<String> adapter; //tạo vector adapter để truyền vào spinner
    String vitri[] = { "","Nhân viên part time","Nhân viên thu ngân","Bếp trưởng","Bếp phụ" };
    private DrawerLayout drawerLayout;
    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hiring, container, false);
        Button btnOpenDrawer = view.findViewById(R.id.btnOpenDrawer);
        drawerLayout = view.findViewById(R.id.DrawerLayout);
        spinner =(Spinner) view.findViewById(R.id.spinnerchonvitri);
        edtten = view.findViewById(R.id.edtten);
        edtemail = view.findViewById(R.id.edtemail);
        edtsdt = view.findViewById(R.id.edtsdt);
        edtdiachi = view.findViewById(R.id.edtdiachi);
        adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, vitri);spinner.setAdapter(adapter);
        btndktueyndung = view.findViewById(R.id.btndktuyendung);
        btndktueyndung.setAlpha(0f);
        btndktueyndung.animate().alpha(1f).setDuration(2000);
        btndktueyndung.animate().rotationX(360).setDuration(2000);


        final AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setMessage("CẢM ƠN BẠN ĐĂNG KÝ TUYỂN DỤNG THÀNH CÔNG , CHÚNG TÔI SẼ GỬI MAIL PHẢN HỒI TRONG THỜI GIAN SỚM NHẤT "
        );
        AlertDialog alertDialog = builder.create();

        btndktueyndung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.show();

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        alertDialog.dismiss();

                    }
                }, 3000);
            }
        });



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