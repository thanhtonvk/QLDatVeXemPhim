package com.company.qldatvexemphim.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.company.qldatvexemphim.Entity.LichChieu;
import com.company.qldatvexemphim.Entity.Phim;
import com.company.qldatvexemphim.MainActivity;
import com.company.qldatvexemphim.R;

public class QuanLyPhimActivity extends AppCompatActivity {
    Button btn_them_phim;
    ListView listView;
    ArrayAdapter<Phim> phimArrayAdapter;
    AutoCompleteTextView autoComplete_phim;
    Dialog dialog_them;
    Dialog dialog_listphim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quan_ly_phim);
        init();
        phimArrayAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, MainActivity.database.layDsPhim());
        autoComplete_phim.setAdapter(phimArrayAdapter);
        listView.setAdapter(phimArrayAdapter);
        eventOnClick();
    }
    private void init(){
        btn_them_phim = findViewById(R.id.btn_them_phim);
        listView = findViewById(R.id.listview_phim);
        autoComplete_phim = findViewById(R.id.autoComplete_phim);
    }
    private void eventOnClick(){
        btn_them_phim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDialog_them();
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                setDialog_listphim(position);
            }
        });
    }
    private void setDialog_listphim(int position){
        dialog_listphim = new Dialog(this);
        dialog_listphim.setContentView(R.layout.custom_dialog_thongtin_phim);
        EditText editText_tenphim,editText_theloai,editText_mota;
        TextView textView_maphim;
        Button btn_xoa,btn_capnhat;
        editText_tenphim = dialog_listphim.findViewById(R.id.edt_dialog_tenphim);
        editText_theloai = dialog_listphim.findViewById(R.id.edit_dialog_theloai);
        editText_mota = dialog_listphim.findViewById(R.id.edit_dialog_mota);
        textView_maphim = dialog_listphim.findViewById(R.id.id_dialog_maphim);
        btn_xoa= dialog_listphim.findViewById(R.id.btn_dialog_xoaphim);
        btn_capnhat = dialog_listphim.findViewById(R.id.btn_dialog_capnhat);
        editText_tenphim.setText(MainActivity.database.layDsPhim().get(position).getTenphim());
        editText_theloai.setText(MainActivity.database.layDsPhim().get(position).getTenloai());
        editText_mota.setText(MainActivity.database.layDsPhim().get(position).getMota());
        textView_maphim.setText(MainActivity.database.layDsPhim().get(position).getMaphim());
        btn_capnhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Phim phim = new Phim(textView_maphim.getText().toString(),editText_theloai.getText().toString(),editText_tenphim.getText().toString(),editText_mota.getText().toString());
                MainActivity.database.capNhatPhim(phim);
                phimArrayAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, MainActivity.database.layDsPhim());
                autoComplete_phim.setAdapter(phimArrayAdapter);
                listView.setAdapter(phimArrayAdapter);
                dialog_listphim.dismiss();
            }
        });
        btn_xoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.database.xoaPhim(MainActivity.database.layDsPhim().get(position));
                phimArrayAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, MainActivity.database.layDsPhim());
                autoComplete_phim.setAdapter(phimArrayAdapter);
                listView.setAdapter(phimArrayAdapter);
                dialog_listphim.dismiss();
            }
        });
        dialog_listphim.show();
    }
    private void setDialog_them(){
        dialog_them = new Dialog(this);
        dialog_them.setContentView(R.layout.custom_dialog_phim);
        EditText editText_tenphim,editText_loaiphim,editText_mota;
        editText_tenphim = dialog_them.findViewById(R.id.edit_tenphim);
        editText_loaiphim = dialog_them.findViewById(R.id.edit_tenloai);
        editText_mota = dialog_them.findViewById(R.id.edit_mota);
        Button btn_them;
        btn_them  = dialog_them.findViewById(R.id.btn_dialog_themphim);
        btn_them.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Phim phim = new Phim(autoMaPhim(),editText_loaiphim.getText().toString(),editText_tenphim.getText().toString(),editText_mota.getText().toString());
                MainActivity.database.themPhim(phim);
                phimArrayAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, MainActivity.database.layDsPhim());
                autoComplete_phim.setAdapter(phimArrayAdapter);
                listView.setAdapter(phimArrayAdapter);
                dialog_them.dismiss();
            }
        });

        dialog_them.show();
    }
    private String autoMaPhim(){
        String ma = "MP";
        int n = 0;
        for (Phim phim : MainActivity.database.layDsPhim()) {
            if (!(ma + n).equalsIgnoreCase(phim.getMaphim())) {
                break;
            } else n += 1;
        }
        return ma + n;
    }
}