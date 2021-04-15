package com.company.qldatvexemphim.Entity;

public class NhanVien extends TaiKhoan{
    private String hoten,ngaysinh,sodienthoai,soCMND;
    private boolean phanquyen;
    private String gioitinh,quequan,chucvu;

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

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getQuequan() {
        return quequan;
    }

    public void setQuequan(String quequan) {
        this.quequan = quequan;
    }

    public String getChucvu() {
        return chucvu;
    }

    public void setChucvu(String chucvu) {
        this.chucvu = chucvu;
    }

    public NhanVien(String taikhoan, String matkhau, String hoten, String ngaysinh, String sodienthoai, String soCMND, boolean phanquyen, String gioitinh, String quequan, String chucvu) {
        super(taikhoan, matkhau);
        this.hoten = hoten;
        this.ngaysinh = ngaysinh;
        this.sodienthoai = sodienthoai;
        this.soCMND = soCMND;
        this.phanquyen = true;
        this.gioitinh = gioitinh;
        this.quequan = quequan;
        this.chucvu = chucvu;
    }
    public NhanVien(String taikhoan,String matkhau){
        super(taikhoan,matkhau);
    }
}
