package com.example.nhahangnhat.home;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.nhahangnhat.ADAPTER_Menu.ADPATER_MENU;
import com.example.nhahangnhat.ADAPTER_Menu.PhanLoai;
import com.example.nhahangnhat.ADAPTER_Monan.ADAPTER_Monan;
import com.example.nhahangnhat.ADAPTER_Monan.ADAPTER_MonanBeforeLogin;
import com.example.nhahangnhat.ADAPTER_Monan.MONAN;
import com.example.nhahangnhat.ADAPTER_SLIDER.ADAPTER;
import com.example.nhahangnhat.ADAPTER_SLIDER.Slider_Image;
import com.example.nhahangnhat.DrawerMenu.AboutUsFragment;
import com.example.nhahangnhat.DrawerMenu.BookingFragment;
import com.example.nhahangnhat.DrawerMenu.ContactFragment;
import com.example.nhahangnhat.DrawerMenu.HiringFragment;
import com.example.nhahangnhat.DrawerMenu.MenuFragment;
import com.example.nhahangnhat.MainActivity;
import com.example.nhahangnhat.Notification.Notification;
import com.example.nhahangnhat.R;
import com.example.nhahangnhat.SERVER;
import com.example.nhahangnhat.SearchActi.SearchActi;
import com.example.nhahangnhat.cart.ADAPTER_Cart;
import com.example.nhahangnhat.cart.FragmentCart;
import com.example.nhahangnhat.cart.GIOHANG;
import com.google.android.material.navigation.NavigationView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class FragmentHome extends Fragment  implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawerLayout;
    private RecyclerView rv_menu,rv_sanpham;
    private ViewPager2 viewPager2;
    Toolbar Toolbar;
    Button searchne;
    ArrayList<PhanLoai> data = new ArrayList<>();
    ADPATER_MENU adpater_menu;

    ArrayList<MONAN> datamonan = new ArrayList<>();
    ADAPTER_MonanBeforeLogin adapter_monan;
    private List<Slider_Image> sliderImages;
    // Tạo ra 1 luồng xử lý hình ảnh tự động chạy
    private Handler handler = new Handler();
    // Luồng sẽ chạy hàm bên dưới
    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            // Kiểm tra hình ảnh đang chạy phải hình cuối cùng không
            if (viewPager2.getCurrentItem() == sliderImages.size() - 1) {
                //Quay về hình đầu tiên
                viewPager2.setCurrentItem(0);
            } else {
                // Tiến lên thêm 1 hình nữa
                viewPager2.setCurrentItem(viewPager2.getCurrentItem() + 1);
            }
        }
    };

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        drawerLayout = view.findViewById(R.id.DrawerLayout);
        NavigationView navigationView = view.findViewById(R.id.NavigationView);
        navigationView.setNavigationItemSelectedListener(this);
        viewPager2 = view.findViewById(R.id.slider_home);
        rv_menu = view.findViewById(R.id.rv_menu);
        rv_sanpham = view.findViewById(R.id.rv_sanpham);
        Toolbar= view.findViewById(R.id.ToolBar);
        searchne = view.findViewById(R.id.searchne);

        searchne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),SearchActi.class);
                startActivity(intent);
            }
        });




        Toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.toolbarShoppingCart:
                        Intent intent = new Intent(getContext(),FragmentCart.class);
                        startActivity(intent);
                }
                return true;
            }
        });


        Button btnOpenDrawer = view.findViewById(R.id.btnOpenDrawer);


        btnOpenDrawer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        sliderImages = new ArrayList<>();
        sliderImages.add(new Slider_Image("https://theme.hstatic.net/200000317293/1000883372/14/collection_banner.jpg?v=114", "Link"));
        sliderImages.add(new Slider_Image("https://cdn.pastaxi-manager.onepas.vn/content/uploads/articles/nguyenhuong/sushikovk/nha-hang-sushi-ko-vinh-khanh-3.jpg", "Link"));
        sliderImages.add(new Slider_Image("https://cdn-www.vinid.net/2020/04/6df6c767-20200417_appvinid_bannerweb_grandsushi.jpg", "Link"));




        ADAPTER adapter_slider = new ADAPTER(sliderImages, getContext());
        viewPager2.setAdapter(adapter_slider);
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                handler.removeCallbacks(runnable);
                handler.postDelayed(runnable, 3000);
            }
        });
        LoadMenu();
        LoadMonan();



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

    public void LoadMenu() {
        RequestQueue requestQueue = Volley.newRequestQueue(getContext());

        Response.Listener<JSONArray> thanhcong = new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);
                        data.add(new PhanLoai(
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

        adpater_menu = new ADPATER_MENU(getContext(), data);
        rv_menu.setAdapter(adpater_menu);
        rv_menu.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));

    }
    void LoadMonan() {
        RequestQueue requestQueue = Volley.newRequestQueue(getContext());

        Response.Listener<JSONArray> thanhcong = new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);
                        datamonan.add(new MONAN(
                                jsonObject.getString("mamon"),
                                jsonObject.getString("tenmon"),
                                jsonObject.getString("chitiet"),
                                jsonObject.getString("spnoibat"),
                                jsonObject.getString("dongia"),
                                jsonObject.getString("hinhanh"),
                                jsonObject.getString("maloai")
                        ));
                    } catch (JSONException e) {
                        Toast.makeText(getContext(),e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }
                adapter_monan.notifyDataSetChanged();
            }
        };
        Response.ErrorListener thatbai = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_LONG).show();
            }
        };
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(SERVER.foodpath+"?spnoibat='YES'", thanhcong, thatbai);
        requestQueue.add(jsonArrayRequest);

        adapter_monan = new ADAPTER_MonanBeforeLogin(getContext(), datamonan);
        rv_sanpham.setAdapter(adapter_monan);
        rv_sanpham.setLayoutManager(new GridLayoutManager(getContext(), 2));

    }
}
