package com.example.nhahangnhat;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nhahangnhat.booking.datban;
import com.example.nhahangnhat.cart.FragmentCart;
import com.example.nhahangnhat.cart.GIOHANG;
import com.example.nhahangnhat.profile.FragmentProfile;
import com.squareup.picasso.Picasso;

public class FooddetailAfterLogin extends AppCompatActivity {
    ImageView hinhchitiet;
    TextView tenmonanchitiet,giamonanchitiet,chitietmonan;
    Button back,thembtn;

    Intent intent;

    String masp,  tensp , giasp , hinhsp,chitietsp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fooddetail_after_login);
        anhxa();

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(FooddetailAfterLogin.this, MainActivity.class);
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
        final AlertDialog.Builder builder = new AlertDialog.Builder(FooddetailAfterLogin.this);
        builder.setTitle("BẠN CẦN ĐĂNG NHẬP ĐỂ ĐẶT MÓN");
        builder.setMessage("Thông báo sẽ tự tắt sau 3s");
        AlertDialog alertDialog = builder.create();

        thembtn.setOnClickListener(new View.OnClickListener() {
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

    }
    void anhxa(){
        hinhchitiet = findViewById(R.id.hinhchitiet1);
        tenmonanchitiet = findViewById(R.id.tenmonanchitiet1);
        giamonanchitiet = findViewById(R.id.giamonanchitiet1);
        chitietmonan = findViewById(R.id.chitietmonan1);
        back = findViewById(R.id.back);
        thembtn = findViewById(R.id.addcartbtn1);
    }
    }
