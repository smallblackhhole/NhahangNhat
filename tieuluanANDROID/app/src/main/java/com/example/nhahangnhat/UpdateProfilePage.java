package com.example.nhahangnhat;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class UpdateProfilePage extends AppCompatActivity {
    Button btnUpdate;
    EditText etMatkhau, etDiachi, etTenkh,etEmail,etSDT;

    String sodt, matkhau, diachi, tenkh, email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_profile_page);
        AnhXa();
        sodt = matkhau = diachi= tenkh=email ="";


        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sodt = etSDT.getText().toString().trim();
                matkhau = etMatkhau.getText().toString().trim();
                diachi = etDiachi.getText().toString().trim();
                tenkh = etTenkh.getText().toString().trim();
                email = etEmail.getText().toString().trim();
                if (!sodt.equals("") && !matkhau.equals("") && !diachi.equals("") && !tenkh.equals("") && !email.equals("")) {
                    StringRequest stringRequest = new StringRequest(Request.Method.POST, SERVER.updatetaikhoanpath, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            if (response.equals("update thanh cong")) {
                                Intent intent1 = new Intent(getApplicationContext(),MainActivity2.class);
                                intent1.putExtra("SODT",sodt);
                                startActivity(intent1);
                                Toast.makeText(getApplicationContext(), "Update thành công", Toast.LENGTH_SHORT).show();
                            } else if (response.equals("update that bai")) {
                                Toast.makeText(getApplicationContext(), "Update thất bại", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_SHORT).show();
                        }
                    }) {
                        @Nullable
                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            Map<String, String> data = new HashMap<>();
                            data.put("SODT", sodt);
                            data.put("MATKHAU", matkhau);
                            data.put("TENKH", tenkh);
                            data.put("DIACHI", diachi);
                            data.put("EMAIL", email);
                            return data;
                        }
                    };
                    RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                    requestQueue.add(stringRequest);
                } else {
                    Toast.makeText(getApplicationContext(), "Không được để trống", Toast.LENGTH_SHORT).show();

                }
            }

        });
    }

    void AnhXa(){
        etSDT = findViewById(R.id.etSDT);
        etMatkhau = findViewById(R.id.etPassword);
        etDiachi = findViewById(R.id.etAddress);
        etEmail = findViewById(R.id.etEmail);
        etTenkh = findViewById(R.id.etTenKH);
        btnUpdate = findViewById(R.id.btnUpdate);
    }
}