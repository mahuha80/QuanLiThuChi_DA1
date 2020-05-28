package com.example.duan1_vinh.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.duan1_vinh.R;
import com.example.duan1_vinh.adapter.KhoanChiTKCTAdapter;
import com.example.duan1_vinh.dao.KhoanChiDAO;
import com.example.duan1_vinh.model.KhoanChi;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class KhoanChi_TKCT extends Fragment {
    private ListView listView;
    private Context context;
    private KhoanChiTKCTAdapter khoanChiTKCTAdapter;
    private KhoanChiDAO khoanChiDAO;
    private SwipeRefreshLayout swipeRefreshLayout;

    @Override
    public void onDestroy() {
        super.onDestroy();
        khoanChiDAO.closeDB();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = LayoutInflater.from(context).inflate(R.layout.fragment_khoanchi_tkct, container, false);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        listView = view.findViewById(R.id.lv_thongkechitiet_khoanchi);
        swipeRefreshLayout=view.findViewById(R.id.pullToRefresh1);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        khoanChiDAO = new KhoanChiDAO(context);
        List<KhoanChi> list = new ArrayList<>();
        try {
            list = khoanChiDAO.listKhoanChi();
        } catch (ParseException e) {
            e.printStackTrace();
            Toast.makeText(context, e.toString(), Toast.LENGTH_SHORT).show();
        }
        try {
            khoanChiTKCTAdapter = new KhoanChiTKCTAdapter(context, list);
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(context, "Loi", Toast.LENGTH_SHORT).show();
        }
        listView.setAdapter(khoanChiTKCTAdapter);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeRefreshLayout.setRefreshing(false);
            }
        });

    }
}
