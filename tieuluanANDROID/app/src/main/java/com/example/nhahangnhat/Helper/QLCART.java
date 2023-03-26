package com.example.nhahangnhat.Helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class QLCART extends SQLiteOpenHelper {
    public static String DBNAME = "ql_nhahang";
    public static int VERSION=1;
    public QLCART(@Nullable Context context) {
        super(context, DBNAME, null, VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql="CREATE TABLE CART(MAMON INTEGER PRIMARY KEY, TENMON TEXT, GIAMON TEXT , HINHANH TEXT)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
