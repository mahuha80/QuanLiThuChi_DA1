package com.example.duan1_vinh.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.duan1_vinh.database.DatabaseHelper;

public class LoaiChiDAO {
    DatabaseHelper databaseHelper;
    private Context context;
    SQLiteDatabase sqLiteDatabase;
    public static final String CREATE_TABLE = "CREATE TABLE LoaiChiTB (id integer primarykey autoincrement,tenloaichi text,vitrianh int)";

    public LoaiChiDAO(Context context) {
        this.context=context;
        databaseHelper = new DatabaseHelper(context);
        sqLiteDatabase = databaseHelper.getWritableDatabase();
    }

}
