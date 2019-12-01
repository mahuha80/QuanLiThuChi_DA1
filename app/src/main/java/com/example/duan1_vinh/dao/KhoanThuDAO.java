package com.example.duan1_vinh.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.duan1_vinh.database.DatabaseHelper;
import com.example.duan1_vinh.model.KhoanChi;
import com.example.duan1_vinh.model.KhoanThu;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class KhoanThuDAO {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
    DatabaseHelper databaseHelper;
    private Context context;
    SQLiteDatabase db;
    public static final String TABLE_NAME = "KhoanThuTB";
    public static final String CREATE_TABLE = "CREATE TABLE KhoanThuTB (id primary key autoincrement,sotien double,ghichu text,tenloaithu text,ngaygio date )";

    public KhoanThuDAO(Context context) {
        this.context = context;
        databaseHelper = new DatabaseHelper(context);
        db = databaseHelper.getWritableDatabase();
    }

    public long insertKhoanChi(KhoanThu khoanThu) throws ParseException {
        ContentValues contentValues = new ContentValues();
        contentValues.put("sotien", khoanThu.getSotien());
        contentValues.put("ghichu", khoanThu.getGhichu());
        contentValues.put("tenloaithu", khoanThu.getLoaiThu().getTenloaithu());
        contentValues.put("ngaygio", simpleDateFormat.format(khoanThu.getNgaygio()));
        return db.insert(TABLE_NAME, null, contentValues);
    }
}
