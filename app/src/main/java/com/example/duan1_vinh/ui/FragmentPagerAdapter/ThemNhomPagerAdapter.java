package com.example.duan1_vinh.ui.FragmentPagerAdapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.duan1_vinh.ui.ColorFragment;
import com.example.duan1_vinh.ui.IconFragment;

public class ThemNhomPagerAdapter extends FragmentStatePagerAdapter {
    public ThemNhomPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new IconFragment();
        } else {
            return new ColorFragment();
        }
    }

    @Override
    public int getCount() {
        return 2;
    }
}
