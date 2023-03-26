package com.example.nhahangnhat.DrawerMenu;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
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
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.nhahangnhat.ADAPTER_Menu.ADPATER_MENU;
import com.example.nhahangnhat.ADAPTER_Menu.PhanLoai;
import com.example.nhahangnhat.ADAPTER_menuDrawer.ADAPTER_menudrawer;
import com.example.nhahangnhat.ADAPTER_menuDrawer.PhanloaiMenudrawer;
import com.example.nhahangnhat.R;
import com.example.nhahangnhat.SERVER;
import com.google.android.material.navigation.NavigationView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class MenuFragment extends Fragment implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawerLayout;
    ArrayList<PhanloaiMenudrawer> data = new ArrayList<>();
    ADAPTER_menudrawer adpater_menu;
    RecyclerView menu_rcv;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu,container,false);
        drawerLayout = view.findViewById(R.id.DrawerLayout);
        Button btnOpenDrawer = view.findViewById(R.id.btnOpenDrawer);
        NavigationView navigationView = view.findViewById(R.id.NavigationView);
        navigationView.setNavigationItemSelectedListener(this);
        menu_rcv = view.findViewById(R.id.menu_rcv);
        LoadMenu();
        btnOpenDrawer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });return view;


    }
    public void LoadMenu() {
        RequestQueue requestQueue = Volley.newRequestQueue(getContext());

        Response.Listener<JSONArray> thanhcong = new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);
                        data.add(new PhanloaiMenudrawer(
                                jsonObject.getString("maloai"),
                                jsonObject.getString("tenloai"),
                                jsonObject.getString("hinhloai")
                        ));
                    } catch (JSONException e) {
                        Toast.makeText(getContext(),"za", Toast.LENGTH_SHORT).show();
                    }
                }
                adpater_menu.notifyDataSetChanged();
            }
        };
        Response.ErrorListener thatbai = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(), "aa", Toast.LENGTH_SHORT).show();
            }
        };
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(SERVER.menupath, thanhcong, thatbai);
        requestQueue.add(jsonArrayRequest);

        adpater_menu = new ADAPTER_menudrawer(getContext(), data);
        menu_rcv.setAdapter(adpater_menu);
        menu_rcv.setLayoutManager(new GridLayoutManager(getContext(),2));

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