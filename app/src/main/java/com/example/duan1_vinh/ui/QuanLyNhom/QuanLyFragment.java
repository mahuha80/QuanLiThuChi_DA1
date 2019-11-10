package com.example.duan1_vinh.ui.QuanLyNhom;

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

import com.example.duan1_vinh.R;
import com.example.duan1_vinh.ui.CaiDat.CaiDatViewModel;

public class QuanLyFragment extends Fragment {
    private QuanLyNhomViewModel quanLyNhomViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        quanLyNhomViewModel =
                ViewModelProviders.of(this).get(QuanLyNhomViewModel.class);
        View root = inflater.inflate(R.layout.fragment_branch, container, false);
        return root;
    }
}
