package com.example.duan1_vinh.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.duan1_vinh.R;
import com.example.duan1_vinh.model.KhoanThu;

import java.text.SimpleDateFormat;
import java.util.List;

public class ThongKeChiTietAdapter extends BaseAdapter {
    private Context context;
    private List<KhoanThu> list;
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");


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
        ThongKeChiTietHolder thongKeChiTietHolder = null;
        if (convertView == null) {
            convertView=LayoutInflater.from(context).inflate(R.layout.lv_thongkechitiet,parent,false);
            thongKeChiTietHolder = new ThongKeChiTietHolder();
            thongKeChiTietHolder.tvLoai = convertView.findViewById(R.id.tvLoai_lv);
            thongKeChiTietHolder.tvNote = convertView.findViewById(R.id.tvGhiChu_lv);
            thongKeChiTietHolder.tvSoTien = convertView.findViewById(R.id.tvSoTien_lv);
            thongKeChiTietHolder.tvTime = convertView.findViewById(R.id.tvNgay_lv);
            convertView.setTag(thongKeChiTietHolder);
        } else {
            thongKeChiTietHolder = (ThongKeChiTietHolder) convertView.getTag();
        }
        thongKeChiTietHolder.tvTime.setText(simpleDateFormat.format(list.get(position).getNgaygio()));
        thongKeChiTietHolder.tvSoTien.setText(list.get(position).getSotien() + "");
        thongKeChiTietHolder.tvNote.setText(list.get(position).getGhichu());
        thongKeChiTietHolder.tvLoai.setText(list.get(position).getLoaiThu()+"");
        return convertView;
    }

    public class ThongKeChiTietHolder {
        TextView tvSoTien, tvNote, tvTime, tvLoai;
    }
}
