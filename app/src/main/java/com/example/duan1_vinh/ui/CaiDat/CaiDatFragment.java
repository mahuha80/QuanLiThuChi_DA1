package com.example.duan1_vinh.ui.CaiDat;

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
import com.example.duan1_vinh.dao.KhoanThuDAO;
import com.example.duan1_vinh.model.KhoanThu;
import com.example.duan1_vinh.ui.ThongKeChiTiet.ThongKeChiTietModel;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class CaiDatFragment extends Fragment {



    private ThongKeChiTietModel thongKeChiTietModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        thongKeChiTietModel =
                ViewModelProviders.of(this).get(com.example.duan1_vinh.ui.ThongKeChiTiet.ThongKeChiTietModel.class);
        View root = inflater.inflate(R.layout.fragment_tools, container, false);
        return root;
    }


}