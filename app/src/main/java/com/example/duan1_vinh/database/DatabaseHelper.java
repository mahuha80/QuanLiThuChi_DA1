package com.example.duan1_vinh.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.duan1_vinh.dao.LoaiChiDAO;
import com.example.duan1_vinh.dao.LoaiThuDAO;

public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper(@Nullable Context context) {
        super(context, "QuanLyThuChidb", null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(LoaiChiDAO.CREATE_TABLE);
        db.execSQL(LoaiThuDAO.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
