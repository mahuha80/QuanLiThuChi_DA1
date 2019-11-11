package com.example.duan1_vinh.adapter;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.duan1_vinh.R;
import com.example.duan1_vinh.model.LoaiChi;

import java.util.List;

public class ChiTieuAdapter extends BaseAdapter {
    private Context context;
    private List<LoaiChi> listLoaiChi;

    public ChiTieuAdapter(Context context, List<LoaiChi> listLoaiChi) {
        this.context = context;
        this.listLoaiChi = listLoaiChi;
    }

    @Override
    public int getCount() {
        return listLoaiChi.size();
    }

    @Override
    public LoaiChi getItem(int position) {
        return listLoaiChi.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ChiTieuHolder chiTieuHolder = null;
        if (convertView == null) {
            chiTieuHolder = new ChiTieuHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.lv_chitieu, parent, false);
            chiTieuHolder.imgIcon=convertView.findViewById(R.id.imgIcon);
            chiTieuHolder.tvLoai=convertView.findViewById(R.id.tvLoai);
            convertView.setTag(chiTieuHolder);
        } else {
            chiTieuHolder = (ChiTieuHolder) convertView.getTag();
        }
        chiTieuHolder.tvLoai.setText(listLoaiChi.get(position).getTenloaichi());
        chiTieuHolder.imgIcon.setImageBitmap(null);

        return convertView;
    }

    public class ChiTieuHolder {
        TextView tvLoai;
        ImageView imgIcon;

    }
}
