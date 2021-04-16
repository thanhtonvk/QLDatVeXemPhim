package com.company.qldatvexemphim.CSDL;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.company.qldatvexemphim.Entity.KhachHang;
import com.company.qldatvexemphim.Entity.LichChieu;
import com.company.qldatvexemphim.Entity.NhanVien;
import com.company.qldatvexemphim.Entity.Phim;
import com.company.qldatvexemphim.Entity.PhongChieu;
import com.company.qldatvexemphim.Entity.Ve;

import java.util.ArrayList;
import java.util.List;

public class Database extends SQLiteOpenHelper {


    public Database(Context context) {
        super(context, "QLDatVeXemPhim", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
//        String taikhoan, String matkhau, String hoten, String ngaysinh, String sodienthoai, String soCMND, boolean phanquyen
        //tạo bảng khách hàng
        db.execSQL("CREATE TABLE KHACHHANG(" +
                "TAIKHOAN VARCHAR(20) PRIMARY KEY," +
                "MATKHAU VARCHAR(10) NOT NULL," +
                "HOTEN TEXT," +
                "NGAYSINH TEXT," +
                "SODIENTHOAI TEXT," +
                "SOCMND TEXT," +
                "PHANQUYEN TEXT)");
        //tạo bảng nhân viên
//        String taikhoan, String matkhau, String hoten, String ngaysinh, String sodienthoai, String soCMND, boolean phanquyen, String gioitinh, String quequan, String chucvu
        db.execSQL("CREATE TABLE NHANVIEN(" +
                "TAIKHOAN VARCHAR(20) PRIMARY KEY," +
                "MATKHAU VARCHAR(20) NOT NULL," +
                "HOTEN TEXT," +
                "NGAYSINH TEXT," +
                "SODIENTHOAI TEXT," +
                "SOCMND TEXT," +
                "PHANQUYEN TEXT," +
                "GIOITINH TEXT," +
                "QUEQUAN TEXT," +
                "CHUCVU TEXT)");
        //TẠO BẢNG LỊCH CHIẾU
//        String malichchieu, String ngaychieu, String cachieu
        db.execSQL("CREATE TABLE LICHCHIEU(" +
                "MALICHCHIEU CHAR(5) PRIMARY KEY," +
                "MAPHIM TEXT NOT NULL,"+
                "NGAYCHIEU DATETIME," +
                "CACHIEU TEXT)");
        //TẠO BẢNG PHIM
//        String maphim, String tenloai,tenphim
        db.execSQL("CREATE TABLE PHIM(" +
                "MAPHIM CHAR(5) PRIMARY KEY," +
                "TENLOAI TEXT," +
                "TENPHIM TEXT," +
                "MOTA TEXT)");
        //TẠO BẢNG PHÒNG CHIẾU
//        String maphongchieu, String socho, String maychiue, String tinhtrang
        db.execSQL("CREATE TABLE PHONGCHIEU(" +
                "MAPHONGCHIEU CHAR(5) PRIMARY KEY," +
                "SOCHO TEXT," +
                "MAYCHIEU TEXT," +
                "TINHTRANG TEXT)");
        //TẠO BẢNG VÉ
//        String mave, String tenloai, String loaiphim, String loaikhachhang, double giave
        db.execSQL("CREATE TABLE VE(" +
                "MAVE CHAR(5) PRIMARY KEY," +
                "TENLOAI TEXT," +
                "LOAIPHIM TEXT," +
                "LOAIKHACHHANG TEXT," +
                "GIAVE FLOAT)");
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS KHACHHANG");
        db.execSQL("DROP TABLE IF EXISTS NHANVIEN");
        db.execSQL("DROP TABLE IF EXISTS LICHCHIEU");
        db.execSQL("DROP TABLE IF EXISTS PHIM");
        db.execSQL("DROP TABLE IF EXISTS PHONGCHIEU");
        db.execSQL("DROP TABLE IF EXISTS VE");
        onCreate(db);
    }

    public void themKhachHang(KhachHang khachHang) {
        SQLiteDatabase database = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("TAIKHOAN", khachHang.getTaikhoan());
        values.put("MATKHAU", khachHang.getMatkhau());
        values.put("HOTEN", khachHang.getHoten());
        values.put("NGAYSINH", khachHang.getNgaysinh());
        values.put("SODIENTHOAI", khachHang.getSodienthoai());
        values.put("SOCMND", khachHang.getSoCMND());
        values.put("PHANQUYEN", String.valueOf(khachHang.isPhanquyen()));
        database.insert("KHACHHANG", null, values);
        database.close();
    }

    public void themNhanVien(NhanVien nhanVien) {
        SQLiteDatabase database = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("TAIKHOAN", nhanVien.getTaikhoan());
        values.put("MATKHAU", nhanVien.getMatkhau());
        values.put("HOTEN", nhanVien.getHoten());
        values.put("NGAYSINH", nhanVien.getNgaysinh());
        values.put("SODIENTHOAI", nhanVien.getSodienthoai());
        values.put("SOCMND", nhanVien.getSoCMND());
        values.put("PHANQUYEN", String.valueOf(nhanVien.isPhanquyen()));
        values.put("GIOITINH", nhanVien.getGioitinh());
        values.put("QUEQUAN", nhanVien.getQuequan());
        values.put("CHUCVU", nhanVien.getChucvu());
        database.insert("NHANVIEN", null, values);
        database.close();
    }

    //        String malichchieu, String ngaychieu, String cachieu
    public void themLichChieu(LichChieu lichChieu) {
        SQLiteDatabase database = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("MALICHCHIEU", lichChieu.getMalichchieu());
        values.put("NGAYCHIEU", lichChieu.getNgaychieu());
        values.put("MAPHIM",lichChieu.getMaphim());
        values.put("CACHIEU", lichChieu.getCachieu());
        database.insert("LICHCHIEU", null, values);
        database.close();
    }

    //        String maphim, String tenloai,tenphim
    public void themPhim(Phim phim) {
        SQLiteDatabase database = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("MAPHIM", phim.getMaphim());
        values.put("TENLOAI", phim.getTenloai());
        values.put("TENPHIM", phim.getTenphim());
        values.put("MOTA",phim.getMota());
        database.insert("PHIM", null, values);
        database.close();
    }

    //        String maphongchieu, String socho, String maychiue, String tinhtrang
    public void themPhongChieu(PhongChieu phongChieu) {
        SQLiteDatabase database = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("MAPHONGCHIEU", phongChieu.getMaphongchieu());
        values.put("SOCHO", phongChieu.getSocho());
        values.put("MAYCHIEU", phongChieu.getMaychiue());
        values.put("TINHTRANG", phongChieu.getTinhtrang());
        database.insert("PHONGCHIEU", null, values);
        database.close();
    }

    //        String mave, String tenloai, String loaiphim, String loaikhachhang, double giave
    public void themVe(Ve ve) {
        SQLiteDatabase database = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("MAVE", ve.getMave());
        values.put("TENLOAI", ve.getTenloai());
        values.put("LOAIPHIM", ve.getLoaiphim());
        values.put("LOAIKHACHHANG", ve.getLoaikhachhang());
        values.put("GIAVE", ve.getGiave());
        database.insert("VE", null, values);
        database.close();
    }

    //lấy danh sách trong bảng cho vào mảng
    public List<KhachHang> layDsKhachHang() {
        //tạo 1 mảng để lưu thông tin
        List<KhachHang> khachHangs = new ArrayList<>();
        //chế độ đọc trong sqlite
        SQLiteDatabase database = getReadableDatabase();
        //gọi con trỏ
        Cursor cursor = database.rawQuery("SELECT * FROM KHACHHANG", null);
        //con trỏ từ vị trí đầu
        cursor.moveToFirst();
        //duyệt tới khi con trỏ đến cuối cùng
        while (!cursor.isAfterLast()) {
            KhachHang khachHang = new KhachHang(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5), Boolean.parseBoolean(cursor.getString(6)));
            khachHangs.add(khachHang);
            cursor.moveToNext();
        }
        cursor.close();
        database.close();
        return khachHangs;
    }

    //lấy danh sách trong bảng cho vào mảng
    public List<NhanVien> layDsNhanVien() {
        //tạo 1 mảng để lưu thông tin
        List<NhanVien> nhanViens = new ArrayList<>();
        //chế độ đọc trong sqlite
        SQLiteDatabase database = getReadableDatabase();
        //gọi con trỏ
        Cursor cursor = database.rawQuery("SELECT * FROM NHANVIEN", null);
        //con trỏ từ vị trí đầu
        cursor.moveToFirst();
        //duyệt tới khi con trỏ đến cuối cùng
        while (!cursor.isAfterLast()) {
            NhanVien nhanVien = new NhanVien(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5), Boolean.parseBoolean(cursor.getString(6)), cursor.getString(7), cursor.getString(8), cursor.getString(9));
            nhanViens.add(nhanVien);
            cursor.moveToNext();
        }
        cursor.close();
        database.close();
        return nhanViens;
    }

    //lấy danh sách trong bảng cho vào mảng
    public List<LichChieu> layDsLichChieu() {
        //tạo 1 mảng để lưu thông tin
        List<LichChieu> lichChieus = new ArrayList<>();
        //chế độ đọc trong sqlite
        SQLiteDatabase database = getReadableDatabase();
        //gọi con trỏ
        Cursor cursor = database.rawQuery("SELECT * FROM LICHCHIEU", null);
        //con trỏ từ vị trí đầu
        cursor.moveToFirst();
        //duyệt tới khi con trỏ đến cuối cùng
        while (!cursor.isAfterLast()) {
            LichChieu lichChieu = new LichChieu(cursor.getString(0), cursor.getString(1), cursor.getString(2),cursor.getString(3));
            lichChieus.add(lichChieu);
            cursor.moveToNext();
        }
        cursor.close();
        database.close();
        return lichChieus;
    }

    //lấy danh sách trong bảng cho vào mảng
    public List<Phim> layDsPhim() {
        //tạo 1 mảng để lưu thông tin
        List<Phim> phims = new ArrayList<>();
        //chế độ đọc trong sqlite
        SQLiteDatabase database = getReadableDatabase();
        //gọi con trỏ
        Cursor cursor = database.rawQuery("SELECT * FROM PHIM", null);
        //con trỏ từ vị trí đầu
        cursor.moveToFirst();
        //duyệt tới khi con trỏ đến cuối cùng
        while (!cursor.isAfterLast()) {
            Phim phim = new Phim(cursor.getString(0), cursor.getString(1), cursor.getString(2),cursor.getString(3));
            phims.add(phim);
            cursor.moveToNext();
        }
        cursor.close();
        database.close();
        return phims;
    }

    //lấy danh sách trong bảng cho vào mảng
    public List<PhongChieu> layDsPhongChieu() {
        //tạo 1 mảng để lưu thông tin
        List<PhongChieu> phongChieus = new ArrayList<>();
        //chế độ đọc trong sqlite
        SQLiteDatabase database = getReadableDatabase();
        //gọi con trỏ
        Cursor cursor = database.rawQuery("SELECT * FROM PHONGCHIEU", null);
        //con trỏ từ vị trí đầu
        cursor.moveToFirst();
        //duyệt tới khi con trỏ đến cuối cùng
        while (!cursor.isAfterLast()) {
            PhongChieu phongChieu = new PhongChieu(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3));
            phongChieus.add(phongChieu);
            cursor.moveToNext();
        }
        cursor.close();
        database.close();
        return phongChieus;
    }

    //lấy danh sách trong bảng cho vào mảng
    public List<Ve> layDsVe() {
        //tạo 1 mảng để lưu thông tin
        List<Ve> ves = new ArrayList<>();
        //chế độ đọc trong sqlite
        SQLiteDatabase database = getReadableDatabase();
        //gọi con trỏ
        Cursor cursor = database.rawQuery("SELECT * FROM VE", null);
        //con trỏ từ vị trí đầu
        cursor.moveToFirst();
        //duyệt tới khi con trỏ đến cuối cùng
        while (!cursor.isAfterLast()) {
            Ve ve = new Ve(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getFloat(4));
            ves.add(ve);
            cursor.moveToNext();
        }
        cursor.close();
        database.close();
        return ves;
    }

    //Cập nhật danh sách
    public void capNhatKhachHang(KhachHang khachHang) {
        SQLiteDatabase database = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("TAIKHOAN", khachHang.getTaikhoan());
        values.put("MATKHAU", khachHang.getMatkhau());
        values.put("HOTEN", khachHang.getHoten());
        values.put("NGAYSINH", khachHang.getNgaysinh());
        values.put("SODIENTHOAI", khachHang.getSodienthoai());
        values.put("SOCMND", khachHang.getSoCMND());
        values.put("PHANQUYEN", String.valueOf(khachHang.isPhanquyen()));
        database.update("KHACHHANG", values, "TAIKHOAN = ?",new String[]{khachHang.getTaikhoan()});
        database.close();
    }

    public void capNhatNhanVien(NhanVien nhanVien) {
        SQLiteDatabase database = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("TAIKHOAN", nhanVien.getTaikhoan());
        values.put("MATKHAU", nhanVien.getMatkhau());
        values.put("HOTEN", nhanVien.getHoten());
        values.put("NGAYSINH", nhanVien.getNgaysinh());
        values.put("SODIENTHOAI", nhanVien.getSodienthoai());
        values.put("SOCMND", nhanVien.getSoCMND());
        values.put("PHANQUYEN", String.valueOf(nhanVien.isPhanquyen()));
        values.put("GIOITINH", nhanVien.getGioitinh());
        values.put("QUEQUAN", nhanVien.getQuequan());
        values.put("CHUCVU", nhanVien.getChucvu());
        database.update("NHANVIEN", values, "TAIKHOAN = ?", new String[]{nhanVien.getTaikhoan()});
        database.close();
    }

    public void capNhatLichChieu(LichChieu lichChieu) {
        SQLiteDatabase database = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("MALICHCHIEU", lichChieu.getMalichchieu());
        values.put("NGAYCHIEU", lichChieu.getNgaychieu());
        values.put("MAPHIM",lichChieu.getMaphim());
        values.put("CACHIEU", lichChieu.getCachieu());
        database.update("LICHCHIEU", values, "MALICHCHIEU = ?", new String[]{lichChieu.getMalichchieu()});
        database.close();
    }

    public void capNhatPhim(Phim phim) {
        SQLiteDatabase database = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("MAPHIM", phim.getMaphim());
        values.put("TENLOAI", phim.getTenloai());
        values.put("TENPHIM", phim.getTenphim());
        values.put("MOTA",phim.getMota());
        database.update("PHIM", values, "MAPHIM = ?", new String[]{phim.getMaphim()});
        database.close();
    }

    public void capNhatPhongChieu(PhongChieu phongChieu) {
        SQLiteDatabase database = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("MAPHONGCHIEU", phongChieu.getMaphongchieu());
        values.put("SOCHO", phongChieu.getSocho());
        values.put("MAYCHIEU", phongChieu.getMaychiue());
        values.put("TINHTRANG", phongChieu.getTinhtrang());
        database.update("PHONGCHIEU", values, "MAPHONGCHIEU = ?", new String[]{phongChieu.getMaphongchieu()});
        database.close();
    }

    public void capNhatVe(Ve ve) {
        SQLiteDatabase database = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("MAVE", ve.getMave());
        values.put("TENLOAI", ve.getTenloai());
        values.put("LOAIPHIM", ve.getLoaiphim());
        values.put("LOAIKHACHHANG", ve.getLoaikhachhang());
        values.put("GIAVE", ve.getGiave());
        database.update("VE", values, "MAVE = ?", new String[]{ve.getMave()});
        database.close();
    }

    //xóa thông tin trong bảng database
    public void xoaKhachHang(KhachHang khachHang) {
        SQLiteDatabase database = getWritableDatabase();
        database.delete("KHACHHANG", "TAIKHOAN = ?", new String[]{khachHang.getTaikhoan()});
        database.close();
    }

    public void xoaNhanVien(NhanVien nhanVien) {
        SQLiteDatabase database = getWritableDatabase();
        database.delete("NHANVIEN", "TAIKHOAN = ?", new String[]{nhanVien.getTaikhoan()});
        database.close();
    }

    public void xoaLichChieu(LichChieu lichChieu) {
        SQLiteDatabase database = getWritableDatabase();
        database.delete("LICHCHIEU", "MALICHCHIEU = ?", new String[]{lichChieu.getMalichchieu()});
        database.close();
    }

    public void xoaPhim(Phim phim) {
        SQLiteDatabase database = getWritableDatabase();
        database.delete("PHIM", "MAPHIM  = ?", new String[]{phim.getMaphim()});
        database.close();
    }

    public void xoaPhongChieu(PhongChieu phongChieu) {
        SQLiteDatabase database = getWritableDatabase();
        database.delete("PHONGCHIEU", "MAPHONGCHIEU  = ?", new String[]{phongChieu.getMaphongchieu()});
        database.close();
    }

    public void xoaVe(Ve ve) {
        SQLiteDatabase database = getWritableDatabase();
        database.delete("VE", "MAVE  = ?", new String[]{ve.getMave()});
        database.close();
    }
}
