package com.company.qldatvexemphim.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.company.qldatvexemphim.Entity.LichChieu;
import com.company.qldatvexemphim.Entity.Phim;
import com.company.qldatvexemphim.Entity.PhongChieu;
import com.company.qldatvexemphim.MainActivity;
import com.company.qldatvexemphim.R;

public class QuanLyPhongChieuActivity extends AppCompatActivity {

    Button btn_them_phongchieu;
    ListView listView;
    ArrayAdapter<PhongChieu> phongChieuArrayAdapter;
    AutoCompleteTextView autoComplete_phongchieu;
    Dialog dialog_them;
    Dialog dialog_listphongchieu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quan_ly_phong_chieu);
        init();
        phongChieuArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, MainActivity.database.layDsPhongChieu());
        listView.setAdapter(phongChieuArrayAdapter);
        autoComplete_phongchieu.setAdapter(phongChieuArrayAdapter);
        eventOnClick();
    }
    private void init(){
        btn_them_phongchieu = findViewById(R.id.btn_them_phongchieu);
        listView = findViewById(R.id.listview_phongchieu);
        autoComplete_phongchieu = findViewById(R.id.autoComplete_phongchieu);
    }
    private void eventOnClick(){
        btn_them_phongchieu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDialog_them();
            }
        });
    }
    private void setDialog_them(){
        ArrayAdapter<PhongChieu> phimArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, MainActivity.database.layDsPhongChieu());
        dialog_them = new Dialog(this);
        dialog_them.setContentView(R.layout.custom_dialog_them_phongchieu);
        EditText editText_socho = dialog_them.findViewById(R.id.edit_socho);
        EditText editText_maychieu = dialog_them.findViewById(R.id.edit_maychieu);
        EditText editText_tinhtrang = dialog_them.findViewById(R.id.edit_tinhtrang);
        Button btn_themphongchieu = dialog_them.findViewById(R.id.btn_dialog_themphongchieu);
        btn_themphongchieu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LichChieu lichChieu = new LichChieu(autoMaPhongChieu(), editText_socho.getText().toString(), editText_maychieu.getText().toString(), editText_tinhtrang.getText().toString());
                MainActivity.database.themLichChieu(lichChieu);
                phongChieuArrayAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, MainActivity.database.layDsPhongChieu());
                listView.setAdapter(phongChieuArrayAdapter);
                autoComplete_phongchieu.setAdapter(phongChieuArrayAdapter);
                dialog_them.dismiss();

            }
        });
        dialog_them.show();
    }
    public String autoMaPhongChieu() {
        String ma = "MPC";
        int n = 0;
        for (PhongChieu phongChieu : MainActivity.database.layDsPhongChieu()) {
            if (!(ma + n).equalsIgnoreCase(phongChieu.getMaphongchieu())) {
                break;
            } else n += 1;
        }
        return ma + n;
    }
}