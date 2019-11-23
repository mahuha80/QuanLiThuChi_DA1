package com.example.duan1_vinh.ui.ThemKhoanChi;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;

import com.example.duan1_vinh.R;
import com.example.duan1_vinh.ui.FragmentPagerAdapter.KhoanChiPagerAdapter;
import com.google.android.material.tabs.TabLayout;

public class KhoanChiFragment extends Fragment {
    ViewPager vp;
    TabLayout tl;
    private Context context;
    KhoanChiPagerAdapter khoanChiPagerAdapter;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context=context;
    }

    private KhoanChiViewModel khoanChiViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        khoanChiViewModel =
                ViewModelProviders.of(this).get(KhoanChiViewModel.class);
        View root = inflater.inflate(R.layout.fragment_slideshow, container, false);
        vp = root.findViewById(R.id.vp_khoanchi);
        tl = root.findViewById(R.id.tl_khoanchi);
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        khoanChiPagerAdapter=new KhoanChiPagerAdapter(getActivity().getSupportFragmentManager(),context);
        vp.setAdapter(khoanChiPagerAdapter);
        tl.setupWithViewPager(vp);


    }
}