package com.company.qldatvexemphim.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.company.qldatvexemphim.Entity.KhachHang;
import com.company.qldatvexemphim.Entity.TaiKhoan;
import com.company.qldatvexemphim.MainActivity;
import com.company.qldatvexemphim.R;

import java.util.ArrayList;
import java.util.List;

public class DangNhapActivity extends AppCompatActivity {

    EditText edt_taikhoan,edt_matkhau;
    Button btn_dangnhap,btn_dangky;
    List<TaiKhoan> taiKhoanList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_nhap);
        init();
        taiKhoanList= new ArrayList<>();
        taiKhoanList.addAll(MainActivity.database.layDsKhachHang());
        taiKhoanList.addAll(MainActivity.database.layDsNhanVien());
        eventOnClick();
    }
    //ánh xạ các điều khiển
    private void init(){
        edt_taikhoan = findViewById(R.id.edit_taikhoan_dangnhap);
        edt_matkhau = findViewById(R.id.edit_matkhau_dangnhap);
        btn_dangnhap =  findViewById(R.id.btn_dangnhap);
        btn_dangky= findViewById(R.id.btn_dangky_dangnhap);
    }
    //kiểu tra đăng nhập, nếu thất bại trả về false, thành công trả về true
    public boolean checkDangNhap(){
        boolean check = false;
        for (TaiKhoan taiKhoan: taiKhoanList){
            if(taiKhoan.getTaikhoan().equals(edt_taikhoan.getText().toString())&&taiKhoan.getMatkhau().equals(edt_matkhau.getText().toString())){
                check = true;
                //nếu tài khoản được phân quyền là khách hàng sẽ mở phần của khách hàng
                if(taiKhoan instanceof KhachHang){
                    Toast.makeText(getApplicationContext(),"Khách hàng",Toast.LENGTH_LONG).show();
                }
                //còn lại là được phân quyền là \nhân viên sẽ mở trang quản lý
                else {
                    startActivity(new Intent(getApplicationContext(),NhanVienActivity.class));
                    finish();
                }
            }
        }
        return check;
    }
    private void eventOnClick(){

        //khi click vào nút đăng nhập
        btn_dangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              if(checkDangNhap()){
                  Toast.makeText(getApplicationContext(),"Đăng nhập thành công",Toast.LENGTH_LONG).show();
              }
              else {
                  Toast.makeText(getApplicationContext(),"Tài khoản hoặc mật khẩu không chính xác",Toast.LENGTH_LONG).show();
              }
            }
        });
        //mở trang đăng ký tài khoản
        btn_dangky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),DangKyActivity.class));
                finish();
            }
        });
    }
}