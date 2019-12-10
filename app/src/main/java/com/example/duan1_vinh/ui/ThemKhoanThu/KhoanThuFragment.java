package com.example.duan1_vinh.ui.ThemKhoanThu;

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

import com.example.duan1_vinh.R;
import com.example.duan1_vinh.adapter.LoaiThuSpinnerAdapter;
import com.example.duan1_vinh.dao.KhoanThuDAO;
import com.example.duan1_vinh.dao.LoaiThuDAO;
import com.example.duan1_vinh.model.KhoanThu;
import com.example.duan1_vinh.model.LoaiThu;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class KhoanThuFragment extends Fragment {

    private KhoanThuViewModel khoanThuViewModel;
    Spinner spKhoanThu;
    LoaiThuDAO loaiThuDAO;
    private Context context;
    TextView tvNgayGio;
    ImageView imgCalendar;
    EditText edKhoanTien, edGhiChu;
    LoaiThuSpinnerAdapter loaiThuSpinnerAdapter;
    KhoanThuDAO khoanThuDAO;
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_themkhoanthu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.icon_themkhoanthu:
                String khoanTien = edKhoanTien.getText().toString();
                String ghichu = edGhiChu.getText().toString();
                String ngaygio = tvNgayGio.getText().toString();
                LoaiThu loaiThu = (LoaiThu) spKhoanThu.getSelectedItem();
                KhoanThu khoanThu = null;
                long result = 0;
                if (ngaygio.trim().equals("") && khoanTien.trim().equals("")) {
                    Toast.makeText(context, "Vui lòng điền đẩy đủ các trường ! ", Toast.LENGTH_SHORT).show();
                } else {
                    try {
                        khoanThu = new KhoanThu(Double.parseDouble(khoanTien), ghichu, loaiThu, simpleDateFormat.parse(ngaygio));
                    } catch (ParseException e) {
                    }
                    try {
                        result = khoanThuDAO.insertKhoanThu(khoanThu);
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
        spKhoanThu.setSelection(0);
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        khoanThuViewModel =
                ViewModelProviders.of(this).get(KhoanThuViewModel.class);
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);
        spKhoanThu = root.findViewById(R.id.spKhoanThu);
        tvNgayGio = root.findViewById(R.id.tvNgayGio_khoanthu);
        imgCalendar = root.findViewById(R.id.calendar_khoanthu);
        edKhoanTien = root.findViewById(R.id.edKhoanTien_khoanthu);
        edGhiChu = root.findViewById(R.id.edGhiChu_khoanthu);
        Date calendar = Calendar.getInstance().getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        tvNgayGio.setText(simpleDateFormat.format(calendar));
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //set adapter for spinner
        khoanThuDAO = new KhoanThuDAO(context);
        loaiThuDAO = new LoaiThuDAO(context);
        loaiThuSpinnerAdapter = new LoaiThuSpinnerAdapter(context, loaiThuDAO.getAllLoaiThu());
        spKhoanThu.setAdapter(loaiThuSpinnerAdapter);
        //set date picker dialog for img calendar'
        Calendar calendar = Calendar.getInstance();
        final int day = calendar.get(Calendar.DAY_OF_MONTH);
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


}