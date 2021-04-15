package com.company.qldatvexemphim.Entity;

import androidx.annotation.NonNull;

public class LichChieu {
    private String malichchieu;
    private String maphim;

    public String getMaphim() {
        return maphim;
    }

    public void setMaphim(String maphim) {
        this.maphim = maphim;
    }

    public LichChieu(String malichchieu, String maphim, String ngaychieu, String cachieu) {
        this.malichchieu = malichchieu;
        this.maphim = maphim;
        this.ngaychieu = ngaychieu;
        this.cachieu = cachieu;
    }

    private String ngaychieu;
    private String cachieu;

    public String getMalichchieu() {
        return malichchieu;
    }

    public void setMalichchieu(String malichchieu) {
        this.malichchieu = malichchieu;
    }

    public String getNgaychieu() {
        return ngaychieu;
    }

    public void setNgaychieu(String ngaychieu) {
        this.ngaychieu = ngaychieu;
    }

    public String getCachieu() {
        return cachieu;
    }

    public void setCachieu(String cachieu) {
        this.cachieu = cachieu;
    }

    @NonNull
    @Override
    public String toString() {
        return "Mã phim: "+maphim +"\nNgày chiếu: "+ngaychieu+"\nCa chiếu: "+cachieu;
    }
}
