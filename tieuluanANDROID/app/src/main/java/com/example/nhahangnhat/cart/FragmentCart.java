package com.example.nhahangnhat.cart;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.nhahangnhat.ADAPTER_Monan.ADAPTER_Monan;
import com.example.nhahangnhat.ADAPTER_Monan.MONAN;
import com.example.nhahangnhat.Helper.HelperDB;
import com.example.nhahangnhat.MainActivity;
import com.example.nhahangnhat.MainActivity2;
import com.example.nhahangnhat.Notification.NotificationOrder;
import com.example.nhahangnhat.R;
import com.example.nhahangnhat.SERVER;

import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;


public class FragmentCart extends AppCompatActivity {
    RecyclerView recycleView_Cart;
    ADAPTER_Cart adapter_cart;
    ArrayList<GIOHANG> data1;
    Button back,bincart,dathang;
    String  id,image,name,price  ;
    int sl;
    ImageView imageCart;
    TextView nameCart;
    TextView priceCart;
    TextView giatongtien ;
    HelperDB helperDB;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_cart);
        anhxa();
        dathang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(FragmentCart.this, MainActivity2.class);
                Toast.makeText(FragmentCart.this, "Cảm ơn bạn đã đặt hàng , đơn hàng đang được giao tới bạn", Toast.LENGTH_SHORT).show();
                startActivity(intent1);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FragmentCart.this, MainActivity2.class);
                startActivity(intent);
            }
        });


        Intent intent1 = getIntent();
        id = intent1.getStringExtra("mamon");
        image = intent1.getStringExtra("hinhanh");
        name = intent1.getStringExtra("tenmon");
        price = intent1.getStringExtra("dongia");




        data1 = new ArrayList<>();
        helperDB = new HelperDB(this);
        long dulieu = helperDB.insertProduct(id,image,name, price);
        data1 = helperDB.layALLSP();



        adapter_cart = new ADAPTER_Cart(this,data1);
        recycleView_Cart.setAdapter(adapter_cart);
        recycleView_Cart.setLayoutManager(new LinearLayoutManager(this));
        adapter_cart.UpdateTotalPrice();


    }

    void anhxa(){
        back = findViewById(R.id.back);
        recycleView_Cart = findViewById(R.id.recycleView_Cart);
        imageCart = findViewById(R.id.imageCart);
        nameCart = findViewById(R.id.nameCart);
        priceCart = findViewById(R.id.priceCart);
        bincart = findViewById(R.id.bin);
        giatongtien = findViewById(R.id.giatongtien);
        dathang = findViewById(R.id.dathang);
    }

    public void UpdateTotalPrice(double totalPrice) {

        giatongtien.setText(String.valueOf(totalPrice));
    }
}
