package com.example.duan1_vinh.ui.BieuDoThongKe;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.duan1_vinh.R;
import com.example.duan1_vinh.dao.KhoanChiDAO;
import com.example.duan1_vinh.dao.KhoanThuDAO;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class ThongKeHomNayFragment extends Fragment {
    private Context context;
    private PieChart pieChart;
    KhoanThuDAO khoanThuDAO;
    KhoanChiDAO khoanChiDAO;
    List<PieEntry> pieEntryList;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_thongkehomnay, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        pieChart = view.findViewById(R.id.pc_bdtk_ngay);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        pieEntryList = new ArrayList<>();
        khoanChiDAO = new KhoanChiDAO(context);
        khoanThuDAO = new KhoanThuDAO(context);
        double tongKhoanChiTheoNgay = khoanChiDAO.getTongKhoanChiTheoNgay();
        double tongKhoanThuTheoNgay = khoanThuDAO.getTongKhoanThuTheoNgay();
        double tong=tongKhoanChiTheoNgay+tongKhoanThuTheoNgay;
        pieEntryList.add(new PieEntry((float) (tongKhoanChiTheoNgay/tong*100),"KHOẢN CHI"));
        pieEntryList.add(new PieEntry((float) (tongKhoanThuTheoNgay/tong*100),"KHOẢN THU"));
        pieChart.setDrawCenterText(false);
        PieDataSet pieDataSet=new PieDataSet(pieEntryList,"TỈ LỆ % THU/CHI");
        pieDataSet.setValueLineColor(R.color.orange);
        pieDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        PieData pieData=new PieData(pieDataSet);
        pieChart.setData(pieData);
        pieChart.getDescription().setText("PH08047");
        pieChart.animateXY(2500, 2500);
        pieChart.invalidate();

    }
}
