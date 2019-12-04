package com.example.duan1_vinh.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.duan1_vinh.R;
import com.example.duan1_vinh.dao.LoaiChiDAO;
import com.example.duan1_vinh.model.LoaiChi;
import com.example.duan1_vinh.ui.MainActivity;

import java.util.List;

public class ChiTieuAdapter extends BaseAdapter {
    private Context context;
    private List<LoaiChi> listLoaiChi;
    private LoaiChiDAO loaiChiDAO;
    public ChiTieuAdapter(Context context, List<LoaiChi> listLoaiChi) {
        this.context = context;
        this.listLoaiChi = listLoaiChi;
        loaiChiDAO=new LoaiChiDAO(context);
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        ChiTieuHolder chiTieuHolder = null;
        if (convertView == null) {
            chiTieuHolder = new ChiTieuHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.lv_chitieu, parent, false);
            chiTieuHolder.imgIcon=convertView.findViewById(R.id.imgIcon);
            chiTieuHolder.tvLoai=convertView.findViewById(R.id.tvLoai);
            chiTieuHolder.imgDel=convertView.findViewById(R.id.imgDel);
            convertView.setTag(chiTieuHolder);
        } else {
            chiTieuHolder = (ChiTieuHolder) convertView.getTag();
        }
        chiTieuHolder.tvLoai.setText(listLoaiChi.get(position).getTenloaichi());
        final int hinh = context.getResources().getIdentifier(MainActivity.arrIcon.get(listLoaiChi.get(position).getVitrihinhanh()), "drawable", context.getPackageName());
        chiTieuHolder.imgIcon.setImageResource(hinh);
        chiTieuHolder.imgDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int result=loaiChiDAO.deleteLoaiChi(listLoaiChi.get(position).getTenloaichi());
                if(result>0){
                    Toast.makeText(context, "Xóa thành công loại chi", Toast.LENGTH_SHORT).show();
                    listLoaiChi.remove(position);
                    notifyDataSetChanged();
                }else{
                    Toast.makeText(context, "Xóa không thành công loại chi", Toast.LENGTH_SHORT).show();
                }            }
        });

        return convertView;
    }

    public class ChiTieuHolder {
        TextView tvLoai;
        ImageView imgIcon,imgDel;
    }

    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }
    public void onDataSetChange(List<LoaiChi> listLoaiChi){
        this.listLoaiChi=listLoaiChi;
        notifyDataSetChanged();
    }
}
