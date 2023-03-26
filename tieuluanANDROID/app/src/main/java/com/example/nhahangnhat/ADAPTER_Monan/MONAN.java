package com.example.nhahangnhat.ADAPTER_Monan;

public class MONAN {
    public MONAN(String mamon, String tenmon, String chitiet,String spnoibat, String giamon, String hinhanh,String maloai) {
        this.mamon = mamon;
        this.tenmon = tenmon;
        this.giamon = giamon;
        this.chitiet = chitiet;
        this.spnoibat = spnoibat;
        this.hinhanh = hinhanh;
        this.maloai=maloai;
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

    public String getGiamon() {
        return giamon;
    }

    public void setGiamon(String giamon) {
        this.giamon = giamon;
    }

    public String getChitiet() {
        return chitiet;
    }

    public void setChitiet(String chitiet) {
        this.chitiet = chitiet;
    }

    public String getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(String hinhanh) {
        this.hinhanh = hinhanh;
    }

    public String getMaloai() {
        return maloai;
    }

    public void setMaloai(String maloai) {
        this.maloai = maloai;
    }

    public String getSpnoibat() {
        return spnoibat;
    }

    public void setSpnoibat(String spnoibat) {
        this.spnoibat = spnoibat;
    }

    String mamon , tenmon , giamon , chitiet , hinhanh,maloai, spnoibat;
}