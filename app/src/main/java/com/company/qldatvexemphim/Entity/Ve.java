package com.company.qldatvexemphim.Entity;

public class Ve {
    private String mave,tenloai,loaiphim,loaikhachhang;
    private double giave;

    public String getMave() {
        return mave;
    }

    public void setMave(String mave) {
        this.mave = mave;
    }

    public String getTenloai() {
        return tenloai;
    }

    public void setTenloai(String tenloai) {
        this.tenloai = tenloai;
    }

    public String getLoaiphim() {
        return loaiphim;
    }

    public void setLoaiphim(String loaiphim) {
        this.loaiphim = loaiphim;
    }

    public String getLoaikhachhang() {
        return loaikhachhang;
    }

    public void setLoaikhachhang(String loaikhachhang) {
        this.loaikhachhang = loaikhachhang;
    }

    public double getGiave() {
        return giave;
    }

    public void setGiave(double giave) {
        this.giave = giave;
    }

    public Ve(String mave, String tenloai, String loaiphim, String loaikhachhang, double giave) {
        this.mave = mave;
        this.tenloai = tenloai;
        this.loaiphim = loaiphim;
        this.loaikhachhang = loaikhachhang;
        this.giave = giave;
    }
}
