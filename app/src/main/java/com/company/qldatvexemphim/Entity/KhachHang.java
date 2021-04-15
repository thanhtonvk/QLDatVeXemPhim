package com.company.qldatvexemphim.Entity;

public class KhachHang extends TaiKhoan{
    private String hoten,ngaysinh,sodienthoai,soCMND;
    private boolean phanquyen;


    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getSodienthoai() {
        return sodienthoai;
    }

    public void setSodienthoai(String sodienthoai) {
        this.sodienthoai = sodienthoai;
    }

    public String getSoCMND() {
        return soCMND;
    }

    public void setSoCMND(String soCMND) {
        this.soCMND = soCMND;
    }

    public boolean isPhanquyen() {
        return phanquyen;
    }


    public void setPhanquyen(boolean phanquyen) {
        this.phanquyen = phanquyen;
    }

    public KhachHang(String taikhoan, String matkhau, String hoten, String ngaysinh, String sodienthoai, String soCMND) {
        super(taikhoan, matkhau);
        this.hoten = hoten;
        this.ngaysinh = ngaysinh;
        this.sodienthoai = sodienthoai;
        this.soCMND = soCMND;
        this.phanquyen = false;
    }
    public KhachHang(String taikhoan, String matkhau, String hoten, String ngaysinh, String sodienthoai, String soCMND,boolean phanquyen) {
        super(taikhoan, matkhau);
        this.hoten = hoten;
        this.ngaysinh = ngaysinh;
        this.sodienthoai = sodienthoai;
        this.soCMND = soCMND;
        this.phanquyen = phanquyen;
    }
    public KhachHang(String taikhoan, String matkhau) {
        super(taikhoan, matkhau);
    }

    @Override
    public String toString() {
        return "Tên tài khoản: "+getTaikhoan() + "\nHọ tên: "+getHoten();
    }
}
