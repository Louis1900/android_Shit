package com.example.qlthietbi;

public class LoaiThietbi {
    String maloaimay, tenloaimay;

    public LoaiThietbi(String maloaimay, String tenloaimay) {
        this.maloaimay = maloaimay;
        this.tenloaimay = tenloaimay;
    }

    public String getMaloaimay() {
        return maloaimay;
    }

    public void setMaloaimay(String maloaimay) {
        this.maloaimay = maloaimay;
    }

    public String getTenloaimay() {
        return tenloaimay;
    }

    public void setTenloaimay(String tenloaimay) {
        this.tenloaimay = tenloaimay;
    }
}
