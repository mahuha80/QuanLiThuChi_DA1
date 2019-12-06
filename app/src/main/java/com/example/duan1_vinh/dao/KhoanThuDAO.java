package com.example.duan1_vinh.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.duan1_vinh.database.DatabaseHelper;
import com.example.duan1_vinh.model.KhoanThu;
import com.example.duan1_vinh.model.LoaiThu;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class KhoanThuDAO {
    public static final String TABLE_NAME = "KhoanThuTB";
    public static final String CREATE_TABLE = "CREATE TABLE KhoanThuTB (id integer primary key autoincrement,sotien double,ghichu text,tenloaithu text,ngaygio date )";
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    DatabaseHelper databaseHelper;
    SQLiteDatabase db;
    private Context context;

    public KhoanThuDAO(Context context) {
        this.context = context;
        databaseHelper = new DatabaseHelper(context);
        db = databaseHelper.getWritableDatabase();
    }

    public long insertKhoanThu(KhoanThu khoanThu) throws ParseException {
        ContentValues contentValues = new ContentValues();
        contentValues.put("sotien", khoanThu.getSotien());
        contentValues.put("ghichu", khoanThu.getGhichu());
        contentValues.put("tenloaithu", khoanThu.getLoaiThu().getTenloaithu());
        contentValues.put("ngaygio", simpleDateFormat.format(khoanThu.getNgaygio()));
        return db.insert(TABLE_NAME, null, contentValues);
    }

    public List<KhoanThu> listKhoanThu() throws ParseException {
        List<KhoanThu> list = new ArrayList<>();
        String query = "SELECT * FROM " + TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Double soTien = Double.valueOf(cursor.getString(cursor.getColumnIndex("sotien")));
            String ghiChu = cursor.getString(cursor.getColumnIndex("ghichu"));
            String tenLoaiThu = cursor.getString(cursor.getColumnIndex("tenloaithu"));
            Date ngaygio = simpleDateFormat.parse(cursor.getString(cursor.getColumnIndex("ngaygio")));
            int id=cursor.getInt(0);
            LoaiThu loaiThu = new LoaiThu(tenLoaiThu, 0);
            KhoanThu khoanThu = new KhoanThu(id,soTien, ghiChu, loaiThu, ngaygio);
            list.add(khoanThu);
            cursor.moveToNext();
        }
        return list;
    }

    public int removeKhoanThu(int id) {
        return db.delete(TABLE_NAME, "id=?", new String[]{String.valueOf(id)});
    }
    public double getTongKhoanThuTheoNgay() {
        String query = "select sum(sotien) from KhoanThuTB where strftime('%Y %m %d',ngaygio)=strftime('%Y %m %d',date('now'))";
        Cursor cursor = db.rawQuery(query, null);
        cursor.moveToFirst();
        double sum = cursor.getDouble(0);
        return sum;
    }
}
