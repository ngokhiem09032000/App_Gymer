package com.example.app_gymer;

import java.io.Serializable;

public class SanPham implements Serializable {
    private String masp;
    private String tensp;
    private String hinh;
    private String gia;
    private String mota;
    private String loaisp;

    public String getLoaisp() {
        return loaisp;
    }

    public void setLoaisp(String loaisp) {
        this.loaisp = loaisp;
    }

    public SanPham(String masp, String tensp, String hinh, String gia, String mota, String loaisp) {
        this.masp = masp;
        this.tensp = tensp;
        this.hinh = hinh;
        this.gia = gia;
        this.mota = mota;
    }
    public SanPham()
    {}
    public String getMasp() {
        return masp;
    }

    public void setMasp(String masp) {
        this.masp = masp;
    }

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

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

}
