package com.example.nhahangnhat.profile;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import com.example.nhahangnhat.DeleteAccountPage;
import com.example.nhahangnhat.MainActivity;
import com.example.nhahangnhat.MainActivity2;

import com.example.nhahangnhat.R;
import com.example.nhahangnhat.SERVER;
import com.example.nhahangnhat.UpdateProfilePage;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class FragmentProfileAfterLogin extends Fragment implements View.OnClickListener {
    TextView  chinhsuatk,xoatk,TENKH, DIACHI, EMAIL, SDT;;
    Button logout;
    String sodt;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile_after_login,container,false);


        logout = view.findViewById(R.id.logout);
        chinhsuatk = view.findViewById(R.id.chinhsuatk);
        xoatk = view.findViewById(R.id.xoatk);
        TENKH =view.findViewById(R.id.tvTenKH1);
        DIACHI =view.findViewById(R.id.tvAddress1);
        EMAIL =view.findViewById(R.id.tvEmail1);
        SDT =view.findViewById(R.id.tvSDT1);

        MainActivity2 main = (MainActivity2) getActivity();
        Intent intent = main.getIntent();
        sodt =  intent.getStringExtra("SODT");
        SDT.setText(sodt);
        logout.setOnClickListener(this);
        chinhsuatk.setOnClickListener(this);
        xoatk.setOnClickListener(this);
        LoadTaiKhoan();
        return view;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.logout:
                Intent intent = new Intent(getContext(), MainActivity.class);
                startActivity(intent);
                break;
            case R.id.chinhsuatk:
                Intent intent2 = new Intent(getContext(), UpdateProfilePage.class);
                startActivity(intent2);
                break;
            case R.id.xoatk:
                Intent intent3 = new Intent(getContext(), DeleteAccountPage.class);
                startActivity(intent3);
                break;
            default:
                break;
        }
    }
    void LoadTaiKhoan() {
        RequestQueue requestQueue = Volley.newRequestQueue(getContext());

        Response.Listener<JSONArray> thanhcong = new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);
                        TENKH.setText(jsonObject.getString("tenkh"));
                        DIACHI.setText(jsonObject.getString("diachi"));
                        EMAIL.setText(jsonObject.getString("email"));

                    } catch (JSONException e) {
                        Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }
            }
        };
        Response.ErrorListener thatbai = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_LONG).show();
            }
        };
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(SERVER.taikhoanpath+"?sodt="+sodt, thanhcong, thatbai);
        requestQueue.add(jsonArrayRequest);

    }
}



