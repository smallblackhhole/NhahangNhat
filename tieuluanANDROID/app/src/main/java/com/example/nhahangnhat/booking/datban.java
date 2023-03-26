package com.example.nhahangnhat.booking;


import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.nhahangnhat.R;

import java.util.Calendar;

public class datban extends AppCompatActivity {
    private int lastSelectedHour = -1;
    private int lastSelectedMinute = -1;
    String slban;
    Button btnngay,btngio,btndat;
    EditText edtngay,edtgio,edtten;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datban);
        btnngay = findViewById(R.id.btnchonngay);
        btngio = findViewById(R.id.btnchongio);
        btndat = findViewById(R.id.btndat);
        edtngay = findViewById(R.id.edtchonngay);
        edtgio = findViewById(R.id.edtchongio);
        edtten = findViewById(R.id.edtten);

        Calendar calendar = Calendar.getInstance();
        calendar.getTimeInMillis();

        Intent intent1 = getIntent();
        slban = intent1.getStringExtra("ban");

        btnngay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //xử lý cv người dùng chọn 1 ngày trên dialog
                DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {

                        edtngay.setText("Ngày "  + dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                    }
                };
                DatePickerDialog datePickerDialog = new DatePickerDialog(datban.this,
                        android.R.style.Theme_Holo_Light_Dialog_NoActionBar,
                        dateSetListener, calendar.get(Calendar.MONTH-1), calendar.get(Calendar.DATE),calendar.get(Calendar.YEAR));
                datePickerDialog.show();
            }
        });
        btngio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean is24HView = true;
                int selectedHour = 10;
                int selectedMinute = 20;
                //xử lý chọn giờ
                TimePickerDialog.OnTimeSetListener timeSetListener = new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        edtgio.setText(hourOfDay + " giờ " + minute + " phút " );
                        lastSelectedHour = hourOfDay;
                        lastSelectedMinute = minute;
                    }
                };
                TimePickerDialog timePickerDialog = new TimePickerDialog(datban.this,
                        android.R.style.Theme_Holo_Light_Dialog_NoActionBar,
                        timeSetListener, lastSelectedHour, lastSelectedMinute, is24HView);
                timePickerDialog.show();
            }
        });
        final AlertDialog.Builder builder = new AlertDialog.Builder(datban.this);
                    builder.setTitle("ĐẶT BÀN THÀNH CÔNG");
                    builder.setMessage("CẢM ƠN BẠN " + edtten.getText().toString() + " ĐÃ ĐẶT " + slban + " VÀO LÚC "
                        + edtngay.getText().toString() + " VÀO LÚC " + edtgio.getText().toString()
                    );
        AlertDialog alertDialog = builder.create();

        btndat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.show();

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        alertDialog.dismiss();
                        finish();
                    }
                }, 3000);
            }
        });
    }
}