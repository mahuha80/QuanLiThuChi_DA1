package com.example.duan1_vinh.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.duan1_vinh.R;
import com.example.duan1_vinh.dao.LoaiChiDAO;
import com.example.duan1_vinh.dao.LoaiThuDAO;
import com.example.duan1_vinh.model.LoaiChi;
import com.example.duan1_vinh.model.LoaiThu;
import com.example.duan1_vinh.ui.FragmentPagerAdapter.ThemNhomPagerAdapter;
import com.google.android.material.tabs.TabLayout;

public class ThemNhomActivity extends AppCompatActivity {
    ViewPager viewPager;
    ThemNhomPagerAdapter themNhomPagerAdapter;
    TabLayout tabLayout;
    static final String tabName = "CHITIEU";
    EditText edTenNhom;
    LoaiChiDAO loaiChiDAO;
    Intent intent;
    LoaiThuDAO loaiThuDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_nhom);
        intent = getIntent();
        loaiChiDAO = new LoaiChiDAO(this);
        loaiThuDAO = new LoaiThuDAO(this);
        edTenNhom = findViewById(R.id.edTenNhom);
        viewPager = findViewById(R.id.vp_themnhom_activity);
        tabLayout = findViewById(R.id.tl_themnhom_activity);
        themNhomPagerAdapter = new ThemNhomPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(themNhomPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.done, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.done:
                int vitrianh = IconFragment.viTriSelected;
                String tenloaichi = edTenNhom.getText().toString();
                String thuOrChi = intent.getStringExtra("thuchi");
                if (thuOrChi.toLowerCase().equals("loaichi")) {
                    if (tenloaichi.trim().length() > 0 && vitrianh != -1) {
                        LoaiChi loaiChi = new LoaiChi(tenloaichi, vitrianh);
                        if (loaiChiDAO.insertLoaiChi(loaiChi) > 0) {
                            Toast.makeText(this, "Thành công", Toast.LENGTH_SHORT).show();
                            finish();
                            break;
                        } else {
                            Toast.makeText(this, "Thất bại", Toast.LENGTH_SHORT).show();
                        }

                    } else if (edTenNhom.getText().toString().trim().length() == 0) {
                        Toast.makeText(this, "Vui lòng điền tên nhóm ", Toast.LENGTH_SHORT).show();

                    } else {
                        Toast.makeText(this, "Vui lòng chọn icon", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    if (tenloaichi.trim().length() > 0 && vitrianh != -1) {
                        LoaiThu loaiThu = new LoaiThu(tenloaichi, vitrianh);
                        if (loaiThuDAO.insertLoaiThu(loaiThu) > 0) {
                            Toast.makeText(this, "Thành công", Toast.LENGTH_SHORT).show();
                            finish();
                            break;
                        } else {
                            Toast.makeText(this, "Thất bại", Toast.LENGTH_SHORT).show();
                        }

                    } else if (edTenNhom.getText().toString().trim().length() == 0) {
                        Toast.makeText(this, "Vui lòng điền tên nhóm ", Toast.LENGTH_SHORT).show();

                    } else {
                        Toast.makeText(this, "Vui lòng chọn icon", Toast.LENGTH_SHORT).show();
                    }
                }


        }
        return super.onOptionsItemSelected(item);
    }
}
