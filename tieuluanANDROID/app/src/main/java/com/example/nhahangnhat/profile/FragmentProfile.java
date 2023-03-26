package com.example.nhahangnhat.profile;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import com.example.nhahangnhat.MainActivity2;
import com.example.nhahangnhat.R;
import com.example.nhahangnhat.RegisterPage;
import com.example.nhahangnhat.SERVER;

import java.util.HashMap;
import java.util.Map;


public class FragmentProfile extends Fragment {
    Button btnDangNhap, btnDangKy;
    EditText etSDT, etPassword;
    Context context;
    String sodt, matkhau,diachi, email, tenkh;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        btnDangKy = view.findViewById(R.id.su);
        btnDangNhap = view.findViewById(R.id.login);
        etSDT = view.findViewById(R.id.dn);
        etPassword = view.findViewById(R.id.mk);
        sodt = matkhau = "" ;
        btnDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), RegisterPage.class);
                startActivity(intent);
            }
        });


        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sodt = etSDT.getText().toString().trim();
                matkhau = etPassword.getText().toString().trim();
                if (!sodt.equals("") && !matkhau.equals("")) {
                    StringRequest stringRequest = new StringRequest(Request.Method.POST, SERVER.loginpath, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                                if (response.equals("success")) {
                                        Intent intent1 = new Intent(getContext(),MainActivity2.class);
                                        intent1.putExtra("SODT",sodt);
                                    startActivity(intent1);
                                    Toast.makeText(getContext(), "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                         } else if (response.equals("failure")) {
                            Toast.makeText(getContext(), "Sai tên tài khoản hoặc mật khẩu", Toast.LENGTH_SHORT).show();
                        }
                    }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(getContext(), error.toString(), Toast.LENGTH_SHORT).show();
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
                    RequestQueue requestQueue = Volley.newRequestQueue(getContext());
                    requestQueue.add(stringRequest);
                } else {
                    Toast.makeText(getContext(), "Không được để trống", Toast.LENGTH_SHORT).show();
                }

            }

        });
        return view;
    }

}



