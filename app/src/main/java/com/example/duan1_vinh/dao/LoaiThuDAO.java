package com.example.duan1_vinh.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.duan1_vinh.database.DatabaseHelper;
import com.example.duan1_vinh.model.LoaiChi;
import com.example.duan1_vinh.model.LoaiThu;

import java.util.ArrayList;
import java.util.List;

public class LoaiThuDAO {
    public static final String TABLE_NAME="LoaiThuTB";
    public static final String CREATE_TABLE = "CREATE TABLE LoaiThuTB (tenloaithu text primary key,vitrianh int)";
    DatabaseHelper databaseHelper;
    SQLiteDatabase db;
    private Context context;

    public LoaiThuDAO(Context context) {
        this.context=context;
        databaseHelper = new DatabaseHelper(context);
        db = databaseHelper.getWritableDatabase();
    }
    public long insertLoaiThu(LoaiThu loaiThu){
        ContentValues contentValues=new ContentValues();
        contentValues.put("tenloaithu",loaiThu.getTenloaithu());
        contentValues.put("vitrianh",loaiThu.getVitrihinhanh());
        return db.insert(TABLE_NAME,null,contentValues);
    }
    public List<LoaiThu> getAllLoaiThu(){
        List<LoaiThu> loaiThuList=new ArrayList<>();
        String sSql="SELECT * FROM "+TABLE_NAME;
        Cursor cursor=db.rawQuery(sSql,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            String tenloathu=cursor.getString(0);
            int vitrianh=cursor.getInt(1);
            LoaiThu loaiThu=new LoaiThu(tenloathu,vitrianh);
            loaiThuList.add(loaiThu);
            cursor.moveToNext();
        }
        return loaiThuList;
    }
}
