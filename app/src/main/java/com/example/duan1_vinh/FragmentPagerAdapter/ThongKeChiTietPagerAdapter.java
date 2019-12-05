package com.example.duan1_vinh.FragmentPagerAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.duan1_vinh.ui.KhoanChi_TKCT;
import com.example.duan1_vinh.ui.KhoanThu_TKCT;

public class ThongKeChiTietPagerAdapter extends FragmentStatePagerAdapter {
    public ThongKeChiTietPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return "Khoản Chi";
        } else {
            return "Khoản Thu";
        }
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new KhoanChi_TKCT();
        } else {
            return new KhoanThu_TKCT();
        }
    }

    @Override
    public int getCount() {
        return 2;
    }
}
