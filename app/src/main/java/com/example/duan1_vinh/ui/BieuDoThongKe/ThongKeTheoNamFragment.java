package com.example.duan1_vinh.ui.BieuDoThongKe;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.duan1_vinh.R;
import com.example.duan1_vinh.dao.KhoanChiDAO;
import com.example.duan1_vinh.dao.KhoanThuDAO;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class ThongKeTheoNamFragment extends Fragment {
    KhoanThuDAO khoanThuDAO;
    private Context context;
    TextView textView;
    KhoanChiDAO khoanChiDAO;
    BarChart barChart;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_thongketheonam, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        barChart = view.findViewById(R.id.bc_bdtk);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        khoanThuDAO = new KhoanThuDAO(context);
        khoanChiDAO = new KhoanChiDAO(context);
    }

    @Override
    public void onResume() {
        super.onResume();
        barChart.setDrawValueAboveBar(true);
        barChart.setMaxVisibleValueCount(50);
        barChart.setPinchZoom(false);
        barChart.setDrawGridBackground(true);
        ArrayList<BarEntry> barEntriesChi = new ArrayList<>();
        List<Double> listKhoanChi = khoanChiDAO.getTongTungThang();
        for (int i = 0; i < listKhoanChi.size(); i++) {
            barEntriesChi.add(new BarEntry(i + 1, listKhoanChi.get(i).floatValue()));
        }
        BarDataSet barDataSet = new BarDataSet(barEntriesChi, "Khoản Chi");
        barDataSet.setColors(ColorTemplate.COLORFUL_COLORS);

        BarDataSet barDataSet1 = new BarDataSet(barEntriesChi, "Khoản Thu");
        barDataSet1.setColors(ColorTemplate.LIBERTY_COLORS);
        ArrayList<BarEntry> barEntriesThu = new ArrayList<>();
        for (int i = 0; i < listKhoanChi.size(); i++) {
            barEntriesChi.add(new BarEntry(i + 1, listKhoanChi.get(i).floatValue()));
        }
        float groupSpace=0.1f;
        float barSpace=0.02f;
        float barWidth=0.43f;
        BarData barData = new BarData(barDataSet,barDataSet1);
        barChart.setData(barData);

        barData.setBarWidth(barWidth);
        barData.groupBars(1,groupSpace,barSpace);
        barData.setBarWidth(0.9f);
        XAxis xAxis = barChart.getXAxis();
        String[] months = new String[]{"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        xAxis.setValueFormatter(new MyXAxisValueFormatter(months));
        xAxis.setPosition(XAxis.XAxisPosition.TOP);


    }

    public class MyXAxisValueFormatter implements IAxisValueFormatter {
        String[] mValues;

        public MyXAxisValueFormatter(String[] values) {
            this.mValues=values;
        }

        @Override
        public String getFormattedValue(float value, AxisBase axis) {
            return mValues[(int) value-1];
        }
    }
}
