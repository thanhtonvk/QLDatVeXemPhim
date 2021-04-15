package com.company.qldatvexemphim.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.company.qldatvexemphim.Entity.KhachHang;
import com.company.qldatvexemphim.Entity.NhanVien;
import com.company.qldatvexemphim.MainActivity;
import com.company.qldatvexemphim.R;

public class DangKyActivity extends AppCompatActivity {


    EditText edt_taikhoan, edt_matkhau, edt_nhaplaimatkhau;
    RadioButton rb_nhanvien, rb_khachhang;
    Button btn_dangky, btn_trolai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_ky);
        init();
        eventOnclik();
    }

    //ánh xạ điều khiển
    private void init() {
        edt_taikhoan = findViewById(R.id.edit_taikhoan_dangky);
        edt_nhaplaimatkhau = findViewById(R.id.edit_nhaplaimatkhau_dangky);
        edt_matkhau = findViewById(R.id.edit_nhapmatkhau_dangky);
        rb_nhanvien = findViewById(R.id.radiobutton_nhanvien);
        rb_khachhang = findViewById(R.id.radiobutton_khachhang);
        btn_dangky = findViewById(R.id.btn_dangky);
        btn_trolai = findViewById(R.id.btn_trolai);
    }


    private void eventOnclik() {
        //sự kiện click đăng ký
        btn_dangky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rb_nhanvien.isChecked()) {
                    if (edt_nhaplaimatkhau.getText().toString().equals(edt_matkhau.getText().toString())) {
                        if(checkTonTaiTaiKhoan(edt_taikhoan.getText().toString())){
                            Toast.makeText(getApplicationContext(),"Tài khoản đã tồn tại",Toast.LENGTH_LONG).show();
                        }
                        else {
                            NhanVien nhanVien = new NhanVien(edt_taikhoan.getText().toString(),edt_matkhau.getText().toString());
                            MainActivity.database.themNhanVien(nhanVien);
                            Toast.makeText(getApplicationContext(),"Tạo tài khoản nhân viên thành công",Toast.LENGTH_LONG).show();
                        }
                    } else
                        Toast.makeText(getApplicationContext(), "Vui lòng nhập lại mật khẩu khớp với mật khẩu", Toast.LENGTH_LONG).show();
                }
                if (rb_khachhang.isChecked()) {
                    if (edt_nhaplaimatkhau.getText().toString().equals(edt_matkhau.getText().toString())) {
                        if(checkTonTaiTaiKhoan(edt_taikhoan.getText().toString())){
                            Toast.makeText(getApplicationContext(),"Tài khoản đã tồn tại",Toast.LENGTH_LONG).show();
                        }
                        else {
                            KhachHang khachHang = new KhachHang(edt_taikhoan.getText().toString(),edt_matkhau.getText().toString());
                            MainActivity.database.themKhachHang(khachHang);
                            Toast.makeText(getApplicationContext(),"Tạo tài khoản khách hàng thành công",Toast.LENGTH_LONG).show();
                        }
                    } else
                        Toast.makeText(getApplicationContext(), "Vui lòng nhập lại mật khẩu khớp với mật khẩu", Toast.LENGTH_LONG).show();
                }
            }
        });
        btn_trolai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),DangNhapActivity.class));
                finish();
            }
        });
    }

    //kiểm tra xem tài khoản đã tồn tại chưa
    private boolean checkTonTaiTaiKhoan(String taikhoan) {
        boolean check = false;
        for (NhanVien nhanVien : MainActivity.database.layDsNhanVien()) {
            if(taikhoan.equalsIgnoreCase(nhanVien.getTaikhoan())) check = true;
        }
        return check;
    }
}