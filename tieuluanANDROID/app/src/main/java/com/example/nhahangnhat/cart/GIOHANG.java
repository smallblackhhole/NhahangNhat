package com.example.nhahangnhat.cart;

public class GIOHANG {
    public int giamon, soluong;
    public String mamon, tenmon, hinhanh;

    public GIOHANG(String mamon, String tenmon, int giamon, String hinhanh) {
        this.mamon = mamon;
        this.tenmon = tenmon;
        this.giamon = giamon;
        this.hinhanh = hinhanh;
    }

    public GIOHANG() {

    }

    public String getMamon() {
        return mamon;
    }

    public void setMamon(String mamon) {
        this.mamon = mamon;
    }

    public String getTenmon() {
        return tenmon;
    }

    public void setTenmon(String tenmon) {
        this.tenmon = tenmon;
    }

    public int getGiamon() {
        return giamon;
    }

    public void setGiamon(int giamon) {
        this.giamon = giamon;
    }

    public String getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(String hinhanh) {
        this.hinhanh = hinhanh;
    }


    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }


}
