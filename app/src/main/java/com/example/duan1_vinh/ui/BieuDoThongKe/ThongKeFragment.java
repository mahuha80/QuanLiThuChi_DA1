package com.example.duan1_vinh.ui.BieuDoThongKe;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import com.example.duan1_vinh.R;
import com.google.android.material.tabs.TabLayout;

public class ThongKeFragment extends Fragment {
    ViewPager viewPager;
    TabLayout tabLayout;
    Context context;
    ThongKePagerAdapter thongKePagerAdapter;
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context=context;
    }

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        viewPager=view.findViewById(R.id.vp_fragment_bieuDoThongKe);
        tabLayout=view.findViewById(R.id.tl_fragment_bieuDoThongKe);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        FragmentManager fragmentManager=getActivity().getSupportFragmentManager();
        thongKePagerAdapter=new ThongKePagerAdapter(fragmentManager);
        viewPager.setAdapter(thongKePagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

    }
}