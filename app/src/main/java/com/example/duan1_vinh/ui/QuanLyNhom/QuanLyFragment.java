package com.example.duan1_vinh.ui.QuanLyNhom;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;

import com.example.duan1_vinh.R;
import com.example.duan1_vinh.ui.CaiDat.CaiDatViewModel;
import com.google.android.material.tabs.TabLayout;

public class QuanLyFragment extends Fragment {
    private QuanLyNhomViewModel quanLyNhomViewModel;
    private Context context;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private QuanLyNhomPagerAdapter quanLyNhomPagerAdapter;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        quanLyNhomViewModel =
                ViewModelProviders.of(this).get(QuanLyNhomViewModel.class);
        View root = inflater.inflate(R.layout.fragment_branch, container, false);
        tabLayout = root.findViewById(R.id.tl_fragment_quanlinhom);
        viewPager = root.findViewById(R.id.vp_quanlinhom);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tabLayout = view.findViewById(R.id.tl_fragment_quanlinhom);
        viewPager = view.findViewById(R.id.vp_quanlinhom);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    @Override
    public void onResume() {
        super.onResume();
        quanLyNhomPagerAdapter=new QuanLyNhomPagerAdapter(getActivity().getSupportFragmentManager());
        viewPager.setAdapter(quanLyNhomPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}
