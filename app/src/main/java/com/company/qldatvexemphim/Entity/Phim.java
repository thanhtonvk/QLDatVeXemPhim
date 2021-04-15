package com.company.qldatvexemphim.Entity;

public class Phim {
    private String maphim;
    private String tenloai;
    private String tenphim;
    private String mota;
    public String getMaphim() {
        return maphim;
    }

    public void setMaphim(String maphim) {
        this.maphim = maphim;
    }

    public String getTenloai() {
        return tenloai;
    }

    public void setTenloai(String tenloai) {
        this.tenloai = tenloai;
    }

    public String getTenphim() {
        return tenphim;
    }

    public void setTenphim(String tenphim) {
        this.tenphim = tenphim;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }



    public Phim(String maphim, String tenloai, String tenphim, String mota) {
        this.maphim = maphim;
        this.tenloai = tenloai;
        this.tenphim = tenphim;
        this.mota = mota;
    }

    @Override
    public String toString() {
        return "Mã phim: "+maphim+"\nTên phim: "+tenphim;
    }
}
