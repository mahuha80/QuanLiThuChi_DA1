package com.example.duan1_vinh.FragmentPagerAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.duan1_vinh.ui.BieuDoThongKe.ThongKeTheoNamKhoanChiFragment;
import com.example.duan1_vinh.ui.BieuDoThongKe.ThongKeTheoNamKhoanThuFragment;

public class ThongKeTheoNamPagerAdapter extends FragmentStatePagerAdapter {
    public ThongKeTheoNamPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new ThongKeTheoNamKhoanChiFragment();
        } else {
            return new ThongKeTheoNamKhoanThuFragment();
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) return "Khoản chi từng tháng trong năm";
        else return "Khoản thu từng tháng trong năm";
    }
}
