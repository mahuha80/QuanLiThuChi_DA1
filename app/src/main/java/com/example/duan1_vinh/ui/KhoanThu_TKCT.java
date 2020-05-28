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
import com.example.duan1_vinh.adapter.KhoanThuTKCTAdapter;
import com.example.duan1_vinh.dao.KhoanThuDAO;
import com.example.duan1_vinh.model.KhoanThu;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class KhoanThu_TKCT extends Fragment {
    private ListView listView;
    private Context context;
    private KhoanThuTKCTAdapter khoanThuTKCTAdapter;
    private KhoanThuDAO khoanThuDAO;
    private SwipeRefreshLayout swipeRefreshLayout;

    @Override
    public void onDestroy() {
        super.onDestroy();
        khoanThuDAO.closeDB();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = LayoutInflater.from(context).inflate(R.layout.fragment_khoanthu_tkct, container, false);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        listView = view.findViewById(R.id.lv_thongkechitiet_khoanthu);
        swipeRefreshLayout = view.findViewById(R.id.pullToRefresh);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        khoanThuDAO = new KhoanThuDAO(context);
        List<KhoanThu> list = new ArrayList<>();
        try {
            list = khoanThuDAO.listKhoanThu();
        } catch (ParseException e) {
            e.printStackTrace();
            Toast.makeText(context, e.toString(), Toast.LENGTH_SHORT).show();
        }
        khoanThuTKCTAdapter = new KhoanThuTKCTAdapter(context, list);
        listView.setAdapter(khoanThuTKCTAdapter);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeRefreshLayout.setRefreshing(false);
            }
        });


    }
}
