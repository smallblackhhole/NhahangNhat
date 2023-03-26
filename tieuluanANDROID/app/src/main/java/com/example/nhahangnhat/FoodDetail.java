package com.example.nhahangnhat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nhahangnhat.ADAPTER_Monan.MONAN;
import com.example.nhahangnhat.cart.FragmentCart;
import com.example.nhahangnhat.cart.GIOHANG;
import com.example.nhahangnhat.home.FragmentHome;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class FoodDetail extends AppCompatActivity {
    ImageView hinhchitiet;
    TextView tenmonanchitiet,giamonanchitiet,chitietmonan;
    Button back,thembtn;

    Intent intent;

    String masp,  tensp , giasp , hinhsp,chitietsp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_detail);
        anhxa();

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(FoodDetail.this, MainActivity2.class);
                startActivity(intent1);

            }
        });



        intent = getIntent();
        tensp = intent.getStringExtra("tenmon");
        giasp = intent.getStringExtra("dongia");
        hinhsp = intent.getStringExtra("hinhanh");
        chitietsp = intent.getStringExtra("chitiet");

        tenmonanchitiet.setText(tensp);
        giamonanchitiet.setText(giasp);
        chitietmonan.setText(chitietsp);
        Picasso.get().load(SERVER.imagefoodpath+hinhsp).into(hinhchitiet);

        thembtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GIOHANG giohang = new GIOHANG(masp,tensp,Integer.parseInt(giasp),hinhsp);
                Intent intent2 = new Intent(FoodDetail.this, FragmentCart.class);
                intent2.putExtra("mamon", giohang.getMamon());
                intent2.putExtra("tenmon",giohang.getTenmon());
                intent2.putExtra("dongia", giohang.getGiamon() + "");
                intent2.putExtra("hinhanh", giohang.getHinhanh());
                startActivity(intent2);

            }
        });

    }
    void anhxa(){
        hinhchitiet = findViewById(R.id.hinhchitiet);
        tenmonanchitiet = findViewById(R.id.tenmonanchitiet);
        giamonanchitiet = findViewById(R.id.giamonanchitiet);
        chitietmonan = findViewById(R.id.chitietmonan);
        back = findViewById(R.id.back);
        thembtn = findViewById(R.id.addcartbtn);
    }
}