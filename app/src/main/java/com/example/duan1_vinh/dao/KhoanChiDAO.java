package com.example.duan1_vinh.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.duan1_vinh.database.DatabaseHelper;
import com.example.duan1_vinh.model.KhoanChi;
import com.example.duan1_vinh.model.LoaiChi;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class KhoanChiDAO {
    public static final String TABLE_NAME = "KhoanChiTB";
    public static final String CREATE_TABLE = "CREATE TABLE KhoanChiTB (id integer primary key autoincrement,sotien double,ghichu text,tenloaichi text,ngaygio date )";
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    DatabaseHelper databaseHelper;
    SQLiteDatabase db;
    private Context context;

    public KhoanChiDAO(Context context) {
        this.context = context;
        databaseHelper = new DatabaseHelper(context);
        db = databaseHelper.getWritableDatabase();
    }

    public long insertKhoanChi(KhoanChi khoanChi) throws ParseException {
        ContentValues contentValues = new ContentValues();
        contentValues.put("sotien", khoanChi.getSotien());
        contentValues.put("ghichu", khoanChi.getGhichu());
        contentValues.put("tenloaichi", khoanChi.getLoaiChi().getTenloaichi());
        contentValues.put("ngaygio", simpleDateFormat.format(khoanChi.getNgaygio()));
        return db.insert(TABLE_NAME, null, contentValues);
    }

    public List<KhoanChi> listKhoanChi() throws ParseException {
        List<KhoanChi> list = new ArrayList<>();
        String query = "SELECT * FROM " + TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Double soTien = Double.valueOf(cursor.getString(cursor.getColumnIndex("sotien")));
            String ghiChu = cursor.getString(cursor.getColumnIndex("ghichu"));
            String tenloaichi = cursor.getString(cursor.getColumnIndex("tenloaichi"));
            Date ngaygio = simpleDateFormat.parse(cursor.getString(cursor.getColumnIndex("ngaygio")));
            LoaiChi loaiChi = new LoaiChi(tenloaichi, 0);
            int id = cursor.getInt(0);
            KhoanChi khoanChi = new KhoanChi(id, soTien, ghiChu, loaiChi, ngaygio);
            list.add(khoanChi);
            cursor.moveToNext();
        }
        return list;
    }

    public int removeKhoanChi(int id) {
        return db.delete(TABLE_NAME, "id=?", new String[]{String.valueOf(id)});
    }

    public double getTongKhoanChiTheoNgay() {
        String query = "select sum(sotien) from KhoanChiTB where strftime('%Y %m %d',ngaygio)=strftime('%Y %m %d',date('now'))";
        Cursor cursor = db.rawQuery(query, null);
        cursor.moveToFirst();
        double sum = cursor.getDouble(0);
        return sum;
    }

    public List<Double> getTongTungThang() {
        List<Double> list = new ArrayList<>();
        for (int i = 1; i <= 12; i++) {
            String month;
            if (i < 10) {
                month = "0" + i;
            } else {
                month = i + "";
            }
            String sSql = "select sum(sotien) from KhoanChiTB where strftime('%m',ngaygio)=strftime('%m',?)";
            Cursor cursor = db.rawQuery(sSql, new String[]{month});
            cursor.moveToFirst();
            while (!cursor.isAfterLast()){
                Double tong=cursor.getDouble(0);
                list.add(tong);
                cursor.moveToNext();
            }
        }
        return list;
    }
}
