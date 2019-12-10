package com.example.duan1_vinh.ui.BieuDoThongKe;

import android.content.Context;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.charts.Pie;
import com.example.duan1_vinh.R;
import com.example.duan1_vinh.dao.KhoanChiDAO;
import com.example.duan1_vinh.dao.KhoanThuDAO;

import java.util.ArrayList;
import java.util.List;

public class ThongKeHomNayFragment extends Fragment {
    private Context context;
    KhoanThuDAO khoanThuDAO;
    KhoanChiDAO khoanChiDAO;
    AnyChartView anyChartView;

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
        anyChartView = view.findViewById(R.id.aCV_bdtk);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        khoanChiDAO = new KhoanChiDAO(context);
        khoanThuDAO = new KhoanThuDAO(context);

    }

    @Override
    public void onResume() {
        super.onResume();

        double tongKhoanChiTheoNgay = khoanChiDAO.getTongKhoanChiTheoNgay();
        double tongKhoanThuTheoNgay = khoanThuDAO.getTongKhoanThuTheoNgay();
        double tong = tongKhoanChiTheoNgay + tongKhoanThuTheoNgay;
        Pie pie = AnyChart.pie();
        List<DataEntry> list = new ArrayList<>();
        list.add(new ValueDataEntry("KHOẢN CHI", (tongKhoanChiTheoNgay / tong) * 100));
        list.add(new ValueDataEntry("KHOẢN THU", (tongKhoanThuTheoNgay / tong) * 100));
        pie.title("TỈ LỆ PHẦN TRĂM THU CHI HÔM NAY");
        pie.title().fontColor(CalendarContract.Colors.ACCOUNT_TYPE);
        pie.data(list);

        anyChartView.setChart(pie);
    }
}
