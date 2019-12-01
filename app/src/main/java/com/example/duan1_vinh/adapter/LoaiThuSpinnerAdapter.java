package com.example.duan1_vinh.adapter;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import com.example.duan1_vinh.R;
import com.example.duan1_vinh.model.LoaiThu;
import com.example.duan1_vinh.ui.MainActivity;

import java.util.List;

public class LoaiThuSpinnerAdapter implements SpinnerAdapter {
    private Context context;
    private List<LoaiThu> list;

    public LoaiThuSpinnerAdapter(Context context, List<LoaiThu> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.sp_generic_loaithuchi, parent, false);
        ImageView img=view.findViewById(R.id.img_sp);
        TextView tv=view.findViewById(R.id.tv_sp);
        final int hinh = context.getResources().getIdentifier(MainActivity.arrIcon.get(list.get(position).getVitrihinhanh()), "drawable", context.getPackageName());
        img.setImageResource(hinh);
        tv.setText(list.get(position).getTenloaithu());
        return view;
    }


    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public LoaiThu getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.sp_generic_loaithuchi, parent, false);
        ImageView img=view.findViewById(R.id.img_sp);
        TextView tv=view.findViewById(R.id.tv_sp);
        final int hinh = context.getResources().getIdentifier(MainActivity.arrIcon.get(list.get(position).getVitrihinhanh()), "drawable", context.getPackageName());
        img.setImageResource(hinh);
        tv.setText(list.get(position).getTenloaithu());
        return view;
    }

    @Override
    public int getItemViewType(int position) {
        return 1;
    }

    @Override
    public int getViewTypeCount() {
        return 1;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void registerDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {

    }

}
