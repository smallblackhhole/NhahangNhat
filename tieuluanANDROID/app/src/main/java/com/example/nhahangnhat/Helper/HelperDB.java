package com.example.nhahangnhat.Helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.nhahangnhat.cart.GIOHANG;

import java.util.ArrayList;

public class HelperDB {
    SQLiteDatabase db;

    public HelperDB(Context context) {
        QLCART qlsvdbHelper = new QLCART(context);
        db = qlsvdbHelper.getWritableDatabase();
    }
    public long insertProduct(String id, String image, String name, String price) {
        ContentValues values = new ContentValues();
        values.put("MAMON", id);
        values.put("HINHANH", image);
        values.put("TENMON", name);
        values.put("GIAMON", price);

        return db.insert("CART", null, values);
    }
    public ArrayList<GIOHANG> layALLSP() {
        ArrayList<GIOHANG> list = new ArrayList<>();
        Cursor cursor = db.query("CART", null, null, null, null, null, null);
        while (cursor.moveToNext()) {
            GIOHANG sp = new GIOHANG();
            sp.setMamon(cursor.getString(0));
            sp.setTenmon(cursor.getString(1));
            sp.setGiamon(cursor.getInt(2));
            sp.setHinhanh(cursor.getString(3));
            list.add(sp);
        }
        cursor.close();
        return list;
    }
    public void deleteProductById(String id) {
        db.delete("CART", "MAMON=?", new String[]{id});
        db.close();
    }
}
