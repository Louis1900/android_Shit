package com.example.qlbanxe2;

public class Xe {
    String maxe, tenxe, namsx, maloai, hinh;

    public Xe(String maxe, String tenxe, String namsx, String maloai, String hinh) {
        this.maxe = maxe;
        this.tenxe = tenxe;
        this.namsx = namsx;
        this.maloai = maloai;
        this.hinh = hinh;
    }

    public String getMaxe() {
        return maxe;
    }

    public void setMaxe(String maxe) {
        this.maxe = maxe;
    }

    public String getTenxe() {
        return tenxe;
    }

    public void setTenxe(String tenxe) {
        this.tenxe = tenxe;
    }

    public String getNamsx() {
        return namsx;
    }

    public void setNamsx(String namsx) {
        this.namsx = namsx;
    }

    public String getMaloai() {
        return maloai;
    }

    public void setMaloai(String maloai) {
        this.maloai = maloai;
    }

    public String getHinh() {
        return hinh;
    }

    public void setHinh(String hinh) {
        this.hinh = hinh;
    }
}
