package com.example.duan1_vinh.ui.ThongKeChiTiet;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.duan1_vinh.R;
import com.example.duan1_vinh.adapter.ThongKeChiTietAdapter;
import com.example.duan1_vinh.dao.KhoanThuDAO;
import com.example.duan1_vinh.model.KhoanThu;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class ThongKeChiTietFragment extends Fragment {
    private ListView listView;
    private Context context;
    private ThongKeChiTietAdapter thongKeChiTietAdapter;
    private KhoanThuDAO khoanThuDAO;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    private ThongKeChiTietModel thongKeChiTietModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        thongKeChiTietModel =
                ViewModelProviders.of(this).get(com.example.duan1_vinh.ui.ThongKeChiTiet.ThongKeChiTietModel.class);
        View root = inflater.inflate(R.layout.fragment_share, container, false);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        listView = view.findViewById(R.id.lv_thongkechitiet);
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
        thongKeChiTietAdapter = new ThongKeChiTietAdapter(context, list);
        listView.setAdapter(thongKeChiTietAdapter);

    }
}