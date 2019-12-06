package com.example.duan1_vinh.FragmentPagerAdapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.duan1_vinh.ui.IconFragment;

public class ThemNhomPagerAdapter extends FragmentStatePagerAdapter {
    public ThemNhomPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        return new IconFragment();
    }

    @Override
    public int getCount() {
        return 1;
    }
}
