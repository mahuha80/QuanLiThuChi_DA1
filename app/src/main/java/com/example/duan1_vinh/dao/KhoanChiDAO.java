package com.example.duan1_vinh.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.duan1_vinh.database.DatabaseHelper;
import com.example.duan1_vinh.model.KhoanChi;
import com.example.duan1_vinh.model.KhoanThu;
import com.example.duan1_vinh.model.LoaiChi;
import com.example.duan1_vinh.model.LoaiThu;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class KhoanChiDAO {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
    DatabaseHelper databaseHelper;
    private Context context;
    SQLiteDatabase db;
    public static final String TABLE_NAME = "KhoanChiTB";
    public static final String CREATE_TABLE = "CREATE TABLE KhoanChiTB (id integer primary key autoincrement,sotien double,ghichu text,tenloaichi text,ngaygio date )";

    public KhoanChiDAO(Context context) {
        this.context = context;
        databaseHelper = new DatabaseHelper(context);
        db = databaseHelper.getWritableDatabase();
    }

    public long insertKhoanChi(KhoanChi khoanChi) throws ParseException {
        ContentValues contentValues = new ContentValues();
        contentValues.put("sotien",khoanChi.getSotien());
        contentValues.put("ghichu",khoanChi.getGhichu());
        contentValues.put("tenloaichi",khoanChi.getLoaiChi().getTenloaichi());
        contentValues.put("ngaygio", simpleDateFormat.format(khoanChi.getNgaygio()));
        return db.insert(TABLE_NAME,null,contentValues);
    }

    public List<KhoanThu> listKhoanThu() throws ParseException {
        List<KhoanThu> list = new ArrayList<>();
        String query="SELECT * FROM "+TABLE_NAME;
        Cursor cursor=db.rawQuery(query,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            Double soTien= Double.valueOf(cursor.getString(cursor.getColumnIndex("sotien")));
            String ghiChu=cursor.getString(cursor.getColumnIndex("ghichu"));
            String tenLoaiThu=cursor.getString(cursor.getColumnIndex("tenloaithu"));
            Date ngaygio=simpleDateFormat.parse(cursor.getString(cursor.getColumnIndex("ngaygio")));
            LoaiThu loaiThu=new LoaiThu(tenLoaiThu,0);
            KhoanThu khoanThu=new KhoanThu(soTien,ghiChu,loaiThu,ngaygio);
            list.add(khoanThu);
            cursor.moveToNext();
        }
        return list;
    }
}
