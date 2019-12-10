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
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class ThongKeTheoNamKhoanChiFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_tktn_khoanchi, container, false);
    }

    BarChart barChart;
    Context context;
    KhoanChiDAO khoanChiDAO;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        barChart = view.findViewById(R.id.bc_khoanchi_tktn);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        khoanChiDAO = new KhoanChiDAO(context);


    }

    @Override
    public void onResume() {
        super.onResume();
        BarDataSet barDataSet = new BarDataSet(getAllList(), "DOANH THU TỪNG THÁNG CỦA CỬA HÀNG");
        barDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        BarData barData = new BarData(barDataSet);
        barChart.setData(barData);
        barChart.setFitBars(true);
        barChart.invalidate();
        barChart.animateY(1000);
        XAxis xAxis = barChart.getXAxis();
        xAxis.setLabelCount(12);
    }

    private List<BarEntry> getAllList() {
        List<BarEntry> list = new ArrayList<>();
        for (int i = 0; i < khoanChiDAO.getTongTungThang().size(); i++) {
            double tongTien = khoanChiDAO.getTongTungThang().get(i);
            list.add(new BarEntry(i + 1, (float) tongTien));
        }

        return list;
    }
}
