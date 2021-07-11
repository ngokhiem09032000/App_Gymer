package com.example.app_gymer;

import java.io.Serializable;

public class SanPham implements Serializable {
    private String tensp;
    private String hinh;
    private String gia;
    private String mota;

    public String getTenbt() {
        return tensp;
    }

    public void setTenbt(String tenbt) {
        this.tensp = tenbt;
    }

    public String getHinh() {
        return hinh;
    }

    public void setHinh(String hinh) {
        this.hinh = hinh;
    }


    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public SanPham(String tensp, String hinh, String gia, String mota) {
        this.tensp = tensp;
        this.hinh = hinh;
        this.gia = gia;
        this.mota = mota;
    }
}
