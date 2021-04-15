package com.company.qldatvexemphim;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.company.qldatvexemphim.Activity.DangNhapActivity;
import com.company.qldatvexemphim.CSDL.Database;

public class MainActivity extends AppCompatActivity {

    public static Database database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        database = new Database(getApplicationContext());
        startActivity(new Intent(getApplicationContext(), DangNhapActivity.class));
    }
}