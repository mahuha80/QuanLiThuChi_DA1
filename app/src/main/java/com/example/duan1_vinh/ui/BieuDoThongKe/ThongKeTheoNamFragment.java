package com.example.duan1_vinh.ui.BieuDoThongKe;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.duan1_vinh.FragmentPagerAdapter.ThongKeTheoNamPagerAdapter;
import com.example.duan1_vinh.R;
import com.google.android.material.tabs.TabLayout;

public class ThongKeTheoNamFragment extends Fragment {
    ViewPager viewPager;
    TabLayout tabLayout;
    ThongKeTheoNamPagerAdapter thongKeTheoNamPagerAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_thongketheonam, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewPager = view.findViewById(R.id.vp_tktn);
        tabLayout = view.findViewById(R.id.tl_tktn);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        thongKeTheoNamPagerAdapter=new ThongKeTheoNamPagerAdapter(getActivity().getSupportFragmentManager());
        viewPager.setAdapter(thongKeTheoNamPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

    }
}
