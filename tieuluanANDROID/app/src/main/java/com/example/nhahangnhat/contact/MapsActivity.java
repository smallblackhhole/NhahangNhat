package com.example.nhahangnhat.contact;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import com.example.nhahangnhat.R;
import com.example.nhahangnhat.databinding.ActivityMapsBinding;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {


    private GoogleMap mMap;
    private ActivityMapsBinding binding;
    EditText edtAddress;
    Button btnFind;
    List<Address> ListAddress;
    GoogleMap googleMap;
    MarkerOptions vt1,vt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        //anhxa
        edtAddress = findViewById(R.id.edtAddress);
        btnFind = findViewById(R.id.btnFind);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        //xử lí sk khi ng dùng bấm vào nút file
        btnFind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //maxResults => kq trả về = 1
                try {
                    ListAddress = new Geocoder(MapsActivity.this).getFromLocationName(edtAddress.getText().toString(),1);
                    //lấy tọa độ
                    double lat = ListAddress.get(0).getLatitude();
                    double longtitute = ListAddress.get(0).getLongitude();
                    //new tọa độ
                    LatLng toado = new LatLng(lat,longtitute);
                    googleMap.addMarker(new MarkerOptions().position(toado).title(edtAddress.getText().toString()));
                    //di chuyển camera đi
                    CameraUpdate mylocation = CameraUpdateFactory.newLatLngZoom(toado,17);
                    googleMap.animateCamera(mylocation);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        //vt1 = new MarkerOptions().position(new LatLng(10.774887546286529, 106.63434492625515)).title(vt1);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        //hiển thị zoom in ,zoom out
        mMap.getUiSettings().setZoomControlsEnabled(true);
        //hiển thị la bàn
        mMap.getUiSettings().setCompassEnabled(true);
       // mMap.getUiSettings().setCompassEnabled(true);
        //hiển thị nút vi tri ban than
        mMap.getUiSettings().setMyLocationButtonEnabled(true);
        //cấp quyền vị trí bản thân đang đứng
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this ,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},111);
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
//        //vị trí bản thân đang đứng
//        mMap.setMyLocationEnabled(true);

        // Add a marker in Sydney and move the camera
        //tọa độ,kinh độ
        //10.772727587486132, 106.69802079694439 chợ ben thanh
        LatLng benthanh = new LatLng(10.772727587486132, 106.69802079694439);
        mMap.addMarker(new MarkerOptions().position(benthanh).title("day la itc"));
        //tạo camera update zoom
        CameraUpdate mylocation = CameraUpdateFactory.newLatLngZoom(benthanh,16);
        //di chuyển về vị trí đó
        mMap.moveCamera(CameraUpdateFactory.newLatLng(benthanh));
        mMap.animateCamera(mylocation);
    }
}