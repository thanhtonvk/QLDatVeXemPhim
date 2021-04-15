package com.company.qldatvexemphim.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.company.qldatvexemphim.Entity.KhachHang;
import com.company.qldatvexemphim.MainActivity;
import com.company.qldatvexemphim.R;

public class QuanLyKhachHangActivity extends AppCompatActivity {

    AutoCompleteTextView autoComplete_khachhang;
    ListView listView_khachhang;
    ArrayAdapter<KhachHang> khachHangArrayAdapter;
    Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quan_ly_khach_hang);
        init();

        if (MainActivity.database.layDsKhachHang() != null) {
            khachHangArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, MainActivity.database.layDsKhachHang());
            listView_khachhang.setAdapter(khachHangArrayAdapter);
            autoComplete_khachhang.setAdapter(khachHangArrayAdapter);
        }
        listView_khachhang.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                setDialog(position);
            }
        });

    }

    private void init() {
        autoComplete_khachhang = findViewById(R.id.autoComplete_khachhang);
        listView_khachhang = findViewById(R.id.listview_khachhang);
    }

    private void setDialog(int position) {
        EditText edt_matkhau, edt_hoten, edt_ngaysinh, edt_sdt, edt_cmnd;
        Button btn_capnhat, btn_xoataikhoan;
        dialog = new Dialog(this);
        dialog.setContentView(R.layout.custom_dialog_thongtinkhachhang);
        //ánh xạ các điều khiển trong dialog
        edt_matkhau = dialog.findViewById(R.id.edit_matkhau_thongtinkhachhang);
        edt_hoten = dialog.findViewById(R.id.edit_hoten_thongtinkhachhang);
        edt_ngaysinh = dialog.findViewById(R.id.edit_ngaysinh_thongtinkhachhang);
        edt_sdt = dialog.findViewById(R.id.edit_sodienthoai_thongtinkhachhang);
        edt_cmnd = dialog.findViewById(R.id.edit_socmnd_thongtinkhachhang);
        btn_capnhat = dialog.findViewById(R.id.btn_capnhat);
        btn_xoataikhoan = dialog.findViewById(R.id.btn_xoataikhoan);

        //lấy dữ liệu trong database gán vào edittext
        edt_matkhau.setText(MainActivity.database.layDsKhachHang().get(position).getMatkhau());
        edt_hoten.setText(MainActivity.database.layDsKhachHang().get(position).getHoten());
        edt_ngaysinh.setText(MainActivity.database.layDsKhachHang().get(position).getNgaysinh());
        edt_sdt.setText(MainActivity.database.layDsKhachHang().get(position).getSodienthoai());
        edt_cmnd.setText(MainActivity.database.layDsKhachHang().get(position).getSoCMND());


        //xóa tài khoản
        btn_xoataikhoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.database.xoaKhachHang(MainActivity.database.layDsKhachHang().get(position));
                Toast.makeText(getApplicationContext(), "Tài khoản đã bị xóa", Toast.LENGTH_LONG).show();
                khachHangArrayAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, MainActivity.database.layDsKhachHang());
                listView_khachhang.setAdapter(khachHangArrayAdapter);
                autoComplete_khachhang.setAdapter(khachHangArrayAdapter);
                listView_khachhang.setAdapter(khachHangArrayAdapter);
                dialog.dismiss();
            }
        });
        btn_capnhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                KhachHang khachHang = new KhachHang(MainActivity.database.layDsKhachHang().get(position).getTaikhoan(), edt_matkhau.getText().toString(), edt_hoten.getText().toString(), edt_ngaysinh.getText().toString(), edt_sdt.getText().toString(), edt_cmnd.getText().toString());
                MainActivity.database.capNhatKhachHang(khachHang);
                Toast.makeText(getApplicationContext(), "Tài khoản đã được cập nhật", Toast.LENGTH_LONG).show();
                khachHangArrayAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, MainActivity.database.layDsKhachHang());
                listView_khachhang.setAdapter(khachHangArrayAdapter);
                autoComplete_khachhang.setAdapter(khachHangArrayAdapter);
                dialog.dismiss();
            }
        });
        dialog.show();
    }
}