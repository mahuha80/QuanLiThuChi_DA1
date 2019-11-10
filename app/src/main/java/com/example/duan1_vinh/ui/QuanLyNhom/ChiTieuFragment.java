package com.example.duan1_vinh.ui.QuanLyNhom;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.duan1_vinh.R;

public class ChiTieuFragment extends Fragment {
    ListView listView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_chitieu,container,false);
        listView=view.findViewById(R.id.lv_chitieufragment);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        String [] mang=new String[20];
        for(int i=0;i<20;i++){
            mang[i]=i+1+"";
        }
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<>(getActivity().getApplicationContext(),android.R.layout.simple_list_item_1,mang);
        listView.setAdapter(arrayAdapter);
        ImageView imageView=new ImageView(getActivity().getApplicationContext());
        imageView.setPadding(0,0,800,0);
        imageView.setImageResource(R.drawable.add);
        listView.addFooterView(imageView);
    }
}
