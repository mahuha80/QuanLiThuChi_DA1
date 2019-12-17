package com.example.duan1_vinh.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.duan1_vinh.database.DatabaseHelper;
import com.example.duan1_vinh.model.LoaiChi;

import java.util.ArrayList;
import java.util.List;

public class LoaiChiDAO {
    DatabaseHelper databaseHelper;
    private Context context;
    SQLiteDatabase db;
    public static final String TABLE_NAME="LoaiChiTB";
    public static final String CREATE_TABLE = "CREATE TABLE LoaiChiTB (tenloaichi text primary key,vitrianh int)";

    public LoaiChiDAO(Context context) {
        this.context=context;
        databaseHelper = new DatabaseHelper(context);
        db = databaseHelper.getWritableDatabase();
        Log.e("DATABASE","open");
    }
    public long insertLoaiChi(LoaiChi loaiChi){
        ContentValues contentValues=new ContentValues();
        contentValues.put("tenloaichi",loaiChi.getTenloaichi());
        contentValues.put("vitrianh",loaiChi.getVitrihinhanh());
        return db.insert(TABLE_NAME,null,contentValues);
    }
    public List<LoaiChi> getAllLoaiChi(){
        List<LoaiChi> loaiChiList=new ArrayList<>();
        String sSql="SELECT * FROM "+TABLE_NAME;
        Cursor cursor=db.rawQuery(sSql,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            String tenloaichi=cursor.getString(0);
            int vitrianh=cursor.getInt(1);
            LoaiChi loaiChi=new LoaiChi(tenloaichi,vitrianh);
            loaiChiList.add(loaiChi);
            cursor.moveToNext();
        }
        cursor.close();
        return loaiChiList;
    }
    public int deleteLoaiChi(String tenloaichi){
        return db.delete(TABLE_NAME,"tenloaichi=?",new String[]{tenloaichi});
    }
    public void closeDB(){
        databaseHelper.close();
        Log.e("DATABASE","close");

    }
}
