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
import com.example.duan1_vinh.dao.LoaiThuDAO;
import com.example.duan1_vinh.model.LoaiChi;
import com.example.duan1_vinh.model.LoaiThu;
import com.example.duan1_vinh.ui.MainActivity;

import java.util.List;

public class ThuNhapAdapter extends BaseAdapter {
    private Context context;
    private List<LoaiThu> listloaiThu;
    private LoaiThuDAO loaiThuDAO;
    public ThuNhapAdapter(Context context, List<LoaiThu> listloaiThu) {
        this.context = context;
        this.listloaiThu = listloaiThu;
        loaiThuDAO=new LoaiThuDAO(context);
    }

    @Override
    public int getCount() {
        return listloaiThu.size();
    }

    @Override
    public LoaiThu getItem(int position) {
        return listloaiThu.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ThuNhapHolder thuNhapHolder=null;
        if (convertView == null) {
            thuNhapHolder = new ThuNhapHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.lv_chitieu, parent, false);
            thuNhapHolder.imgIcon=convertView.findViewById(R.id.imgIcon);
            thuNhapHolder.tvLoai=convertView.findViewById(R.id.tvLoai);
            thuNhapHolder.imgDel=convertView.findViewById(R.id.imgDel);
            convertView.setTag(thuNhapHolder);
        } else {
            thuNhapHolder = (ThuNhapHolder) convertView.getTag();
        }
        thuNhapHolder.tvLoai.setText(listloaiThu.get(position).getTenloaithu());
        final int diaChiHinh = context.getResources().getIdentifier(MainActivity.arrIcon.get(listloaiThu.get(position).getVitrihinhanh()), "drawable", context.getPackageName());
        thuNhapHolder.imgIcon.setImageResource(diaChiHinh);
        thuNhapHolder.imgDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int result=loaiThuDAO.deleteLoaiThu(listloaiThu.get(position).getTenloaithu());
                if(result>0){
                    Toast.makeText(context, "Xóa thành công loại thu", Toast.LENGTH_SHORT).show();
                    listloaiThu.remove(position);
                    notifyDataSetChanged();
                }else{
                    Toast.makeText(context, "Xóa không thành công loại thu", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return convertView;
    }

    public class ThuNhapHolder {
        TextView tvLoai;
        ImageView imgIcon,imgDel;
    }

    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }
    public void onDataSetChange(List<LoaiThu> listloaiThu){
        this.listloaiThu=listloaiThu;
        notifyDataSetChanged();
    }
}
