package com.example.app_gymer;

public class BaiTap {
    private String tenbt;
    private String hinh;

    public String getTenbt() {
        return tenbt;
    }

    public void setTenbt(String tenbt) {
        this.tenbt = tenbt;
    }

    public String getHinh() {
        return hinh;
    }

    public void setHinh(String hinh) {
        this.hinh = hinh;
    }

    public BaiTap(String tenbt, String hinh) {
        this.tenbt = tenbt;
        this.hinh = hinh;
    }
}
