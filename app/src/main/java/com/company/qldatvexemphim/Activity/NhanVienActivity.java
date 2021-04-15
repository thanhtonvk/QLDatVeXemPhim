package com.company.qldatvexemphim.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.company.qldatvexemphim.R;

public class NhanVienActivity extends AppCompatActivity {

    Button button_qlkhachhang, button_qllichchieu, button_qlphim, button_qlphongchieu, button_qlve, button_qltaikhoan, button_dangxuat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nhan_vien);
        init();
        eventOnClick();
    }

    private void init() {
        //ánh xạ các điều khiển
        button_qlkhachhang = findViewById(R.id.btn_khachhang);
        button_qllichchieu = findViewById(R.id.btn_qllichchieu);
        button_qlphim = findViewById(R.id.btn_qlphim);
        button_qlphongchieu = findViewById(R.id.btn_qlphongchieu);
        button_qlve = findViewById(R.id.btn_qlve);
        button_qltaikhoan = findViewById(R.id.btn_qltaikhoan);
        button_dangxuat = findViewById(R.id.btn_dangxuat);
    }

    private void eventOnClick() {
        //gọi sự kiện khi ấn vào button quản lý khách hàng
        button_qlkhachhang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), QuanLyKhachHangActivity.class));
            }
        });
        button_dangxuat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),DangNhapActivity.class));
                finish();
            }
        });
        button_qllichchieu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),QuanLyLichChieuActivity.class));
            }
        });
        button_qlphim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),QuanLyPhimActivity.class));
            }
        });
        button_qlphongchieu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),QuanLyPhongChieuActivity.class));
            }
        });
    }
}