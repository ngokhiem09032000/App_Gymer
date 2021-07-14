package com.example.app_gymer;

import java.io.Serializable;

public class GioHang implements Serializable {
    private String masp;



    private String tensp;
    private String gia;
    private int soluong;
    private String hinh;

    public GioHang(String masp,String tensp, String gia, int soluong, String hinh) {
        this.masp = masp;
        this.tensp = tensp;
        this.gia = gia;
        this.soluong = soluong;
        this.hinh = hinh;
    }
    public GioHang()
    {}

    public String getMasp() {
        return masp;
    }

    public void setMasp(String masp) {
        this.masp = masp;
    }
    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public String getHinh() {
        return hinh;
    }

    public void setHinh(String hinh) {
        this.hinh = hinh;
    }
}
