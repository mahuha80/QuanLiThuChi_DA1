package com.example.duan1_vinh.FragmentPagerAdapter;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.PagerAdapter;

import com.example.duan1_vinh.ui.QuanLyNhom.ChiTieuFragment;
import com.example.duan1_vinh.ui.QuanLyNhom.ThuNhapFragment;

public class QuanLyNhomPagerAdapter extends FragmentStatePagerAdapter {
    public QuanLyNhomPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return 2;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if(position==0){
            return new ChiTieuFragment();
        }else{
            return new ThuNhapFragment();
        }
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if(position==0){
            return "CHI TIÊU";
        }else{
            return "THU NHẬP";
        }
    }
}
