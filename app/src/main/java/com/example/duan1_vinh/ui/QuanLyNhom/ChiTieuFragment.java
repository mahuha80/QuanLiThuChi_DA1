package com.example.duan1_vinh.ui.QuanLyNhom;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.duan1_vinh.R;
import com.example.duan1_vinh.ui.ThemNhomActivity;

public class ChiTieuFragment extends Fragment {
    ListView listView;
    final int REQUEST_CODE = 111;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chitieu, container, false);
        listView = view.findViewById(R.id.lv_chitieufragment);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        String[] mang = new String[20];
        for (int i = 0; i < 20; i++) {
            mang[i] = i + 1 + "";
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getActivity().getApplicationContext(), android.R.layout.simple_list_item_1, mang);
        listView.setAdapter(arrayAdapter);
        RelativeLayout relativeLayout = new RelativeLayout(getActivity().getApplicationContext());
        ImageView img = new ImageView(getActivity().getApplicationContext());
        img.setImageResource(R.drawable.add);
        TextView textView = new TextView(getActivity().getApplicationContext());
        textView.setText("THÊM NHÓM");
        img.setPadding(24, 0, 0, 0);
        textView.setTextColor(getResources().getColor(R.color.colorPrimary));
        textView.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        textView.setPadding(180, 30, 0, 0);
        relativeLayout.addView(img);
        relativeLayout.addView(textView);
        listView.addFooterView(relativeLayout);
        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ThemNhomActivity.class);
                startActivityForResult(intent,REQUEST_CODE);
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}
