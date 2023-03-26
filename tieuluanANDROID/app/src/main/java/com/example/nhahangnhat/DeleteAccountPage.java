package com.example.nhahangnhat;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

public class DeleteAccountPage extends AppCompatActivity {
    Button btnXoa;
    EditText etMatkhau,etSDT;

    String sodt, matkhau;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_account_page);
        AnhXa();
        sodt = matkhau ="";


        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sodt = etSDT.getText().toString().trim();
                matkhau = etMatkhau.getText().toString().trim();
                if (!sodt.equals("") && !matkhau.equals("")) {
                    StringRequest stringRequest = new StringRequest(Request.Method.POST, SERVER.deletetaikhoanpath, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            if (response.equals("xoa thanh cong")) {
                                Intent intent1 = new Intent(getApplicationContext(),MainActivity.class);
                                startActivity(intent1);
                                Toast.makeText(getApplicationContext(), "Xóa thành công", Toast.LENGTH_SHORT).show();
                            } else if (response.equals("xoa that bai")) {
                                Toast.makeText(getApplicationContext(), "Xóa thất bại", Toast.LENGTH_SHORT).show();
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
        btnXoa = findViewById(R.id.btnXoa);
    }
}