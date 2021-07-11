package com.example.app_gymer;

public class KhachHang {
    private String hoten;
    private String sdt;
    private String email;
    private String cannang;
    private String chieucao;
    private String matkhau;

    public KhachHang(String hoten, String sdt, String email, String cannang, String chieucao, String matkhau) {
        this.hoten = hoten;
        this.sdt = sdt;
        this.email = email;
        this.cannang = cannang;
        this.chieucao = chieucao;
        this.matkhau = matkhau;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCannang() {
        return cannang;
    }

    public void setCannang(String cannang) {
        this.cannang = cannang;
    }

    public String getChieucao() {
        return chieucao;
    }

    public void setChieucao(String chieucao) {
        this.chieucao = chieucao;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }
}
