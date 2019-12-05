package com.example.duan1_vinh.ui.ThongKeChiTiet;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;

import com.example.duan1_vinh.FragmentPagerAdapter.ThongKeChiTietPagerAdapter;
import com.example.duan1_vinh.R;
import com.example.duan1_vinh.dao.KhoanThuDAO;
import com.example.duan1_vinh.model.KhoanThu;
import com.google.android.material.tabs.TabLayout;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class ThongKeChiTietFragment extends Fragment {
    private ThongKeChiTietModel thongKeChiTietModel;
    TabLayout tabLayout;
    ViewPager viewPager;
    private Context context;
    ThongKeChiTietPagerAdapter thongKeChiTietPagerAdapter;


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        thongKeChiTietModel =
                ViewModelProviders.of(this).get(com.example.duan1_vinh.ui.ThongKeChiTiet.ThongKeChiTietModel.class);
        View root = inflater.inflate(R.layout.fragment_share, container, false);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tabLayout = view.findViewById(R.id.tl_tkct);
        viewPager = view.findViewById(R.id.vp_tkct);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        thongKeChiTietPagerAdapter = new ThongKeChiTietPagerAdapter(getActivity().getSupportFragmentManager());
        viewPager.setAdapter(thongKeChiTietPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

    }
}