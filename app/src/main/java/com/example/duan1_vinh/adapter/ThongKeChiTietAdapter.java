package com.example.duan1_vinh.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.duan1_vinh.R;
import com.example.duan1_vinh.model.KhoanThu;

import java.util.List;

public class ThongKeChiTietAdapter extends BaseAdapter {
    private Context context;
    private List<KhoanThu> list;

    public ThongKeChiTietAdapter(Context context, List<KhoanThu> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public KhoanThu getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.lv_thongkechitiet, parent, false);
        return view;
    }

    public class ThongKeChiTietHolder {
        TextView tvSoTien, tvNote, tvTime, tvLoai;
    }
}
