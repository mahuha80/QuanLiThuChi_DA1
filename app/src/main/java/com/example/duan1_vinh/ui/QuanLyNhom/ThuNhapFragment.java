package com.example.duan1_vinh.ui.QuanLyNhom;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.duan1_vinh.R;
import com.example.duan1_vinh.adapter.ChiTieuAdapter;
import com.example.duan1_vinh.adapter.ThuNhapAdapter;
import com.example.duan1_vinh.dao.LoaiChiDAO;
import com.example.duan1_vinh.dao.LoaiThuDAO;
import com.example.duan1_vinh.model.LoaiChi;
import com.example.duan1_vinh.model.LoaiThu;
import com.example.duan1_vinh.ui.ThemNhomActivity;

import java.util.ArrayList;
import java.util.List;

public class ThuNhapFragment extends Fragment {
    ListView listView;
    private Context context;
    LoaiThuDAO loaiThuDAO;
    List<LoaiThu> loaiThuList;
    ThuNhapAdapter thuNhapAdapter;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context=context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_thunhap,container,false);
        listView=view.findViewById(R.id.lv_thunhapfragment);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        loaiThuList = new ArrayList<>();
        loaiThuDAO = new LoaiThuDAO(context);
        loaiThuList = loaiThuDAO.getAllLoaiThu();
        setAdapterForListView();
        addFooterForListView();
    }

    private void addFooterForListView() {
        RelativeLayout relativeLayout = new RelativeLayout(getActivity().getApplicationContext());
        ImageView img = new ImageView(getActivity().getApplicationContext());
        img.setImageResource(R.drawable.add);
        TextView textView = new TextView(getActivity().getApplicationContext());
        textView.setText("THÊM NHÓM");
        img.setPadding(24, 0, 0, 0);
        textView.setTextColor(getResources().getColor(R.color.colorPrimary));
        textView.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        textView.setPadding(180, 30, 0, 0);
        relativeLayout.addView(img);
        relativeLayout.addView(textView);
        listView.addFooterView(relativeLayout);
        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ThemNhomActivity.class);
                intent.putExtra("thuchi","LOAITHU");
                startActivity(intent);
            }
        });
    }
    private void setAdapterForListView() {
        thuNhapAdapter = new ThuNhapAdapter(context, loaiThuList);
        listView.setAdapter(thuNhapAdapter);

    }

    @Override
    public void onResume() {
        super.onResume();
        loaiThuList.clear();
        loaiThuList = loaiThuDAO.getAllLoaiThu();
        thuNhapAdapter.onDataSetChange(loaiThuList);
    }

}
