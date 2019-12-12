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
import com.example.duan1_vinh.dao.LoaiChiDAO;
import com.example.duan1_vinh.model.LoaiChi;
import com.example.duan1_vinh.ui.ThemNhomActivity;

import java.util.ArrayList;
import java.util.List;

public class ChiTieuFragment extends Fragment {
    ListView listView;
    private Context context;
    LoaiChiDAO loaiChiDAO;
    List<LoaiChi> loaiChiList;
    ChiTieuAdapter chiTieuAdapter;
    @Override
    public void onDestroy() {
        super.onDestroy();
        loaiChiDAO.closeDB();
    }
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chitieu, container, false);
        listView = view.findViewById(R.id.lv_chitieufragment);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        loaiChiList = new ArrayList<>();
        loaiChiDAO = new LoaiChiDAO(context);
        loaiChiList = loaiChiDAO.getAllLoaiChi();
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
                intent.putExtra("thuchi","LOAICHI");
                startActivity(intent);
            }
        });
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Intent intent=new Intent(getActivity(),ThemNhomActivity.class);
//                intent.putExtra("sualoaichi","suachi");
//                startActivity(intent);
//            }
//        });
    }

    private void setAdapterForListView() {
        chiTieuAdapter = new ChiTieuAdapter(context,loaiChiList);
        listView.setAdapter(chiTieuAdapter);

    }

    @Override
    public void onResume() {
        super.onResume();
        loaiChiList.clear();
        loaiChiList=loaiChiDAO.getAllLoaiChi();
        chiTieuAdapter.onDataSetChange(loaiChiList);
    }
}
