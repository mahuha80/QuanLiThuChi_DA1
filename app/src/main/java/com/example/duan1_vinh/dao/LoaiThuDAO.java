package com.example.duan1_vinh.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.duan1_vinh.database.DatabaseHelper;

public class LoaiThuDAO {
    public static final String CREATE_TABLE = "CREATE TABLE LoaiThuTB (id integer primarykey autoincrement,tenloaithu text,vitrianh int)";
    DatabaseHelper databaseHelper;
    SQLiteDatabase sqLiteDatabase;
    private Context context;

    public LoaiThuDAO(Context context) {
        this.context=context;
        databaseHelper = new DatabaseHelper(context);
        sqLiteDatabase = databaseHelper.getWritableDatabase();
    }
}
