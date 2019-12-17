package com.example.duan1_vinh.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.duan1_vinh.R;
import com.example.duan1_vinh.dao.KhoanThuDAO;
import com.example.duan1_vinh.model.KhoanThu;

import java.text.SimpleDateFormat;
import java.util.List;

public class KhoanThuTKCTAdapter extends BaseAdapter {
    private Context context;
    private List<KhoanThu> list;
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
    KhoanThuDAO khoanThuDAO;


    public KhoanThuTKCTAdapter(Context context, List<KhoanThu> list) {
        this.context = context;
        this.list = list;
        khoanThuDAO = new KhoanThuDAO(context);
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        ThongKeChiTietHolder thongKeChiTietHolder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.lv_thongkechitiet, parent, false);
            thongKeChiTietHolder = new ThongKeChiTietHolder();
            thongKeChiTietHolder.tvLoai = convertView.findViewById(R.id.tvLoai_lv);
            thongKeChiTietHolder.tvNote = convertView.findViewById(R.id.tvGhiChu_lv);
            thongKeChiTietHolder.tvSoTien = convertView.findViewById(R.id.tvSoTien_lv);
            thongKeChiTietHolder.tvTime = convertView.findViewById(R.id.tvNgay_lv);
            thongKeChiTietHolder.root = convertView.findViewById(R.id.root);
            convertView.setTag(thongKeChiTietHolder);
        } else {
            thongKeChiTietHolder = (ThongKeChiTietHolder) convertView.getTag();
        }
        thongKeChiTietHolder.tvTime.setText(simpleDateFormat.format(list.get(position).getNgaygio()));
        thongKeChiTietHolder.tvSoTien.setText(list.get(position).getSotien() + "");
        thongKeChiTietHolder.tvNote.setText(list.get(position).getGhichu()+"");
        thongKeChiTietHolder.tvLoai.setText(list.get(position).getLoaiThu() + "");
        final AlertDialog.Builder aleart = new AlertDialog.Builder(context);
        aleart.setTitle("Bạn có muốn xóa khoản thu này ?");
        aleart.setNegativeButton("Huỷ", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(context, list.get(position).getGhichu()+"", Toast.LENGTH_SHORT).show();
            }
        });
        aleart.setPositiveButton("Xóa", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                int result = khoanThuDAO.removeKhoanThu(list.get(position).getId());
                if (result > 0) {
                    Toast.makeText(context, "ok", Toast.LENGTH_SHORT).show();
                    list.remove(position);
                    notifyDataSetChanged();
                } else {
                    Toast.makeText(context, "lol", Toast.LENGTH_SHORT).show();
                }
            }
        });
        thongKeChiTietHolder.root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aleart.show();
            }
        });
        return convertView;
    }

    public static class ThongKeChiTietHolder {
        TextView tvSoTien, tvNote, tvTime, tvLoai;
        RelativeLayout root;
    }

    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }

}
