package com.example.nhahangnhat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.nhahangnhat.ADAPTER_Monan.ADAPTER_Monan;
import com.example.nhahangnhat.ADAPTER_Monan.MONAN;
import com.example.nhahangnhat.cart.FragmentCart;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Phanloaimonan extends AppCompatActivity {
    RecyclerView rvPhanloaimonan;
    ArrayList<MONAN> data = new ArrayList<>();
    ADAPTER_Monan adapter_monan;
    Intent intent;
    String maloai;
    Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phanloaimonan);
        rvPhanloaimonan = findViewById(R.id.rvPhanloaimonan);
        back = findViewById(R.id.back);
        intent = getIntent();
        maloai =  intent.getStringExtra("maloai");
        LoadBook();

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Phanloaimonan.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
    void LoadBook(){

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        Response.Listener<JSONArray> thanhcong = new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray jsonArray) {
                for (int i = 0; i < jsonArray.length(); i++) {
                    try {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        data.add(new MONAN(
                                jsonObject.getString("mamon"),
                                jsonObject.getString("tenmon"),
                                jsonObject.getString("chitiet"),
                                jsonObject.getString("spnoibat"),
                                jsonObject.getString("dongia"),
                                jsonObject.getString("hinhanh"),
                                jsonObject.getString("maloai")));
                    } catch (JSONException e) {
                        Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();

                    }
                }
                adapter_monan.notifyDataSetChanged();

            }
        };

        Response.ErrorListener thatbai = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        };

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(SERVER.phanloaipath+"?maloai="+maloai, thanhcong, thatbai);
        requestQueue.add(jsonArrayRequest);

        adapter_monan = new ADAPTER_Monan(this, data);
        rvPhanloaimonan.setAdapter(adapter_monan);
        rvPhanloaimonan.setLayoutManager(new GridLayoutManager(this,2));
    }
}