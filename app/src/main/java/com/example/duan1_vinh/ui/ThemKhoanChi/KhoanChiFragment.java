package com.example.duan1_vinh.ui.ThemKhoanChi;

import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;

import com.example.duan1_vinh.R;
import com.example.duan1_vinh.adapter.LoaiChiSpinnerAdapter;
import com.example.duan1_vinh.dao.KhoanChiDAO;
import com.example.duan1_vinh.dao.LoaiChiDAO;
import com.example.duan1_vinh.model.KhoanChi;
import com.example.duan1_vinh.model.LoaiChi;
import com.example.duan1_vinh.ui.ThemKhoanThu.KhoanThuViewModel;
import com.google.android.material.tabs.TabLayout;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class KhoanChiFragment extends Fragment {
    ViewPager vp;
    TabLayout tl;
    private Context context;
    private KhoanThuViewModel khoanThuViewModel;
    Spinner spKhoanChi;
    LoaiChiDAO loaiChiDao;
    KhoanChiDAO khoanChiDAO;
    TextView tvNgayGio;
    ImageView imgCalendar;
    EditText edKhoanTien, edGhiChu;
    LoaiChiSpinnerAdapter loaiChiSpinnerAdapter;
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private KhoanChiViewModel khoanChiViewModel;

    @Override
    public void onDestroy() {
        super.onDestroy();
        khoanChiDAO.closeDB();
        loaiChiDao.closeDB();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_themkhoanthu, menu);

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.icon_themkhoanthu:
                String khoanTien = edKhoanTien.getText().toString();
                String ghichu = edGhiChu.getText().toString();
                String ngaygio = tvNgayGio.getText().toString();
                LoaiChi loaiChi = (LoaiChi) spKhoanChi.getSelectedItem();
                KhoanChi khoanChi = null;
                long result = 0;
                if (ngaygio.trim().equals("") && khoanTien.trim().equals("")) {
                    Toast.makeText(context, "Vui lòng điền đẩy đủ các trường ! ", Toast.LENGTH_SHORT).show();
                } else {
                    try {
                        khoanChi = new KhoanChi(Double.parseDouble(khoanTien), ghichu, loaiChi, simpleDateFormat.parse(ngaygio));
                    } catch (ParseException e) {
                    }
                    try {
                        result = khoanChiDAO.insertKhoanChi(khoanChi);
                    } catch (ParseException e) {
                        Toast.makeText(context, e.toString(), Toast.LENGTH_SHORT).show();
                        e.printStackTrace();
                        break;
                    }
                    if (result > 0) {
                        Toast.makeText(context, "ok", Toast.LENGTH_SHORT).show();
                        clearForm();

                    } else {
                        Toast.makeText(context, "không thành công", Toast.LENGTH_SHORT).show();
                    }

                }
                break;
        }
        return super.onOptionsItemSelected(item);

    }

    private void clearForm() {
        edKhoanTien.setText("");
        edGhiChu.setText("");
        Date calendar = Calendar.getInstance().getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        tvNgayGio.setText(simpleDateFormat.format(calendar));
        spKhoanChi.setSelection(0);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //set adapter for spinner
        khoanChiDAO = new KhoanChiDAO(context);
        loaiChiDao = new LoaiChiDAO(context);
        loaiChiSpinnerAdapter = new LoaiChiSpinnerAdapter(context, loaiChiDao.getAllLoaiChi());
        spKhoanChi.setAdapter(loaiChiSpinnerAdapter);
        //set date picker dialog for img calendar'
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);
        final DatePickerDialog datePickerDialog = new DatePickerDialog(context, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                String monthTv = "";
                String dayTv = "";
                if ((month + 1) >= 10) {
                    monthTv = (month + 1) + "";
                } else {
                    monthTv = "0" + (month + 1);
                }
                if (dayOfMonth < 10) {
                    dayTv = "0" + dayOfMonth;
                } else {
                    dayTv = dayOfMonth + "";
                }
                tvNgayGio.setText(year + "-" + monthTv + "-" + dayTv);
            }
        }, year, month, day);
        imgCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePickerDialog.show();

            }
        });

    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        khoanChiViewModel =
                ViewModelProviders.of(this).get(KhoanChiViewModel.class);
        View root = inflater.inflate(R.layout.fragment_slideshow, container, false);
        spKhoanChi = root.findViewById(R.id.spKhoanChi);
        tvNgayGio = root.findViewById(R.id.tvNgayGio_khoanchi);
        imgCalendar = root.findViewById(R.id.calendar_khoanchi);
        edKhoanTien = root.findViewById(R.id.edKhoanTien_khoanchi);
        edGhiChu = root.findViewById(R.id.edGhiChu_khoanchi);
        Date calendar = Calendar.getInstance().getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        tvNgayGio.setText(simpleDateFormat.format(calendar));
        return root;
    }
}