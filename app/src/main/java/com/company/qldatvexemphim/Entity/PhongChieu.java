package com.company.qldatvexemphim.Entity;

public class PhongChieu {
    private String maphongchieu,socho,maychiue,tinhtrang;

    public String getMaphongchieu() {
        return maphongchieu;
    }

    public void setMaphongchieu(String maphongchieu) {
        this.maphongchieu = maphongchieu;
    }

    public String getSocho() {
        return socho;
    }

    public void setSocho(String socho) {
        this.socho = socho;
    }

    public String getMaychiue() {
        return maychiue;
    }

    public void setMaychiue(String maychiue) {
        this.maychiue = maychiue;
    }

    public String getTinhtrang() {
        return tinhtrang;
    }

    public void setTinhtrang(String tinhtrang) {
        this.tinhtrang = tinhtrang;
    }

    public PhongChieu(String maphongchieu, String socho, String maychiue, String tinhtrang) {
        this.maphongchieu = maphongchieu;
        this.socho = socho;
        this.maychiue = maychiue;
        this.tinhtrang = tinhtrang;
    }
}
