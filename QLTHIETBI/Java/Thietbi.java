package com.example.qlthietbi;

public class Thietbi {
    String mamay, tenmay, maloaimay, donvitinh, anh;
    int soluong;

    public Thietbi(String mamay, String tenmay, String maloaimay, String donvitinh, String anh, int soluong) {
        this.mamay = mamay;
        this.tenmay = tenmay;
        this.maloaimay = maloaimay;
        this.donvitinh = donvitinh;
        this.anh = anh;
        this.soluong = soluong;
    }

    public String getMamay() {
        return mamay;
    }

    public void setMamay(String mamay) {
        mamay = mamay;
    }

    public String getTenmay() {
        return tenmay;
    }

    public void setTenmay(String tenmay) {
        tenmay = tenmay;
    }

    public String getMaloaimay() {
        return maloaimay;
    }

    public void setMaloaimay(String maloaimay) {
        maloaimay = maloaimay;
    }

    public String getDonvitinh() {
        return donvitinh;
    }

    public void setDonvitinh(String donvitinh) {
        this.donvitinh = donvitinh;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }
}
