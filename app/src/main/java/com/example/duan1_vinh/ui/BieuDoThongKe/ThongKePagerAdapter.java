package com.example.duan1_vinh.ui.BieuDoThongKe;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ThongKePagerAdapter extends FragmentPagerAdapter {
    public ThongKePagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new ThongKeHomNayFragment();
        } else if (position == 1) {
            return new ThongKeTheoThangFragment();
        } else {
            return new ThongKeTheoNamFragment();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        if (position == 0) {
            return "HÔM NAY";
        } else if (position == 1) {
            return "THÁNG";
        } else {
            return "NĂM";
        }
    }
}
