package com.example.duan1_vinh.ui.FragmentPagerAdapter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.duan1_vinh.IconKhoanChiFragment;
import com.example.duan1_vinh.dao.KhoanChiDAO;
import com.example.duan1_vinh.dao.LoaiChiDAO;

public class KhoanChiPagerAdapter extends FragmentStatePagerAdapter {
    LoaiChiDAO loaiChiDAO;
    private Context context;

    public KhoanChiPagerAdapter(@NonNull FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
        loaiChiDAO = new LoaiChiDAO(context);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return new IconKhoanChiFragment();
    }

    @Override
    public int getCount() {
        int size=loaiChiDAO.getAllLoaiChi().size();
        float pager = ((float)size) / 8;
        float result=pager - (int) pager;
        if (result > 0.01) {
            int pager1=(int) pager;
            return pager1+1;
        } else
            return (int) pager;
    }
}
