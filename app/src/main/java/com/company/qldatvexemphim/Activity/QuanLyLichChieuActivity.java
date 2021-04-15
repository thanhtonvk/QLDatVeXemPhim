package com.company.qldatvexemphim.Activity;

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

import androidx.appcompat.app.AppCompatActivity;

import com.company.qldatvexemphim.Entity.LichChieu;
import com.company.qldatvexemphim.Entity.Phim;
import com.company.qldatvexemphim.MainActivity;
import com.company.qldatvexemphim.R;

public class QuanLyLichChieuActivity extends AppCompatActivity {

    Button btn_them_lichchieu;
    ListView listView;
    ArrayAdapter<LichChieu> lichChieuArrayAdapter;
    AutoCompleteTextView autoComplete_lichchieu;
    Dialog dialog_them;
    Dialog dialog_listlichchieu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quan_ly_lich_chieu);
        init();
        lichChieuArrayAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, MainActivity.database.layDsLichChieu());
        listView.setAdapter(lichChieuArrayAdapter);
        autoComplete_lichchieu.setAdapter(lichChieuArrayAdapter);
        eventOnClick();
    }

    private void init() {
        btn_them_lichchieu = findViewById(R.id.btn_them_lichchieu);
        listView = findViewById(R.id.listview_lichchieu);
        autoComplete_lichchieu = findViewById(R.id.autoComplete_lichchieu);
    }

    private void eventOnClick() {
        btn_them_lichchieu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDialog_them();
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                setDialog_listlichchieu(position);
            }
        });
    }

    public void setDialog_listlichchieu(int posititon) {
        dialog_listlichchieu = new Dialog(this);
        dialog_listlichchieu.setContentView(R.layout.custom_dialog_lichchieu);
        TextView tv_malichchieu,tv_phim,tv_ngaychieu,tv_cachieu;
        Button btn_xoa;
        tv_malichchieu = dialog_listlichchieu.findViewById(R.id.tv_malichchieu);
        tv_phim = dialog_listlichchieu.findViewById(R.id.tv_phim);
        tv_ngaychieu = dialog_listlichchieu.findViewById(R.id.tv_ngaychieu);
        tv_cachieu = dialog_listlichchieu.findViewById(R.id.tv_cachieu);
        tv_malichchieu.setText(MainActivity.database.layDsLichChieu().get(posititon).getMalichchieu());
        tv_phim.setText(MainActivity.database.layDsLichChieu().get(posititon).getMaphim());
        tv_ngaychieu.setText(MainActivity.database.layDsLichChieu().get(posititon).getNgaychieu());
        tv_cachieu.setText(MainActivity.database.layDsLichChieu().get(posititon).getCachieu());
        btn_xoa = dialog_listlichchieu.findViewById(R.id.btn_dialog_xoalichchieu);
        btn_xoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.database.xoaLichChieu(MainActivity.database.layDsLichChieu().get(posititon));
                lichChieuArrayAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, MainActivity.database.layDsLichChieu());
                listView.setAdapter(lichChieuArrayAdapter);
                autoComplete_lichchieu.setAdapter(lichChieuArrayAdapter);
                dialog_listlichchieu.dismiss();
            }
        });

        dialog_listlichchieu.show();


    }

    public void setDialog_them() {
        ArrayAdapter<Phim> phimArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, MainActivity.database.layDsPhim());
        dialog_them = new Dialog(this);
        dialog_them.setContentView(R.layout.custom_dialog_them_lichchieu);
        AutoCompleteTextView autoComplete_phim = dialog_them.findViewById(R.id.autoComplete_maphim);
        EditText editText_ngaychieu = dialog_them.findViewById(R.id.edit_ngaychieu);
        EditText editText_cachieu = dialog_them.findViewById(R.id.edit_cachieu);
        Button btn_themlichchieu = dialog_them.findViewById(R.id.btn_dialog_themlichchieu);
        autoComplete_phim.setAdapter(phimArrayAdapter);
        btn_themlichchieu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LichChieu lichChieu = new LichChieu(autoMaLichChieu(), autoComplete_phim.getText().toString(), editText_ngaychieu.getText().toString(), editText_cachieu.getText().toString());
                MainActivity.database.themLichChieu(lichChieu);
                lichChieuArrayAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, MainActivity.database.layDsLichChieu());
                listView.setAdapter(lichChieuArrayAdapter);
                autoComplete_lichchieu.setAdapter(lichChieuArrayAdapter);
                dialog_them.dismiss();
            }
        });
        dialog_them.show();
    }

    public String autoMaLichChieu() {
        String ma = "MLC";
        int n = 0;
        for (LichChieu lichChieu : MainActivity.database.layDsLichChieu()) {
            if (!(ma + n).equalsIgnoreCase(lichChieu.getMalichchieu())) {
                break;
            } else n += 1;
        }
        return ma + n;
    }

}