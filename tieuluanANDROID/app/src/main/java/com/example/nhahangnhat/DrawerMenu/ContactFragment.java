package com.example.nhahangnhat.DrawerMenu;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.text.TextUtils;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;


import com.example.nhahangnhat.R;
import com.example.nhahangnhat.contact.MapsActivity;
import com.google.android.material.navigation.NavigationView;


public class ContactFragment extends Fragment implements NavigationView.OnNavigationItemSelectedListener{
    private DrawerLayout drawerLayout;
    Button btnmaps,btnphone,btnphone2,btnsend;
    EditText edtname,edtemail,edtmessage;
    ImageView imgphone;
    Intent intent;
    androidx.appcompat.widget.Toolbar Toolbar;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_contact, container, false);
        Button btnOpenDrawer = view.findViewById(R.id.btnOpenDrawer);
        drawerLayout = view.findViewById(R.id.DrawerLayout);
        NavigationView navigationView = view.findViewById(R.id.NavigationView);
        btnmaps= view.findViewById(R.id.btnmaps);
        btnphone = view.findViewById(R.id.btnphone);
        btnphone2 = view.findViewById(R.id.btnphone2);
        imgphone = view.findViewById(R.id.imgphone);
        edtname =view.findViewById(R.id.edtname);
        edtemail = view.findViewById(R.id.edtemail);
        edtmessage = view.findViewById(R.id.edtmessage);
        btnsend = view.findViewById(R.id.btnsend);
        btnsend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get input values
                String name = edtname.getText().toString().trim();
                String email = edtemail.getText().toString().trim();
                String message = edtmessage.getText().toString().trim();

                // Validate input values
                if (TextUtils.isEmpty(name)) {
                    edtname.setError("Vui lòng nhập tên");
                    edtname.requestFocus();
                    return;
                }

                if (TextUtils.isEmpty(email)) {
                    edtemail.setError("Vui lòng nhập email");
                    edtemail.requestFocus();
                    return;
                }

                if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    edtemail.setError("Vui lòng nhập địa chỉ email");
                    edtemail.requestFocus();
                    return;
                }

                if (TextUtils.isEmpty(message)) {
                    edtmessage.setError("Vui lòng nhập tin nhắn ");
                    edtmessage.requestFocus();
                    return;
                }

                // Send email
                sendEmail(name, email, message);
            }
        });
        Toolbar= view.findViewById(R.id.ToolBar);
        imgphone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:0564703275"));
                startActivity(intent);

            }
        });
        btnmaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getContext(), MapsActivity.class);
                startActivity(intent);
            }
        });
        btnphone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:0564703275"));
                startActivity(intent);
            }
        });
        btnphone2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:1236712888"));
                startActivity(intent);
            }
        });



        navigationView.setNavigationItemSelectedListener(this);
        btnOpenDrawer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
        return view;

    }
    private void sendEmail(String name, String email, String message) {
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", "quanggl12345@gmail.com", null));
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Message from nha hang nhat: " );
        emailIntent.putExtra(Intent.EXTRA_TEXT, message + "\n\n" + "Reply to: " + email);

        try {
            startActivity(Intent.createChooser(emailIntent, "Đang gửi email đến nhà hàng nhật xin vui lòng đợi trong giây lát..."));
        } catch (AbstractMethodError ex) {
            Toast.makeText(getContext(), "There is no email client installed.", Toast.LENGTH_SHORT).show();
        }
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